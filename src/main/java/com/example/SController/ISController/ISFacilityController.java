package com.example.SController.ISController;

import com.example.entity.FacilityInfo;

public interface ISFacilityController {
    public void createFacilityInfo(FacilityInfo facilityInfo);
    public void searchFacilityTypeInfos();
    public void searchFacilityInfosByHomeId(int homeId);
    public void searchFacilityInfoByHomeId(int homeId);
    public void searchFacilityInfoByFacilityId(String facilityId);
    public void searchFacilityInfosByIsCommon(boolean isCommon,int homeId);
    public void changeFacilityInfoByIsCommon(String facilityId,boolean isCommon);
    public void cancelFacilityByFacilityId(String facilityId);
    public void changeFacilityInfoByFacilityName(String facilityId,String facilityName);
}
