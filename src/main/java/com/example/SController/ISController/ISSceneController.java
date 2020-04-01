package com.example.SController.ISController;

import java.util.ArrayList;

import com.example.entity.*;
import com.example.entity.SceneFacility;

public interface ISSceneController {
//String sceneName
	public void addSceneCon(Scenesmall scene);//21手动添加场景[1]
	
	public void removeSceneCon(String sceneNum);//22手动删除场景[2]

	public void queryAllFaciltyCon();//查询所有设备[3]
	public void addFacilityCon(ArrayList<ChooseFacility> choosefacility);//23添加场景设备[4]
	
	public void amendFacilityCon(String sceneId, ArrayList<SceneFacility> SceneFacilitys);//24设置场景设备[5]（！已经包含了场景id）
	
	public void removeFacilityCon(String sceneId, String facilityId);//25删除场景设备[6]
	
	public void modifySceneBgCon(String sceneId, String scenePicture);//26更换场景背景图[7]
	
	public void isExistFacilityCon(String sceneId);//查看设备是否存在[8]
	public void setSceneOrderCon(String sceneId, String order);//27一键启用场景[9]
	                                                      //28一键停用场景[10]
	
	//public void modifySceneOrderCon(int sceneNum);//28一键停用场景[11]
	
	//////////////////////!!!!!!!!!!!!!
	public void renewalLHFacilityCon(String sceneId, ArrayList<String> facilityId);//29更新离家场景序列图[12]
	
	public void deleteLHFacilityCon(String sceneId, ArrayList<String> facilityId);//30移除离家场景设备[13]
	
	public void setLHLaunchTimeCon(String sceneId, String startTime);//31设置离家场景启用时间!!!!!!![14]
	
	public void modifyLHSceneOrderCon(String order);//32启用离家场景[15]
	                                                            //33停用离家场景
    //////////////////////!!!!!!!!!!!!!!!!!!
	public void renewalInformFacilityCon(String sceneId, ArrayList<String> facilityId);//34更新通知场景[16]
	
	public void setInformTimeCon(String sceneId, String startTime);//35设置通知场景启用时间!!!!!!!!![17]31
	
	public void modifyInformSceneOrderCon(String sceneId, String order);//36启用通知场景startInformOrder[18]
	                                 //37停用通知场景stopInformOrder






}
