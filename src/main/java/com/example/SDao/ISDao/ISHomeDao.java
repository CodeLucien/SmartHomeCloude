package com.example.SDao.ISDao;

import com.example.entity.HomeInfo;
import java.util.List;

public interface ISHomeDao {
    public boolean insertHomeInfo(HomeInfo homeInfo);
    public HomeInfo selectHomeInfoByHomeId(int homeId);
    public boolean deletHomeInfoByHomeId(int homeId);
    public boolean updateHomeInfo(HomeInfo homeInfo);
    public List<HomeInfo> selectHomeInfosByTelePhone(String telePhone);
}
