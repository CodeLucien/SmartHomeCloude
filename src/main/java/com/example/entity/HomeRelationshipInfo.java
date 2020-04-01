package com.example.entity;

public class HomeRelationshipInfo {
    private String telePhone;
    private int homeId;
    private boolean isOwner;
    private String title;

    public HomeRelationshipInfo(String telePhone, int homeId, boolean isOwner, String title) {
        this.telePhone = telePhone;
        this.homeId = homeId;
        this.isOwner = isOwner;
        this.title = title;
    }

    public HomeRelationshipInfo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }
}
