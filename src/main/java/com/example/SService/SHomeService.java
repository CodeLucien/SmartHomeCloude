package com.example.SService;

import com.example.SDao.SHomeDao;
import com.example.SDao.SHomeRelationshipInfoDao;
import com.example.SService.ISService.ISHomeService;
import com.example.entity.HomeInfo;
import com.example.entity.HomeRelationshipInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SHomeService implements ISHomeService {
    @Autowired
    private SHomeDao sHomeDao;
    @Autowired
    private SHomeRelationshipInfoDao sHomeRelationshipInfoDao;
    @Override
    public boolean addHomeInfo(HomeInfo homeInfo) {
        if (homeInfo!=null)
            sHomeDao.insertHomeInfo(homeInfo);
        return false;
    }

    @Override
    public HomeInfo findHomeInfoByHomeId(int homeId) {
        return sHomeDao.selectHomeInfoByHomeId(homeId);
    }

    @Override
    public boolean removeHomeInfoByHomeId(int homeId) {
        return sHomeDao.deletHomeInfoByHomeId(homeId);
    }

    @Override
    public boolean modifyHomeInfo(HomeInfo homeInfo) {
        if (homeInfo!=null)
            return sHomeDao.updateHomeInfo(homeInfo);
        return false;
    }

    @Override
    public List<HomeInfo> findHomeInfosByTelePhone(String telePhone) {
        if (telePhone!=null)
            return sHomeDao.selectHomeInfosByTelePhone(telePhone);
        return null;
    }

    /**
     * HomeRelationship
     *
     * */

    @Override
    public boolean addHomeRelationshipInfo(HomeRelationshipInfo homeRelationshipInfo) {
        if (homeRelationshipInfo!=null)
            return sHomeRelationshipInfoDao.insertHomeRelationshipInfo(homeRelationshipInfo);
        return false;
    }

    @Override
    public List<HomeRelationshipInfo> findHomeRelationshipInfoByHomeId(int homeId) {
        return sHomeRelationshipInfoDao.selectHomeRelationshipInfoByHomeId(homeId);
    }

    @Override
    public List<HomeRelationshipInfo> findHomeRelationshipInfoByTelephone(String telePhone) {
        if (telePhone!=null)
            return sHomeRelationshipInfoDao.selectHomeRelationshipInfoByTelephone(telePhone);
        return null;
    }

    @Override
    public HomeRelationshipInfo findHomeRelationshipInfoByTelephoneAndHomeId(String telePhone, int homeId) {
        if (telePhone!=null)
            return sHomeRelationshipInfoDao.selectHomeRelationshipInfoByTelephoneAndHomeId(telePhone,homeId);
        return null;
    }

    @Override
    public boolean removeHomeRelationshipInfoByHomeId(int homeId) {
        return sHomeRelationshipInfoDao.deletHomeRelationshipInfoByHomeId(homeId);
    }

    @Override
    public boolean removeHomeRelationshipInfoByTelephoneAndHomeId(String telePhone, int homeId) {
        if (telePhone!=null)
            return sHomeRelationshipInfoDao.deletHomeRelationshipInfoByTelephoneAndHomeId(telePhone,homeId);
        return false;
    }

    @Override
    public boolean modifyHomeRelationshipInfo(HomeRelationshipInfo homeRelationshipInfo) {
        if (homeRelationshipInfo!=null)
            return sHomeRelationshipInfoDao.updateHomeRelationshipInfo(homeRelationshipInfo);
        return false;
    }
}
