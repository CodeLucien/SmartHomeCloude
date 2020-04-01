package com.example.entity;

import java.time.LocalDateTime;

//场景的实体类
public class Scene {
	private String sceneNum;//场景编号1
	private String sceneName;//场景名称2
	private String scenePicture;//场景背景图3
	private LocalDateTime createTime;//创建时间4
	private String startTime;//场景启动时间5
	private String directive;//指令信息6
	
	public Scene() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Scene(String sceneNum, String sceneName, String scenePicture, LocalDateTime createTime, String startTime,
			String directive) {
		super();
		this.sceneNum = sceneNum;
		this.sceneName = sceneName;
		this.scenePicture = scenePicture;
		this.createTime = createTime;
		this.startTime = startTime;
		this.directive = directive;
	}

	public String getSceneNum() {
		return sceneNum;
	}

	public void setSceneNum(String sceneNum) {
		this.sceneNum = sceneNum;
	}

	public String getSceneName() {
		return sceneName;
	}

	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}

	public String getScenePicture() {
		return scenePicture;
	}

	public void setScenePicture(String scenePicture) {
		this.scenePicture = scenePicture;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getDirective() {
		return directive;
	}

	public void setDirective(String directive) {
		this.directive = directive;
	}
	
	
	
	
}
