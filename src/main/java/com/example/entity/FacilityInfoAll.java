package com.example.entity;


//场景添加设备时需要的实体类
public class FacilityInfoAll {
	private String facilityId;//设备编号
	private String facilityName;//设备名称
	private String facilityPicture;//设备图片
	private int facilityRoomId;//设备所在房间号
	private String facilityStatus;//设备状态
	
	public FacilityInfoAll() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacilityInfoAll(String facilityId, String facilityName ,int facilityRoomId,
			String facilityStatus,String facilityPicture) {
		super();
		this.facilityId = facilityId;
		this.facilityName = facilityName;
		this.facilityPicture = facilityPicture;
		this.facilityRoomId = facilityRoomId;
		this.facilityStatus = facilityStatus;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
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

	public String isFacilityStatus() {
		return facilityStatus;
	}

	public void setFacilityStatus(String facilityStatus) {
		this.facilityStatus = facilityStatus;
	}
	
	
	
	
}
