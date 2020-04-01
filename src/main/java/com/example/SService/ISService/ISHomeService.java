package com.example.SService.ISService;

import com.example.entity.HomeInfo;
import com.example.entity.HomeRelationshipInfo;
import java.util.List;


public interface ISHomeService {
    public boolean addHomeInfo(HomeInfo homeInfo);
    public HomeInfo findHomeInfoByHomeId(int homeId);
    public boolean removeHomeInfoByHomeId(int homeId);
    public boolean modifyHomeInfo(HomeInfo homeInfo);
    public List<HomeInfo> findHomeInfosByTelePhone(String telePhone);

    public boolean addHomeRelationshipInfo(HomeRelationshipInfo homeRelationshipInfo);
    public List<HomeRelationshipInfo> findHomeRelationshipInfoByHomeId(int homeId);
    public List<HomeRelationshipInfo> findHomeRelationshipInfoByTelephone(String telePhone);
    public HomeRelationshipInfo findHomeRelationshipInfoByTelephoneAndHomeId(String telePhone, int homeId);
    public boolean removeHomeRelationshipInfoByHomeId(int homeId);//户主删除这个家的全部家庭关系
    public boolean removeHomeRelationshipInfoByTelephoneAndHomeId(String telePhone,int homeId);//普通家庭成员只能删除本人的关系
    public boolean modifyHomeRelationshipInfo(HomeRelationshipInfo homeRelationshipInfo);


}
