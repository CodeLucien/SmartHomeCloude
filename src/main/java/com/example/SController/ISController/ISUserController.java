package com.example.SController.ISController;

import com.example.entity.UserInfo;

public interface ISUserController {
    public void login(String telePhone,String password);
    public void createUserInfo(UserInfo userInfo);
    public void isExistOfUser(String userTele);
}
