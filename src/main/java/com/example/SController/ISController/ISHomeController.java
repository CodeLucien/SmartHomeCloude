package com.example.SController.ISController;

import com.example.entity.HomeInfo;
import com.example.entity.HomeRelationshipInfo;
import com.example.entity.RoomInfo;

import java.util.List;

public interface ISHomeController {
    public void createHomeInfo(HomeInfo homeInfo);
    public void searchHomeInfoByHomeId(int homeId);
    public void deletHomeInfoByHomeId(int homeId);
    public void changeHomeInfo(HomeInfo homeInfo);
    public void searchHomeInfosByTelePhone(String telePhone);
    public void createHomeRelationshipInfo(HomeRelationshipInfo homeRelationshipInfo);//邀请家人
    public void searchHomeRelationshipInfoByHomeId(int homeId);
    public void searchHomeRelationshipInfoByTelephone(String telePhone);
    public void searchHomeRelationshipInfoByTelephoneAndHomeId(String telePhone, int homeId);
    public void deletHomeRelationshipInfoByHomeId(int homeId);//户主删除这个家的全部家庭关系
    public void deletHomeRelationshipInfoByTelephoneAndHomeId(String telePhone,int homeId);//删除某个成员与此家庭的关系
    public void changeHomeRelationshipInfo(HomeRelationshipInfo homeRelationshipInfo);
}
