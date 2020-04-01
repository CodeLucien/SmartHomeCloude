package com.example.entity;

public class Scenesmall {

	 private String sceneName;
	    private String sceneId;
	    private int imageId;

	    public Scenesmall(String sceneName, int imageId){
	        this.sceneName = sceneName;
	        
	        this.imageId = imageId;
	    }
	    public Scenesmall(String sceneName, String sceneId , int imageId){
	        this.sceneName = sceneName;
	        this.sceneId = sceneId;
	        this.imageId = imageId;
	    }
	    public Scenesmall() {

	    }
	    public String getSceneId() {
	        return sceneId;
	    }

	    public void setSceneId(String sceneId) {
	        this.sceneId = sceneId;
	    }
	    public void setSceneName(String sceneName) {
	        this.sceneName = sceneName;
	    }

	    public void setImageId(int imageId) {
	        this.imageId = imageId;
	    }

	    public String getSceneName(){
	        return sceneName;
	    }

	    public int getImageId(){
	        return imageId;
	    }
	
	
}
