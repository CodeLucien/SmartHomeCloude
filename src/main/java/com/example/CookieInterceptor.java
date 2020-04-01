package com.example;

import com.example.entity.TokenPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import util.ResponseInfo;
import util.TokenManager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenPojo tokenPojo;
    @Autowired
    private ObjectMapper mapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        ResponseInfo responseInfo = new ResponseInfo();
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("accessToken")) {
//                    String cookieStr = cookie.getValue();
//                    try {
//                        Claims claims = TokenManager.parseJWT(cookieStr);
//                        tokenPojo.setTelePhone((String) claims.get("telePhone"));
//                        tokenPojo.setUserName((String) claims.get("userName"));
//                        return true;
//                    }catch (Exception ex){
//                        System.out.println(ex);
//                        responseInfo.setCode(10001);
//                        responseInfo.setMsg("token无效");
//                        response.getWriter().write(mapper.writeValueAsString(responseInfo));
//                        return false;
//                    }
//                }
//            }
//            System.out.println("no access_token");
//            responseInfo.setCode(10002);
//            responseInfo.setMsg("no access_token");
//            response.getWriter().write(mapper.writeValueAsString(responseInfo));
//            return false;
//        }else{
//            System.out.println("no cookie");
//            responseInfo.setCode(10003);
//            responseInfo.setMsg("no cookie");
//            response.getWriter().write(mapper.writeValueAsString(responseInfo));
//            return false;
//        }
        return true;
    }
}