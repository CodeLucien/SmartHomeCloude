package com.example.SController.ISController;

import com.example.entity.RoomInfo;
import java.util.List;
public interface ISRoomController {
    public void searchRoomInfosByHomeId(int homeId);
    public void isExistOfRoomInfo(int roomId);
    public void createRoomInfo(RoomInfo roomInfo);
    public void deletRoomsByRoomIds(List<Integer> roomIds);
}
