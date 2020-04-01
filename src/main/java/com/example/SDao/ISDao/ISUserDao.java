package com.example.SDao.ISDao;

import com.example.entity.UserInfo;

public interface ISUserDao {
    public UserInfo selectUserInfoByTelePhone(String telePhone);
    public Boolean insertUserInfo(UserInfo userInfo);
    public Boolean selectUserByTele(String userTele);
}
