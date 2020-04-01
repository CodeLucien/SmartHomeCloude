package com.example.entity;

import java.time.LocalDateTime;

public class FacilityDataInfo {

    private String facilityId;
    private LocalDateTime time;
    private String data;


    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public FacilityDataInfo(String facilityId, LocalDateTime time, String data) {
        this.facilityId = facilityId;
        this.time = time;
        this.data = data;
    }
}
