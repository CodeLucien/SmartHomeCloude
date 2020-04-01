package com.example.entity;

import java.util.Date;
public class HomeInfo {

    private int homeId;
    private String name;
    private String province;
    private String city;
    private Date creatTime;

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public HomeInfo() {
    }

    public HomeInfo(String name, String province, String city, Date creatTime) {
        this.name = name;
        this.province = province;
        this.city = city;
        this.creatTime = creatTime;
    }

    public HomeInfo(int homeId, String name, String province, String city, Date creatTime) {
        this.homeId = homeId;
        this.name = name;
        this.province = province;
        this.city = city;
        this.creatTime = creatTime;
    }
}
