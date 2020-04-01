package com.example.SService;

import com.example.SDao.SFacilityDataDao;
import com.example.SService.ISService.ISFacilityDataService;
import com.example.entity.FacilityDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SFacilityDataService implements ISFacilityDataService {
    @Autowired
    SFacilityDataDao sFacilityDataDao;

    @Override
    public boolean addFacilityDataInfo(FacilityDataInfo facilityDataInfo) {
        return sFacilityDataDao.insertFacilityDataInfo(facilityDataInfo);
    }

    @Override
    public List<FacilityDataInfo> findFacilityDataInfoByFacilityId(String facilityId) {
        return sFacilityDataDao.selectFacilityDataInfoByFacilityId(facilityId);
    }

    @Override
    public boolean removeFacilityDataInfoByFacilityId(String facilityId) {
        return sFacilityDataDao.deletFacilityDataInfoByFacilityId(facilityId);
    }
}
