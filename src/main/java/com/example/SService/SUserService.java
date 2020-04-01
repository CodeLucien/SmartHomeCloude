package com.example.SService;

import com.example.SDao.SUserDao;
import com.example.SService.ISService.ISUserService;
import com.example.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SUserService implements ISUserService {
    @Autowired
    private SUserDao sUserDao;
    @Override
    public UserInfo findUserInfoByTelePhone(String telePhone) {
        if (telePhone == null)
            return null;
        return sUserDao.selectUserInfoByTelePhone(telePhone);
    }

    @Override
    public Boolean addUserInfo(UserInfo userInfo) {
        if (userInfo == null)
            return false;
        return sUserDao.insertUserInfo(userInfo);
    }

    @Override
    public Boolean findUserByTele(String userTele) {
        if (userTele == null)
            return false;
        return sUserDao.selectUserByTele(userTele);
    }
}
