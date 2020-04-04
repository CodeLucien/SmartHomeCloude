package com.example.SController.ISController;

import com.example.entity.UserInfo;

public interface ISUserController {
     void login(String telePhone,String password);
     void createUserInfo(UserInfo userInfo);
     void isExistOfUser(String userTele);
     void changePassword(UserInfo userInfo);
}
