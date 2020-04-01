package com.example.SDao.ISDao;

import com.example.entity.HomeRelationshipInfo;

import java.util.List;

public interface ISHomeRelationshipInfoDao {
    public boolean insertHomeRelationshipInfo(HomeRelationshipInfo homeRelationshipInfo);
    public List<HomeRelationshipInfo> selectHomeRelationshipInfoByHomeId(int homeId);
    public List<HomeRelationshipInfo> selectHomeRelationshipInfoByTelephone(String telePhone);
    public HomeRelationshipInfo selectHomeRelationshipInfoByTelephoneAndHomeId(String telePhone, int homeId);
    public boolean deletHomeRelationshipInfoByHomeId(int homeId);//户主删除这个家的全部家庭关系
    public boolean deletHomeRelationshipInfoByTelephoneAndHomeId(String telePhone,int homeId);//普通家庭成员只能删除本人的关系
    public boolean updateHomeRelationshipInfo(HomeRelationshipInfo homeRelationshipInfo);
}
