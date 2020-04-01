package com.example.entity;

import java.time.LocalDateTime;

//场景设备实体类（全部信息）部分数据需要从其他地方查
public class SceneFacilityInfo {
	private String facilityId;//设备编号
	private int sceneId;//场景编号
	private String facilityName;//设备名称
	private String facilityPicture;//设备图片
	private int facilityRoomId;//设备所在房间号
	private boolean facilityStatus;//设备状态
	private LocalDateTime facilityStartTime;//设备启动时间
	
	public SceneFacilityInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SceneFacilityInfo(String facilityId, int sceneId, String facilityName, String facilityPicture,
			int facilityRoomId, boolean facilityStatus, LocalDateTime facilityStartTime) {
		super();
		this.facilityId = facilityId;
		this.sceneId = sceneId;
		this.facilityName = facilityName;
		this.facilityPicture = facilityPicture;
		this.facilityRoomId = facilityRoomId;
		this.facilityStatus = facilityStatus;
		this.facilityStartTime = facilityStartTime;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getFacilityPicture() {
		return facilityPicture;
	}

	public void setFacilityPicture(String facilityPicture) {
		this.facilityPicture = facilityPicture;
	}

	public int getFacilityRoomId() {
		return facilityRoomId;
	}

	public void setFacilityRoomId(int facilityRoomId) {
		this.facilityRoomId = facilityRoomId;
	}

	public boolean isFacilityStatus() {
		return facilityStatus;
	}

	public void setFacilityStatus(boolean facilityStatus) {
		this.facilityStatus = facilityStatus;
	}

	public LocalDateTime getFacilityStartTime() {
		return facilityStartTime;
	}

	public void setFacilityStartTime(LocalDateTime facilityStartTime) {
		this.facilityStartTime = facilityStartTime;
	}
	
	
	
}
