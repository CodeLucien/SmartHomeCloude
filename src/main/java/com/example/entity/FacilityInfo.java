package com.example.entity;
import java.util.Date;
public class FacilityInfo {
    private String facilityId;
    private String name;
    private String type;
    private int roomId;
    private int homeId;
    private String image;
    private Date lastTime;
    private String lastData;
    private boolean status;
    private boolean isCommon;
    private boolean isOnline;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public boolean isStatus() {
        return status;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getLastData() {
        return lastData;
    }

    public void setLastData(String lastData) {
        this.lastData = lastData;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isCommon() {
        return isCommon;
    }

    public void setCommon(boolean common) {
        isCommon = common;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public FacilityInfo() {
    }

    public FacilityInfo(String facilityId, String name, String type, int roomId, int homeId, String image, Date lastTime, String lastData, boolean status, boolean isCommon, boolean isOnline) {
        this.facilityId = facilityId;
        this.name = name;
        this.type = type;
        this.roomId = roomId;
        this.homeId = homeId;
        this.image = image;
        this.lastTime = lastTime;
        this.lastData = lastData;
        this.status = status;
        this.isCommon = isCommon;
        this.isOnline = isOnline;
    }
}
