package com.example.SDao;

import com.example.SDao.ISDao.ISFacilityTypeDao;
import com.example.entity.FacilityTypeInfo;
import org.springframework.stereotype.Component;
import util.DBTool;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class SFacilityTypeDao implements ISFacilityTypeDao {
    @Override
    public List<FacilityTypeInfo> selectFacilityTypeInfos() {
        List<FacilityTypeInfo> facilityTypeInfos = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select type,description,image,tags from facilityType ";
        try {
            stmt = DBTool.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                String type  = rs.getString(1);
                String description  = rs.getString(2);
                String image  = rs.getString(3);
                String tags  = rs.getString(4);
                FacilityTypeInfo facilityTypeInfo = new FacilityTypeInfo(type, description, image, tags);
                facilityTypeInfos.add(facilityTypeInfo);
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
        return facilityTypeInfos;
    }

    public static void main(String[] args) {

        SFacilityTypeDao sFacilityTypeDao = new SFacilityTypeDao();
        System.out.println(sFacilityTypeDao.selectFacilityTypeInfos().size());
    }
}
