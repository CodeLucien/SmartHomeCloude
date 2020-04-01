package com.example.entity;

public class FacilityTypeInfo {
    private String type;
    private String description;
    private String image;
    private String tags;

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public FacilityTypeInfo(String type, String description, String image, String tags) {
        this.type = type;
        this.description = description;
        this.image = image;
        this.tags = tags;
    }
}
