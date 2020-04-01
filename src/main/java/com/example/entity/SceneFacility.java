package com.example.entity;

//场景设备的部分信息（需要保存到数据库的）
public class SceneFacility {
	private String facilityNum;//设备编号
	private String sceneNum;//场景编号
	private Boolean facilityStatus;//设备状态
	private String facilityStartTime;//设备启动时间
	
	public SceneFacility() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SceneFacility(String facilityNum, String sceneNum, Boolean facilityStatus, String facilityStartTime) {
		super();
		this.facilityNum = facilityNum;
		this.sceneNum = sceneNum;
		this.facilityStatus = facilityStatus;
		this.facilityStartTime = facilityStartTime;
	}

	public String getFacilityNum() {
		return facilityNum;
	}

	public void setFacilityNum(String facilityNum) {
		this.facilityNum = facilityNum;
	}

	public String getSceneNum() {
		return sceneNum;
	}

	public void setSceneNum(String sceneNum) {
		this.sceneNum = sceneNum;
	}

	public Boolean getFacilityStatus() {
		return facilityStatus;
	}

	public void setFacilityStatus(Boolean facilityStatus) {
		this.facilityStatus = facilityStatus;
	}

	public String getFacilityStartTime() {
		return facilityStartTime;
	}

	public void setFacilityStartTime(String facilityStartTime) {
		this.facilityStartTime = facilityStartTime;
	}
	
	
	
	
}
