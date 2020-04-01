package com.example.SDao.ISDao;

import java.util.ArrayList;

import com.example.entity.*;

public interface ISSceneDao {
	public Boolean addScene(Scenesmall scene);//21手动添加场景[1]√
	
	public boolean removeScene(String sceneNum);//22手动删除场景[2]√
	
	public ArrayList<FacilityInfoAll> queryAllFacilty();//查询所有设备√
//public ArrayList<SceneFacilityInfo> addFacility(int sceneId,ArrayList<String> facilityId);//23添加场景设备[3]
	public boolean addFacility(ArrayList<ChooseFacility> choosefacility);//23添加场景设备[3]√
		
	public boolean amendFacility(String sceneId, ArrayList<SceneFacility> SceneFacilitys);//24设置场景设备[4]（！已经包含了场景id）
		
	public boolean removeFacility(String sceneId, String facilityId);//25删除场景设备[5]
		
	public boolean modifySceneBg(String sceneId, String scenePicture);//26更换场景背景图[6]
		
	public boolean isExistFacility(String sceneId);//查看设备是否存在
	public boolean setSceneOrder(String sceneId, String order);//27一键启用场景[7]
		                                                      //28一键停用场景[8]
		
	//public boolean modifySceneOrder(int sceneNum);//一键停用场景
		
		//////////////////////!!!!!!!!!!!!!
	public boolean renewalLHFacility(String sceneId, ArrayList<String> facilityId);//29更新离家场景序列图（用到了算法）[9]
		
	public boolean deleteLHFacility(String sceneId, ArrayList<String> facilityId);//30移除离家场景设备[10]
		
	public boolean setLHLaunchTime(String sceneId, String startTime);//31设置离家场景启用时间!!!!!!![11]
		
	public boolean modifyLHSceneOrder(String order);//32启用离家场景[12]
		                                                            //33停用离家场景[13]
	    //////////////////////!!!!!!!!!!!!!!!!!!
	public boolean renewalInformFacility(String sceneId, ArrayList<String> facilityId);//34更新通知场景（用到了算法）[14]
		
	public boolean setInformTime(String sceneId, String startTime);//35设置通知场景启用时间!!!!!!!!![15]31
		
	public boolean modifyInformSceneOrder(String sceneId, String order);//36启用通知场景startInformOrder[16]
		                                 //37停用通知场景stopInformOrder[17]
		

}
