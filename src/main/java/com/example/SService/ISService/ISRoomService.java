package com.example.SService.ISService;

import com.example.entity.RoomInfo;

import java.util.ArrayList;
import java.util.List;

public interface ISRoomService {
    public boolean addRoomInfo(RoomInfo roomInfo);
    public RoomInfo findRoomInfoByRoomId(int roomId);
    public boolean removeRoomsByRoomIds(List<Integer> roomIds);
    public List<RoomInfo> findRoomInfosByHomeId(int homeId);

}
