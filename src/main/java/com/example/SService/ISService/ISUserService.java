package com.example.SService.ISService;

import com.example.entity.UserInfo;

public interface ISUserService {
    public UserInfo findUserInfoByTelePhone(String telePhone);
    public Boolean addUserInfo(UserInfo userInfo);
    public Boolean findUserByTele(String userTele);
}
