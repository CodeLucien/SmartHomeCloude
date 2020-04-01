package com.example.entity;

public class RoomInfo {
    private int roomId;
    private String roomName;
    private int homeId;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public RoomInfo() {
    }

    public RoomInfo(int roomId, String roomName, int homeId) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.homeId = homeId;
    }
}
