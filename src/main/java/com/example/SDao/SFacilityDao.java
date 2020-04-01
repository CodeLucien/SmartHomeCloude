package com.example.SDao;

import com.example.SDao.ISDao.ISFacilityDao;
import com.example.entity.FacilityInfo;
import org.springframework.stereotype.Component;
import util.DBTool;
import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class SFacilityDao implements ISFacilityDao {
    @Override
    public FacilityInfo selectFacilityInfoByHomeId(int homeId) {
        FacilityInfo facilityInfo = null;
        Statement stmt = null;
        ResultSet rs = null;
        String type = "light";
        String sql  = "select facilityId,name,roomId,image,lastTime,lastData,status,isCommon,isOnline from facility f inner join facilitytype ft on f.type=ft.type= \"+type+\"  and homeId = "+homeId;
        try {
            stmt = DBTool.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                String facilityId  = rs.getString(1);
                String name  = rs.getString(2);

                int roomId  = rs.getInt(3);
                String image  = rs.getString(4);
                Date lastTime = new Date(rs.getTimestamp(5).getTime());
//                System.out.println(lastTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                String lastData  = rs.getString(6);
                boolean status  = rs.getBoolean(7);
                boolean isCommon  = rs.getBoolean(8);
                boolean isOnline  = rs.getBoolean(9);
                facilityInfo = new FacilityInfo(facilityId,name,type,roomId,homeId,image,lastTime,lastData,status,isCommon,isOnline);

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
        return facilityInfo;
    }

    @Override
    public boolean deletFacilityInfoByFacilityId(String facilityId) {
        boolean deletResult = false;
        Statement stmt = null;
        try {
            String sql = "delete from facility where facilityId = "+ facilityId;
            stmt = DBTool.getConnection().createStatement();
            if(stmt.executeUpdate(sql) > 0)
                deletResult = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            {
                try {
                    if (stmt!=null)
                        stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return deletResult;
    }

    @Override
    public List<FacilityInfo> selectFacilityInfosByHomeId(int homeId) {
        List<FacilityInfo> facilityInfos = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select facilityId,name,f.type,roomId,image,lastTime,lastData,status,isCommon,isOnline from facility f inner join facilitytype ft on f.type=ft.type and homeId = "+homeId;
        try {
            stmt = DBTool.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                String facilityId  = rs.getString(1);
                String name  = rs.getString(2);
                String type  = rs.getString(3);
                int roomId  = rs.getInt(4);
                String image  = rs.getString(5);
                Date lastTime = new Date(rs.getTimestamp(6).getTime());
//                System.out.println(lastTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                String lastData  = rs.getString(7);
                boolean status  = rs.getBoolean(8);
                boolean isCommon  = rs.getBoolean(9);
                boolean isOnline  = rs.getBoolean(10);
                FacilityInfo facilityInfo = new FacilityInfo(facilityId,name,type,roomId,homeId,image,lastTime,lastData,status,isCommon,isOnline);
                facilityInfos.add(facilityInfo);
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
        return facilityInfos;
    }

    public static void main(String[] args) {

        SFacilityDao sFacilityDao = new SFacilityDao();
        FacilityInfo facilityInfo = sFacilityDao.selectFacilityInfoByFacilityId("1");
        System.out.println(facilityInfo.getName());


    }

    @Override
    public boolean insertFacilityInfo(FacilityInfo facilityInfo) {
        PreparedStatement stmt = null;
        boolean insertResult = false;
        try {
            String sql = "insert into facility (facilityId,name,type,roomId,homeId,lastTime,lastData,status,isCommon,isOnline) values (?,?,?,?,?,?,?,?,?,?)";
            stmt = DBTool.getConnection().prepareStatement(sql);
            stmt.setString(1, facilityInfo.getFacilityId());
            stmt.setString(2, facilityInfo.getName());
            stmt.setString(3, facilityInfo.getType());
            stmt.setInt(4, facilityInfo.getRoomId());
            stmt.setInt(5, facilityInfo.getHomeId());
            stmt.setTimestamp(6, new Timestamp(facilityInfo.getLastTime().getTime()));
            stmt.setString(7, facilityInfo.getLastData());
            stmt.setBoolean(8, facilityInfo.getStatus());
            stmt.setBoolean(9, facilityInfo.isCommon());
            stmt.setBoolean(10, facilityInfo.isOnline());
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
    public FacilityInfo selectFacilityInfoByFacilityId(String facilityId) {
        FacilityInfo facilityInfo = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select name,f.type,roomId,homeId,image,lastTime,lastData,status,isCommon,isOnline from facility f inner join facilitytype ft on f.type=ft.type and facilityId ='"+facilityId+"'";
        try {
            stmt = DBTool.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                String name  = rs.getString(1);
                String type  = rs.getString(2);
                int roomId  = rs.getInt(3);
                int homeId  = rs.getInt(4);
                String image  = rs.getString(5);
                Date lastTime = new Date(rs.getTimestamp(6).getTime());
                String lastData  = rs.getString(7);
                boolean status  = rs.getBoolean(8);
                boolean isCommon  = rs.getBoolean(9);
                boolean isOnline  = rs.getBoolean(10);
                facilityInfo = new FacilityInfo(facilityId,name,type,roomId,homeId,image,lastTime,lastData,status,isCommon,isOnline);
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
        return facilityInfo;
    }

    @Override
    public List<FacilityInfo> selectFacilityInfosByIsCommon(boolean isCommon,int homeId) {
        List<FacilityInfo> facilityInfos = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select facilityId,name,f.type,roomId,image,lastTime,lastData,status,isOnline from facility f inner join facilitytype ft on f.type=ft.type and isCommon ="+isCommon+" and homeId = "+homeId;
        try {
            stmt = DBTool.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                String facilityId  = rs.getString(1);
                String name  = rs.getString(2);
                String type  = rs.getString(3);
                int roomId  = rs.getInt(4);
                String image  = rs.getString(5);
                Date lastTime = new Date(rs.getTimestamp(6).getTime());
                String lastData  = rs.getString(7);
                boolean status  = rs.getBoolean(8);
                boolean isOnline  = rs.getBoolean(9);
                FacilityInfo facilityInfo = new FacilityInfo(facilityId,name,type,roomId,homeId,image,lastTime,lastData,status,isCommon,isOnline);
                facilityInfos.add(facilityInfo);
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
        return facilityInfos;
    }

    @Override
    public boolean updateFacilityInfoByIsCommon(String facilityId, boolean isCommon) {
        PreparedStatement ps = null;
        String sql = "update facility set isCommon=? where facilityId=?";		//sql语句
        try {
            ps  = DBTool.getConnection().prepareStatement(sql);
            ps.setBoolean(1, isCommon);
            ps.setString(2, facilityId);
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
    public boolean updateFacilityInfo(FacilityInfo facilityInfo) {
        PreparedStatement ps = null;
        String sql = "update facility set name=?,type=?,roomId=?,lastTime=?,lastData=?,status=?,isCommon=?,isOnline=?  where facilityId = ?";
        try {
            ps  = DBTool.getConnection().prepareStatement(sql);
            ps.setString(1, facilityInfo.getName());
            ps.setString(2, facilityInfo.getType());
            ps.setInt(3, facilityInfo.getRoomId());
            ps.setTimestamp(4,new Timestamp(facilityInfo.getLastTime().getTime()));
            ps.setString(5, facilityInfo.getLastData());
            ps.setBoolean(6, facilityInfo.getStatus());
            ps.setBoolean(7, facilityInfo.isCommon());
            ps.setBoolean(8, facilityInfo.isOnline());
            ps.setString(9, facilityInfo.getFacilityId());

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
    public boolean updateFacilityData(FacilityInfo facilityInfo) {
        PreparedStatement ps = null;
        String sql = "update facility set lastTime=?,lastData=?,status=?,isOnline=?  where facilityId = ?";
        try {
            ps  = DBTool.getConnection().prepareStatement(sql);
            ps.setTimestamp(1,new Timestamp(facilityInfo.getLastTime().getTime()));
            ps.setString(2, facilityInfo.getLastData());
            ps.setBoolean(3, facilityInfo.getStatus());
            ps.setBoolean(4, facilityInfo.isOnline());
            ps.setString(5, facilityInfo.getFacilityId());

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
    public boolean updateFacilityInfoByFacilityName(String facilityId, String facilityName) {
        PreparedStatement ps = null;
        String sql = "update facility set name=? where facilityId=?";		//sql语句
        try {
            ps  = DBTool.getConnection().prepareStatement(sql);
            ps.setString(1, facilityName);
            ps.setString(2, facilityId);
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
