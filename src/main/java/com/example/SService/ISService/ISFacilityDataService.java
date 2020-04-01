package com.example.SService.ISService;

import com.example.entity.FacilityDataInfo;
import java.util.List;

public interface ISFacilityDataService {
    public boolean addFacilityDataInfo(FacilityDataInfo facilityDataInfo);
    public List<FacilityDataInfo> findFacilityDataInfoByFacilityId(String facilityId);
    public boolean removeFacilityDataInfoByFacilityId(String facilityId);

}
