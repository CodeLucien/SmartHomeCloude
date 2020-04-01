package com.example.SService;

import com.example.SDao.SRoomDao;
import com.example.SService.ISService.ISRoomService;
import com.example.entity.RoomInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SRoomService implements ISRoomService {
    @Autowired
    private SRoomDao sRoomDao;
    public List<RoomInfo> findRoomInfosByHomeId(int homeId){
        return sRoomDao.selectRoomInfosByHomeId(homeId);
    }

    @Override
    public boolean addRoomInfo(RoomInfo roomInfo) {
        if(roomInfo!=null) {
            return sRoomDao.insertRoomInfo(roomInfo);
        }
        return false;
    }

    @Override
    public RoomInfo findRoomInfoByRoomId(int roomId) {
        return  sRoomDao.selectRoomInfoByRoomId(roomId);
    }

    @Override
    public boolean removeRoomsByRoomIds(List<Integer> roomIds) {
        if(roomIds!=null){
            return sRoomDao.deletRoomsByRoomIds(roomIds);
        }
        return false;
    }
}