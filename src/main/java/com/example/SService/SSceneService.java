package com.example.SService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.SDao.SSceneDao;
import com.example.SService.ISService.ISSceneService;
import com.example.entity.*;

@Service
@ComponentScan(basePackages = {"com.example.SDao" })
public class SSceneService implements ISSceneService {
	@Autowired
	private SSceneDao sSceneDao;
	
	@Override //21手动添加场景[1]
	public Boolean addSceneSer(Scenesmall scene) {
		// TODO Auto-generated method stub
		return sSceneDao.addScene(scene);
		
		
	}
	
	public int add() {
		// TODO Auto-generated method stub
		//return sSceneDao.addScene(sceneName);
		return 1;
		
	}

	@Override //22手动删除场景[2]
	public boolean removeSceneSer(String sceneNum) {
		
		return sSceneDao.removeScene(sceneNum);
	}

	@Override //查询所有设备
	public ArrayList<FacilityInfoAll> queryAllFaciltySer() {
		
		return sSceneDao.queryAllFacilty();
	}

	@Override //23添加场景设备[3]
	public boolean addFacilitySer(ArrayList<ChooseFacility> choosefacility) {
		if(choosefacility != null) {
			return sSceneDao.addFacility(choosefacility);
		}
		return false;
	}

	@Override//24设置场景设备[4]
	public boolean amendFacilitySer(String sceneId, ArrayList<SceneFacility> SceneFacilitys) {
		
		if(SceneFacilitys != null) {
			return sSceneDao.amendFacility(sceneId,SceneFacilitys);
		}
		return false;
		
	}

	@Override//25删除场景设备[5]
	public boolean removeFacilitySer(String sceneId, String facilityId) {
		if(facilityId != null) {
			return sSceneDao.removeFacility(sceneId, facilityId);
		}
		return false;
	}

	@Override//26更换场景背景图[6]
	public boolean modifySceneBgSer(String sceneId, String scenePicture) {
		
		return sSceneDao.modifySceneBg(sceneId, scenePicture);
	}

	@Override//查看设备是否存在
	public boolean isExistFacilitySer(String sceneId) {
		
		return sSceneDao.isExistFacility(sceneId);
	}

	@Override//28一键启用场景[7] 一键停用场景[8]
	public boolean setSceneOrderSer(String sceneId, String order) {
		
		return sSceneDao.setSceneOrder(sceneId, order);
	}

	@Override//29更新离家场景序列图（）[9]
	public boolean renewalLHFacilitySer(String sceneId,ArrayList<String> facilityId) {
		if(facilityId != null) {
			return sSceneDao.renewalLHFacility(sceneId, facilityId);
		}
		return false;
	}

	@Override//30移除离家场景设备[10]
	public boolean deleteLHFacilitySer(String sceneId, ArrayList<String> facilityId) {
		if(facilityId != null) {
			return sSceneDao.deleteLHFacility(sceneId, facilityId);
		}
		return false;
	}

	@Override//31设置离家场景启用时间!!!!!!![11]
	public boolean setLHLaunchTimeSer(String sceneId, String startTime) {
		
		return sSceneDao.setLHLaunchTime(sceneId, startTime);
	}

	@Override//32启用离家场景[12]//33停用离家场景[13]
	public boolean modifyLHSceneOrderSer( String order) {
		
		return sSceneDao.modifyLHSceneOrder(order);
	}

	@Override//34更新通知场景（）[14]
	public boolean renewalInformFacilitySer(String sceneId,ArrayList<String> facilityId) {
		if(facilityId != null) {
			return sSceneDao.renewalInformFacility(sceneId, facilityId);
		}
		return false;
	}

	@Override//35设置通知场景启用时间!!!!!!!!![16]31
	public boolean setInformTimeSer(String sceneId, String startTime) {
		
		return sSceneDao.setInformTime(sceneId, startTime);
	}

	@Override
	public boolean modifyInformSceneOrderSer(String sceneId, String order) {
		
		return sSceneDao.modifyInformSceneOrder(sceneId, order);
	}

}
