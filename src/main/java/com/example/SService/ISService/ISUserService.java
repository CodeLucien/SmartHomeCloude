package com.example.SService.ISService;

import com.example.entity.UserInfo;

public interface ISUserService {
     UserInfo findUserInfoByTelePhone(String telePhone);
     Boolean addUserInfo(UserInfo userInfo);
     Boolean findUserByTele(String userTele);
     Boolean modifyPasswordByTele(UserInfo userInfo);
}
