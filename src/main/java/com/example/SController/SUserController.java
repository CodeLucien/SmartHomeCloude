package com.example.SController;

import com.example.SController.ISController.ISUserController;
import com.example.SService.SUserService;
import com.example.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import util.Common;
import util.ResponseInfo;
import util.TokenManager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/user")
public class  SUserController implements ISUserController {

    @Autowired
    private SUserService sUserService;

    //登录
    @RequestMapping(value = "/login")
    @Override
    public void login(@RequestParam String telePhone, @RequestParam String password) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        UserInfo userInfo = sUserService.findUserInfoByTelePhone(telePhone);
        if (userInfo == null) {
            responseInfo.setCode(0);
            responseInfo.setBody(userInfo);
            responseInfo.setMsg("无此用户");
        }else {

            if (userInfo.getPassWord().equals(password)){
                responseInfo.setMsg("登录成功");
                String accessToken = TokenManager.createJwtToken(userInfo.getTelePhone(), userInfo.getUserName());
                Cookie cookie=new Cookie("accessToken",accessToken);
                responseInfo.setCode(1);
                responseInfo.setBody(userInfo);
                response.addCookie(cookie);
            }else {
                responseInfo.setMsg("登录失败");
                responseInfo.setCode(0);
                responseInfo.setBody(null);
            }

        }

        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    //注册用户
    @RequestMapping(value = "/createUserInfo")
    @Override
    public void createUserInfo(@RequestBody UserInfo userInfo) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        if(userInfo == null){
            responseInfo.setCode(Common.Result.FALL.id);
            responseInfo.setMsg("无此用户");
        }else{
            boolean createResult = sUserService.addUserInfo(userInfo);
//            = sUserService.(facilityInfo);
            if(!createResult){
                responseInfo.setMsg("注册失败");
            }else{
                responseInfo.setMsg("注册成功");
            }
            responseInfo.setCode(Common.Result.SUCCESS.id);
            responseInfo.setBody(createResult);
        }
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //查找用户
    @RequestMapping(value = "/isExistOfUser")
    @Override
    public void isExistOfUser(@RequestParam String telePhone) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        if(telePhone == null){
//            System.out.println("---aaaa----");
            responseInfo.setCode(Common.Result.FALL.id);
            responseInfo.setMsg("无此用户");
        }else{
//            System.out.println("---bbb----");
            boolean selectResult = sUserService.findUserByTele(telePhone);
//            = sUserService.(facilityInfo);
            if(selectResult == false){
                responseInfo.setMsg(telePhone);
            }else{
                responseInfo.setMsg("用户已存在");
            }
            responseInfo.setCode(Common.Result.SUCCESS.id);
            responseInfo.setBody(selectResult);
        }
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //修改密码
    @RequestMapping(value = "/changePasswordByTele")
    @Override
    public void changePassword(@RequestBody UserInfo userInfo) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        if(userInfo == null){
            responseInfo.setCode(Common.Result.FALL.id);
            responseInfo.setMsg("无此用户");
        }else{
            System.out.println("aaaa");
            boolean changeResult = sUserService.modifyPasswordByTele(userInfo);
            if (changeResult){
                responseInfo.setMsg("修改成功");
            }else {
                responseInfo.setMsg("修改失败");
            }
            responseInfo.setCode(Common.Result.SUCCESS.id);
            responseInfo.setBody(changeResult);
        }
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
