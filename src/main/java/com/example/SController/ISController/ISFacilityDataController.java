package com.example.SController.ISController;

import com.example.entity.FacilityDataInfo;

public interface ISFacilityDataController {
    public void createFacilityDataInfo(FacilityDataInfo facilityDataInfo);
    public void searchFacilityDataInfoByFacilityId(String facilityId);
    public void deletFacilityDataInfoByFacilityId(String facilityId);


}
