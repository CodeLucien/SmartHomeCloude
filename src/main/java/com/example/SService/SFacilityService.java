package com.example.SService;

import com.example.SDao.SFacilityDao;
import com.example.SDao.SFacilityDataDao;
import com.example.SDao.SFacilityTypeDao;
import com.example.SService.ISService.ISFacilityService;
import com.example.entity.FacilityInfo;
import com.example.entity.FacilityTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("SFacilityService")
public class SFacilityService implements ISFacilityService {
    @Autowired
    SFacilityTypeDao sFacilityTypeDao;
    @Autowired
    SFacilityDao sFacilityDao;
    @Autowired
    SFacilityDataDao sFacilityDataDao;
    @Override
    public boolean addFacilityInfo(FacilityInfo facilityInfo) {
        return sFacilityDao.insertFacilityInfo(facilityInfo);
    }

    @Override
    public List<FacilityTypeInfo> findFacilityTypeInfos() {
        return sFacilityTypeDao.selectFacilityTypeInfos();
    }

    @Override
    public FacilityInfo findFacilityInfoByHomeId(int homeId) {
        return sFacilityDao.selectFacilityInfoByHomeId(homeId);
    }

    @Override
    public boolean removeFacilityInfoByFacilityId(String facilityId) {
        boolean result1 = sFacilityDao.deletFacilityInfoByFacilityId(facilityId);
        if (result1){
            sFacilityDataDao.deletFacilityDataInfoByFacilityId(facilityId);
            return result1;
        }else {
            return false;
        }

    }

    @Override
    public List<FacilityInfo> findFacilityInfosByHomeId(int homeId) {
        return sFacilityDao.selectFacilityInfosByHomeId(homeId);
    }

    @Override
    public FacilityInfo findFacilityInfoByFacilityId(String facilityId) {
        return sFacilityDao.selectFacilityInfoByFacilityId(facilityId);
    }

    @Override
    public List<FacilityInfo> findFacilityInfosByIsCommon(boolean isCommon,int homeId) {
        return sFacilityDao.selectFacilityInfosByIsCommon(isCommon,homeId);
    }

    @Override
    public boolean modifyFacilityInfoByIsCommon(String facilityId, boolean isCommon) {
        return sFacilityDao.updateFacilityInfoByIsCommon(facilityId,isCommon);
    }

    @Override
    public boolean modifyFacilityInfo(FacilityInfo facilityInfo) {
        return sFacilityDao.updateFacilityInfo(facilityInfo);
    }

    @Override
    public boolean modifyFacilityData(FacilityInfo facilityInfo) {
        return sFacilityDao.updateFacilityData(facilityInfo);
    }

    @Override
    public boolean modifyFacilityInfoByFacilityName(String facilityId, String facilityName) {
        return sFacilityDao.updateFacilityInfoByFacilityName(facilityId,facilityName);
    }
}
