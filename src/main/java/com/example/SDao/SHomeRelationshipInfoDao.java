package com.example.SDao;

import com.example.SDao.ISDao.ISHomeRelationshipInfoDao;
import com.example.entity.HomeRelationshipInfo;
import org.springframework.stereotype.Component;
import util.DBTool;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class SHomeRelationshipInfoDao implements ISHomeRelationshipInfoDao {
    public static void main(String[] args) {

        SHomeRelationshipInfoDao sHomeRelationshipInfoDao = new SHomeRelationshipInfoDao();
        sHomeRelationshipInfoDao.deletHomeRelationshipInfoByHomeId(1);
    }
    @Override
    public boolean insertHomeRelationshipInfo(HomeRelationshipInfo homeRelationshipInfo) {
        PreparedStatement stmt = null;
        boolean insertResult = false;
        try {
            String sql = "insert into homerelationship (telePhone,homeId,isOwner,title) values (?,?,?,?)";
            stmt = DBTool.getConnection().prepareStatement(sql);
            stmt.setString(1, homeRelationshipInfo.getTelePhone());
            stmt.setInt(2, homeRelationshipInfo.getHomeId());
            stmt.setBoolean(3, homeRelationshipInfo.isOwner());
            stmt.setString(4, homeRelationshipInfo.getTitle());
            if(stmt.executeUpdate()>0){
                insertResult =true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                if (stmt!=null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return insertResult;
    }

    @Override
    public List<HomeRelationshipInfo> selectHomeRelationshipInfoByHomeId(int homeId) {
        List<HomeRelationshipInfo> homeRelationshipInfos = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select telePhone,isOwner,title from homerelationship where homeId ="+homeId;
        try {
            stmt = DBTool.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                String telePhone  = rs.getString(1);
                boolean isOwner  = rs.getBoolean(2);
                String title  = rs.getString(3);
                HomeRelationshipInfo homeRelationshipInfo = new HomeRelationshipInfo(telePhone,homeId,isOwner,title);
                homeRelationshipInfos.add(homeRelationshipInfo);
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
        return homeRelationshipInfos;
    }

    @Override
    public HomeRelationshipInfo selectHomeRelationshipInfoByTelephoneAndHomeId(String telePhone, int homeId) {

        HomeRelationshipInfo homeRelationshipInfo = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select isOwner,title from homerelationship where homeId = "+homeId+" and telePhone ='"+telePhone+"'";
        try {
            stmt = DBTool.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){

                boolean isOwner  = rs.getBoolean(1);
                String title  = rs.getString(2);
                homeRelationshipInfo = new HomeRelationshipInfo(telePhone,homeId,isOwner,title);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(stmt != null)
                    stmt.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return homeRelationshipInfo;
    }

    @Override
    public List<HomeRelationshipInfo> selectHomeRelationshipInfoByTelephone(String telePhone) {
        List<HomeRelationshipInfo> homeRelationshipInfos = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select homeId,isOwner,title from homerelationship where telePhone ='"+telePhone+"'";
        try {
            stmt = DBTool.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                int homeId  = rs.getInt(1);
                boolean isOwner  = rs.getBoolean(2);
                String title  = rs.getString(3);
                HomeRelationshipInfo homeRelationshipInfo = new HomeRelationshipInfo(telePhone,homeId,isOwner,title);
                homeRelationshipInfos.add(homeRelationshipInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         finally{
                try {
                    if(stmt != null)
                        stmt.close();
                    if(rs != null)
                        rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return homeRelationshipInfos;


    }

    @Override
    public boolean deletHomeRelationshipInfoByHomeId(int homeId) {
        boolean deletResult = false;
        Statement stmt = null;
        try {
            stmt = DBTool.getConnection().createStatement();

            String sql = "delete from homerelationship where homeId = "+ homeId;
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
    public boolean deletHomeRelationshipInfoByTelephoneAndHomeId(String telePhone, int homeId) {
        boolean deletResult = false;
        Statement stmt = null;
        try {
            stmt = DBTool.getConnection().createStatement();

            String sql = "delete from homerelationship where telePhone ='"+telePhone+"' and homeId ="+homeId;
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
    public boolean updateHomeRelationshipInfo(HomeRelationshipInfo homeRelationshipInfo) {
        PreparedStatement ps = null;
        String sql = "update homerelationship set isOwner=?,title=? where telePhone = ? and homeId = ?";
        try {
            ps  = DBTool.getConnection().prepareStatement(sql);
            ps.setBoolean(1, homeRelationshipInfo.isOwner());
            ps.setString(2, homeRelationshipInfo.getTitle());
            ps.setString(3, homeRelationshipInfo.getTelePhone());
            ps.setInt(4, homeRelationshipInfo.getHomeId());

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
}
