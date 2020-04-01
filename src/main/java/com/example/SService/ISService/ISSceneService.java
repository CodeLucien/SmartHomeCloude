package com.example.SService.ISService;

import java.util.ArrayList;

import com.example.entity.*;

public interface ISSceneService {

	public Boolean addSceneSer(Scenesmall sceneName);//21手动添加场景[1]
	
	public boolean removeSceneSer(String sceneNum);//22手动删除场景[2]

	public ArrayList<FacilityInfoAll> queryAllFaciltySer();//查询所有设备[3]
	public boolean addFacilitySer(ArrayList<ChooseFacility> choosefacility);//23添加场景设备[4]
	
	public boolean amendFacilitySer(String sceneId, ArrayList<SceneFacility> SceneFacilitys);//24设置场景设备[5]（！已经包含了场景id）
	
	public boolean removeFacilitySer(String sceneId, String facilityId);//25删除场景设备[6]
	
	public boolean modifySceneBgSer(String sceneId, String scenePicture);//26更换场景背景图[7]
	
	public boolean isExistFacilitySer(String sceneId);//查看设备是否存在
	public boolean setSceneOrderSer(String sceneId, String order);//27一键启用场景[8]
	                                                      //28一键停用场景[9]
	
	//public boolean modifySceneOrderSer(int sceneNum);//28一键停用场景
	
	//////////////////////!!!!!!!!!!!!!
	public boolean renewalLHFacilitySer(String sceneId, ArrayList<String> facilityId);//29更新离家场景序列图（）[10]
	
	public boolean deleteLHFacilitySer(String sceneId, ArrayList<String> facilityId);//30移除离家场景设备[11]
	
	public boolean setLHLaunchTimeSer(String sceneId, String startTime);//31设置离家场景启用时间!!!!!!![12]
	
	public boolean modifyLHSceneOrderSer(String order);//32启用离家场景[13]
	                                                            //33停用离家场景[14]
    //////////////////////!!!!!!!!!!!!!!!!!!
	public boolean renewalInformFacilitySer(String sceneId, ArrayList<String> facilityId);//34更新通知场景（用到了算法）[15]
	
	public boolean setInformTimeSer(String sceneId, String startTime);//35设置通知场景启用时间!!!!!!!!![16]31
	
	public boolean modifyInformSceneOrderSer(String sceneId, String order);//36启用通知场景startInformOrder[17]
	                                 //37停用通知场景stopInformOrder






}
