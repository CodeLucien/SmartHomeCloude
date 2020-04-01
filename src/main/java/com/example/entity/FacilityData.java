package com.example.entity;

import java.time.LocalDateTime;

public class FacilityData {

    private int facilityId;
    private LocalDateTime time;
    private String data;

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
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

    public FacilityData() {
    }

    public FacilityData(int facilityId, LocalDateTime time, String data) {
        this.facilityId = facilityId;
        this.time = time;
        this.data = data;
    }
}
