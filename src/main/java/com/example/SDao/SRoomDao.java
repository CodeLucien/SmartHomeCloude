package com.example.SDao;

import com.example.SDao.ISDao.ISRoomDao;
import com.example.entity.HomeInfo;
import com.example.entity.RoomInfo;
import org.springframework.stereotype.Component;
import util.DBTool;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Component
public class SRoomDao implements ISRoomDao {

    @Override
    public boolean insertRoomInfo(RoomInfo roomInfo) {
        PreparedStatement stmt = null;
        boolean insertResult = false;
        try {
            String sql = "insert into room (roomName,homeId) values (?,?)";
            stmt = DBTool.getConnection().prepareStatement(sql);
            stmt.setString(1, roomInfo.getRoomName());
            stmt.setInt(2, roomInfo.getHomeId());
            if(stmt.executeUpdate()>0){
                insertResult =true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally{
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return insertResult;
    }

    @Override
    public RoomInfo selectRoomInfoByRoomId(int roomId) {
        RoomInfo roomInfo = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select roomName,homeId from room where roomId ="+ roomId;
        try {
            stmt = DBTool.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                String roomName  = rs.getString(1);
                int homeId  = rs.getInt(2);
                roomInfo = new RoomInfo(roomId,roomName,homeId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if(stmt != null)
                    stmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return roomInfo;
    }

    @Override
    public boolean deletRoomsByRoomIds(List<Integer> roomIds) {
        boolean deletResult = false;
        Statement stmt = null;
        try {
            stmt = DBTool.getConnection().createStatement();
            for(int roomId : roomIds){
                String sql = "delete from room where roomId = "+ roomId;
                if(stmt.executeUpdate(sql) > 0)
                    deletResult = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return deletResult;
    }

    @Override
    public List<RoomInfo> selectRoomInfosByHomeId(int homeId) {
        List<RoomInfo> roomInfos = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select roomId,roomName from room where homeId = "+homeId;
        try {
            stmt = DBTool.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                int roomId  = rs.getInt(1);
                String roomName  = rs.getString(2);
                RoomInfo roomInfo = new RoomInfo(roomId,roomName,homeId);
                roomInfos.add(roomInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if(stmt != null)
                    stmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return roomInfos;
    }

    public static void main(String[] args) {
        SRoomDao SRoomDao = new SRoomDao();
        RoomInfo roomInfo = SRoomDao.selectRoomInfoByRoomId(123);
        System.out.println(roomInfo.getRoomName());

//        SRoomDao.insertRoomInfo(new RoomInfo(1,"卧室",2));

//        List<Integer> roomIds = new ArrayList<>();
//        roomIds.add(1);
//        roomIds.add(2);
//        System.out.println(SRoomDao.deletRoomsByRoomIds(roomIds));
//        System.out.println(SRoomDao.selectRoomInfos().size());
    }

}
