package com.example.SDao.ISDao;

import com.example.entity.FacilityTypeInfo;
import java.util.List;

public interface ISFacilityTypeDao {
    public List<FacilityTypeInfo> selectFacilityTypeInfos();
}
