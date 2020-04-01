package com.example.entity;

public class ChooseFacility {
	
	private String sceneNum;//场景编号
	private String facilityNum;//设备编号
	
	
	
	public ChooseFacility() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ChooseFacility(String sceneNum, String facilityNum) {
		super();
		this.sceneNum = sceneNum;
		this.facilityNum = facilityNum;
	}



	public String getSceneNum() {
		return sceneNum;
	}



	public void setSceneNum(String sceneNum) {
		this.sceneNum = sceneNum;
	}



	public String getFacilityNum() {
		return facilityNum;
	}



	public void setFacilityNum(String facilityNum) {
		this.facilityNum = facilityNum;
	}



	
	

}
