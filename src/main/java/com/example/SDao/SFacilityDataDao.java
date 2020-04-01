package com.example.SDao;

import com.example.SDao.ISDao.ISFacilityDataDao;
import com.example.entity.FacilityDataInfo;
import org.springframework.stereotype.Component;
import util.DBTool;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class SFacilityDataDao implements ISFacilityDataDao {
    @Override
    public boolean insertFacilityDataInfo(FacilityDataInfo facilityDataInfo) {
        PreparedStatement stmt = null;
        boolean insertResult = false;
        try {
            String sql = "insert into facilityData (facilityId,time,data) values (?,?,?)";
            stmt = DBTool.getConnection().prepareStatement(sql);
            stmt.setString(1, facilityDataInfo.getFacilityId());
            stmt.setTimestamp(2, Timestamp.valueOf(facilityDataInfo.getTime()));
            stmt.setString(3, facilityDataInfo.getData());
            if(stmt.executeUpdate()>0){
                insertResult =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return insertResult;
    }

    @Override
    public List<FacilityDataInfo> selectFacilityDataInfoByFacilityId(String facilityId) {
        List<FacilityDataInfo> facilityDataInfos = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select time,data from facilityData where facilityId ="+facilityId;
        try {
            stmt = DBTool.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                LocalDateTime time = rs.getTimestamp(1).toLocalDateTime();
                String data  = rs.getString(2);
                FacilityDataInfo facilityDataInfo = new FacilityDataInfo(facilityId,time,data);
                facilityDataInfos.add(facilityDataInfo);
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
        return facilityDataInfos;
    }
    public static void main(String[] args) {
        SFacilityDataDao sFacilityDataDao = new SFacilityDataDao();

    }
    @Override
    public boolean deletFacilityDataInfoByFacilityId(String facilityId) {
        boolean deletResult = false;
        Statement stmt = null;
        try {
            String sql = "delete from facilityData where facilityId = "+ facilityId;
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
}
