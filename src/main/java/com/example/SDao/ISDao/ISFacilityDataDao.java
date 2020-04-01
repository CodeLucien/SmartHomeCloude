package com.example.SDao.ISDao;

import com.example.entity.FacilityDataInfo;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface ISFacilityDataDao {
    public boolean insertFacilityDataInfo(FacilityDataInfo facilityDataInfo);
    public List<FacilityDataInfo> selectFacilityDataInfoByFacilityId(String facilityId);
    public boolean deletFacilityDataInfoByFacilityId(String facilityId);
}
