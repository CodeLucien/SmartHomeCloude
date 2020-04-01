package com.example;

import com.example.SService.SRoomService;
import com.example.entity.RoomInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    SRoomService sRoomService;

    @Test
    public void addRoomTest() {
        String roomName = "卧室";
        int homeId = 123;
        RoomInfo roomInfo = new RoomInfo();
        roomInfo.setRoomName(roomName);
        roomInfo.setHomeId(homeId);
        boolean addResult = sRoomService.addRoomInfo(roomInfo);
        if (addResult){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }


}
