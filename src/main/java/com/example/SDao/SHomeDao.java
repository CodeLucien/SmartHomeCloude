package com.example.SDao;

import com.example.SDao.ISDao.ISHomeDao;
import com.example.entity.HomeInfo;
import org.springframework.stereotype.Component;
import util.DBTool;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class SHomeDao implements ISHomeDao {
    public static void main(String[] args) {
        SHomeDao sHomeDao = new SHomeDao();
//        System.out.println(sHomeDao.selectHomeInfoByHomeId(111).getCreatTime());
//        sHomeDao.deletHomeInfoByHomeId(1);
    }

    @Override
    public int insertHomeInfo(HomeInfo homeInfo) {
        PreparedStatement stmt = null;
        int returnKey = 0 ;
        try {
            String sql = "insert into home (name,province,city,createTime) values (?,?,?,?)";
            stmt = DBTool.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
//            stmt = DBTool.getConnection().prepareStatement(sql);
            stmt.setString(1, homeInfo.getName());
            stmt.setString(2, homeInfo.getProvince());
            stmt.setString(3, homeInfo.getCity());
            stmt.setTimestamp(4, new Timestamp(homeInfo.getCreatTime().getTime()));
            if(stmt.executeUpdate()>0){
                ResultSet resultSet = stmt.getGeneratedKeys();
                resultSet.next();
                 returnKey = resultSet.getInt(1);
                System.out.println(returnKey);
//                insertResult =true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (stmt!=null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return returnKey;
    }

    @Override
    public HomeInfo selectHomeInfoByHomeId(int homeId) {
        HomeInfo homeInfo = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select name,province,city,createTime from home where homeId ="+ homeId;
        try {
            stmt = DBTool.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                String name  = rs.getString(1);
                String province  = rs.getString(2);
                String city  = rs.getString(3);
                Date createTime = new Date(rs.getTimestamp(4).getTime());
                homeInfo = new HomeInfo(homeId,name,province,city,createTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (stmt!=null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return homeInfo;
    }

    @Override
    public boolean deletHomeInfoByHomeId(int homeId) {
        boolean deletResult = false;
        Statement stmt = null;
        try {
            stmt = DBTool.getConnection().createStatement();

            String sql = "delete from home and homerelationship where homeId = "+ homeId;
            if(stmt.executeUpdate(sql) > 0)
                deletResult = true;

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
    public boolean updateHomeInfo(HomeInfo homeInfo) {
        PreparedStatement ps = null;
        String sql = "update home set name=?,province=?,city=?,createTime=? where homeId = ?";
        try {
            ps  = DBTool.getConnection().prepareStatement(sql);
            ps.setString(1, homeInfo.getName());
            ps.setString(2, homeInfo.getProvince());
            ps.setString(3, homeInfo.getCity());
            ps.setTimestamp(4,new Timestamp(homeInfo.getCreatTime().getTime()));
            ps.setInt(5, homeInfo.getHomeId());
            if (ps.executeUpdate()>0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public List<HomeInfo> selectHomeInfosByTelePhone(String telePhone) {
        List<HomeInfo> homeInfos = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select h.homeId,name,province,city,createTime from home  h inner join homerelationship hr on h.homeId=hr.homeId and hr.telePhone ='"+telePhone+"'";
        try {
            stmt = DBTool.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                int homeId = rs.getInt(1);
                String name  = rs.getString(2);
                String province  = rs.getString(3);
                String city  = rs.getString(4);
                Date createTime = new Date(rs.getTimestamp(5).getTime());
                HomeInfo homeInfo = new HomeInfo(homeId,name,province,city,createTime);
                homeInfos.add(homeInfo);
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
        return homeInfos;
    }
}
