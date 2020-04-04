package com.example.SDao.ISDao;

import com.example.entity.UserInfo;

public interface ISUserDao {
     UserInfo selectUserInfoByTelePhone(String telePhone);
     Boolean insertUserInfo(UserInfo userInfo);
     Boolean selectUserByTele(String userTele);
     Boolean updatePasswordByTele(UserInfo userInfo);
}
