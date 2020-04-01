package com.example.entity;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
//设置跟着session来，多用户登录时不会搞错token
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component(value = "TokenPojo")
public class TokenPojo implements Serializable {
    private static final long serialVersionUID = 9134726889277808512L;
    private String telePhone;
    private String userName;

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
