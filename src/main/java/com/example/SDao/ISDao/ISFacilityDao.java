package com.example.SDao.ISDao;

import com.example.entity.FacilityInfo;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public interface ISFacilityDao {
    public boolean insertFacilityInfo(FacilityInfo facilityInfo);
    public FacilityInfo selectFacilityInfoByFacilityId(String facilityId);
    public List<FacilityInfo> selectFacilityInfosByHomeId(int homeId);
    public List<FacilityInfo> selectFacilityInfosByIsCommon(boolean isCommon, int homeId);
    public boolean updateFacilityInfoByIsCommon(String facilityId,boolean isCommon);
    public boolean updateFacilityInfo(FacilityInfo facilityInfo);
    public boolean updateFacilityData(FacilityInfo facilityInfo);
    public FacilityInfo selectFacilityInfoByHomeId(int homeId);
    public boolean deletFacilityInfoByFacilityId(String facilityId);
    public boolean updateFacilityInfoByFacilityName(String facilityId,String facilityName);
}
