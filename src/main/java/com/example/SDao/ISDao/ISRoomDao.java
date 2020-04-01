package com.example.SDao.ISDao;

import com.example.entity.RoomInfo;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public interface ISRoomDao {
    public boolean insertRoomInfo(RoomInfo roomInfo);
    public RoomInfo selectRoomInfoByRoomId(int roomId);
    public boolean deletRoomsByRoomIds(List<Integer> roomIds);
    public List<RoomInfo> selectRoomInfosByHomeId(int homeId);
}
