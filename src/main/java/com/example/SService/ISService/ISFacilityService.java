package com.example.SService.ISService;

import com.example.entity.FacilityInfo;
import com.example.entity.FacilityTypeInfo;

import java.util.ArrayList;
import java.util.List;

public interface ISFacilityService {
    public boolean addFacilityInfo(FacilityInfo facilityInfo);
    public List<FacilityTypeInfo> findFacilityTypeInfos();
    public List<FacilityInfo> findFacilityInfosByHomeId(int homeId);
    public FacilityInfo findFacilityInfoByFacilityId(String facilityId);
    public List<FacilityInfo> findFacilityInfosByIsCommon(boolean isCommon, int homeId);
    public boolean modifyFacilityInfoByIsCommon(String facilityId,boolean isCommon);
    public boolean modifyFacilityInfo(FacilityInfo facilityInfo);
    public boolean modifyFacilityData(FacilityInfo facilityInfo);
    public FacilityInfo findFacilityInfoByHomeId(int homeId);
    public boolean removeFacilityInfoByFacilityId(String facilityId);
    public boolean modifyFacilityInfoByFacilityName(String facilityId,String facilityName);
}
