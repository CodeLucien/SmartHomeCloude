package util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenManager {
    public static final String SECRET = "admin";//密钥，自己设

    public static String createJwtToken(String telePhone, String userName) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("telePhone", telePhone);
        claims.put("userName", userName);
        long ttlMillis = 10800000;    //默认1小时
        return createJwtToken(claims, ttlMillis);
    }

    public static String createJwtToken(String telePhone, String userName, long ttlMillis) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("telePhone", telePhone);
        claims.put("userName", userName);
        return createJwtToken(claims, ttlMillis);
    }

    public static String createJwtToken(Map<String, Object> claims, long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        int jwt_id = (int) (1 + Math.random() * (1000000));
        JwtBuilder builder = Jwts.builder().setClaims(claims)
                .setId(String.valueOf(jwt_id))
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, signingKey);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    public static Claims parseJWT(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }
}