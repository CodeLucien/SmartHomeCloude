package com.example.SController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.SController.ISController.ISSceneController;
import com.example.SService.SSceneService;
import com.example.entity.ChooseFacility;
import com.example.entity.FacilityInfoAll;
import com.example.entity.Scene;
import com.example.entity.SceneFacility;
import com.example.entity.Scenesmall;

import util.Common.Result;
import util.ResponseInfo;

@RestController
@ComponentScan(basePackages = {"com.example.SService" })
@RequestMapping("/scene")
public class SSceneController implements ISSceneController {

	@Autowired
	private SSceneService sSceneService;
	
	
	//21手动添加场景[1]√
	@PostMapping(value ="/addSceneCon")
	public void addSceneCon(@RequestBody Scenesmall scene) {
		// TODO Auto-generated method stub String sceneName
		//RequestContextHolder是持有上下文的Request容器（Spring MVC提供的工具类）
    	//通过RequestContextHolder获得ServletRequestAttributes
		 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse是请求的对象，通过ServletRequestAttribute对象获得HttpServletRequest
	     HttpServletResponse response = servletRequestAttributes.getResponse();
	     //responseInfo是后端往前端传数据的封装
	     response.setContentType("text/JavaScript;charset=utf-8");
	     ResponseInfo responseInfo = new ResponseInfo();
	     String name = "1111";
	     Scenesmall scenes = new Scenesmall("changj14904","1234是v56",0);//名字和id
	    // String addSceneResult = sSceneService.addSceneSer(sceneName);
	     boolean addSceneResult = sSceneService.addSceneSer(scene);
	     if(addSceneResult  == false){
	            responseInfo.setMsg("添加场景失败");
	            //return "Yes";
	        }else{
	        	
	            responseInfo.setMsg("添加场景成功");
	            
	        }
	        responseInfo.setCode(Result.SUCCESS.id);
	        responseInfo.setBody(addSceneResult);
	        try {
	            response.getWriter().println(responseInfo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	       
	}

	//22手动删除场景[2]
	@RequestMapping("/removeSceneCon")
	public void removeSceneCon(@RequestParam String sceneNum) {
		//RequestContextHolder是持有上下文的Request容器（Spring MVC提供的工具类）
    	//通过RequestContextHolder获得ServletRequestAttributes
		 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse是请求的对象，通过ServletRequestAttribute对象获得HttpServletRequest
	     HttpServletResponse response = servletRequestAttributes.getResponse();
	     //responseInfo是后端往前端传数据的封装
	     response.setContentType("text/JavaScript;charset=utf-8");
	     ResponseInfo responseInfo = new ResponseInfo();
	     String num = "48026610408541c59384be278fb95e51";
	     
	     boolean deleteSceneResult = sSceneService.removeSceneSer(sceneNum);
	     if(deleteSceneResult  == false){
	            responseInfo.setMsg("删除场景失败");
	        }else{
	            responseInfo.setMsg("删除场景成功");
	        }
	        responseInfo.setCode(Result.SUCCESS.id);
	        responseInfo.setBody(deleteSceneResult);
	        try {
	            response.getWriter().println(responseInfo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	  
		
	}

	//查询所有设备
	@RequestMapping("/queryAllFaciltyCon")
	public void queryAllFaciltyCon() {
		//RequestContextHolder是持有上下文的Request容器（Spring MVC提供的工具类）
    	//通过RequestContextHolder获得ServletRequestAttributes
		 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse是请求的对象，通过ServletRequestAttribute对象获得HttpServletRequest
	     HttpServletResponse response = servletRequestAttributes.getResponse();
	     //responseInfo是后端往前端传数据的封装
	     response.setContentType("text/JavaScript;charset=utf-8");
	     ResponseInfo<ArrayList<FacilityInfoAll>> responseInfo = new ResponseInfo<ArrayList<FacilityInfoAll>>();
	     ArrayList<FacilityInfoAll> allFacilityInfo = sSceneService.queryAllFaciltySer();
	     
	    
	     if(allFacilityInfo  == null){
	            responseInfo.setMsg("查询设备失败");
	        }else{
	            responseInfo.setMsg("查询设备成功");
	        }
	        responseInfo.setCode(Result.SUCCESS.id);
	        responseInfo.setBody(allFacilityInfo);
	        try {
	            response.getWriter().println(responseInfo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

	//23添加场景设备[3]√
	@PostMapping("/addFacilityCon")
	public void addFacilityCon(@RequestBody ArrayList<ChooseFacility> choosefacility) {
		//RequestContextHolder是持有上下文的Request容器（Spring MVC提供的工具类）
    	//通过RequestContextHolder获得ServletRequestAttributes
		 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse是请求的对象，通过ServletRequestAttribute对象获得HttpServletRequest
	     HttpServletResponse response = servletRequestAttributes.getResponse();
	     //responseInfo是后端往前端传数据的封装
	     response.setContentType("text/JavaScript;charset=utf-8");
	     ResponseInfo responseInfo = new ResponseInfo();
	     
	     String sId = "33";
	     ArrayList<String> list = new ArrayList<String>(){{add("f001"); add("f007");}};  
	     
	     boolean addFacilityResult = sSceneService.addFacilitySer(choosefacility);
	     
	     if(addFacilityResult  == false){
	            responseInfo.setMsg("添加场景设备失败！");
	        }else{
	            responseInfo.setMsg("添加场景设备成功");
	        }
	        responseInfo.setCode(Result.SUCCESS.id);
	        responseInfo.setBody(addFacilityResult);
	        try {
	            response.getWriter().println(responseInfo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

	@Override //24设置场景设备[4]（！已经包含了场景id） √
	@RequestMapping("/amendFacilityCon")
	public void amendFacilityCon(@RequestParam String sceneId, ArrayList<SceneFacility> SceneFacilitys) {
		//RequestContextHolder是持有上下文的Request容器（Spring MVC提供的工具类）
    	//通过RequestContextHolder获得ServletRequestAttributes
		 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse是请求的对象，通过ServletRequestAttribute对象获得HttpServletRequest
	     HttpServletResponse response = servletRequestAttributes.getResponse();
	     //responseInfo是后端往前端传数据的封装
	     response.setContentType("text/JavaScript;charset=utf-8");
	     ResponseInfo responseInfo = new ResponseInfo();
	     
	    /* String sId = "3";
	     SceneFacility s1 = new SceneFacility("f001","3","start","2019-12-26 15:18:01");
	     SceneFacility s2 = new SceneFacility("f002","3","stop","2019-12-27 15:18:01");
	     ArrayList<SceneFacility> list = new ArrayList<SceneFacility>(){{add(s1); add(s2);}};  
	     */
	     
	     boolean amendFacilityResult = sSceneService.amendFacilitySer(sceneId, SceneFacilitys);
	     //boolean amendFacilityResult = false;
	     if(amendFacilityResult  == false){
	            responseInfo.setMsg("设置场景设备失败！");
	        }else{
	            responseInfo.setMsg("设置场景设备成功");
	        }
	        responseInfo.setCode(Result.SUCCESS.id);
	        responseInfo.setBody(amendFacilityResult);
	        try {
	            response.getWriter().println(responseInfo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

	//25删除场景设备[5] √
	@RequestMapping("/removeFacilityCon")
	public void removeFacilityCon(@RequestParam String sceneId,@RequestParam String facilityId) {
		//RequestContextHolder是持有上下文的Request容器（Spring MVC提供的工具类）
    	//通过RequestContextHolder获得ServletRequestAttributes
		 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse是请求的对象，通过ServletRequestAttribute对象获得HttpServletRequest
	     HttpServletResponse response = servletRequestAttributes.getResponse();
	     //responseInfo是后端往前端传数据的封装
	     response.setContentType("text/JavaScript;charset=utf-8");
	     ResponseInfo responseInfo = new ResponseInfo();
	     

	     String sId = "1";
	     ArrayList<String> list = new ArrayList<String>(){{add("f005"); add("f006");}};  
	     
	     
	     boolean removeFacilityResult = sSceneService.removeFacilitySer(sceneId, facilityId);
	     
	     if(removeFacilityResult  == false){
	            responseInfo.setMsg("删除场景设备失败！");
	        }else{
	            responseInfo.setMsg("删除场景设备成功");
	        }
	        responseInfo.setCode(Result.SUCCESS.id);
	        responseInfo.setBody(removeFacilityResult);
	        try {
	            response.getWriter().println(responseInfo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override//26更换场景背景图[6] √
	@RequestMapping("/modifySceneBgCon")
	public void modifySceneBgCon(@RequestParam String sceneId, String scenePicture) {
		//RequestContextHolder是持有上下文的Request容器（Spring MVC提供的工具类）
    	//通过RequestContextHolder获得ServletRequestAttributes
		 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse是请求的对象，通过ServletRequestAttribute对象获得HttpServletRequest
	     HttpServletResponse response = servletRequestAttributes.getResponse();
	     //responseInfo是后端往前端传数据的封装
	     response.setContentType("text/JavaScript;charset=utf-8");
	     ResponseInfo responseInfo = new ResponseInfo();
	     String s = "1";
	     String im = "image2";
	     boolean modifySceneBgResult = sSceneService.modifySceneBgSer(sceneId, scenePicture);
	     
	     if(modifySceneBgResult  == false){
	            responseInfo.setMsg("更换背景图片失败！");
	        }else{
	            responseInfo.setMsg("更换背景图片成功");
	        }
	        responseInfo.setCode(Result.SUCCESS.id);
	        responseInfo.setBody(modifySceneBgResult);
	        try {
	            response.getWriter().println(responseInfo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override//查看设备是否存在 √
	@RequestMapping("/isExistFacilityCon")
	public void isExistFacilityCon(@RequestParam String sceneId) {
		// TODO Auto-generated method stub
		//RequestContextHolder是持有上下文的Request容器（Spring MVC提供的工具类）
    	//通过RequestContextHolder获得ServletRequestAttributes
		 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse是请求的对象，通过ServletRequestAttribute对象获得HttpServletRequest
	     HttpServletResponse response = servletRequestAttributes.getResponse();
	     //responseInfo是后端往前端传数据的封装
	     response.setContentType("text/JavaScript;charset=utf-8");
	     ResponseInfo responseInfo = new ResponseInfo();
	     String Id  = "4";
	     boolean isExistResult = sSceneService.isExistFacilitySer(sceneId);
	     
	     if(isExistResult  == false){
	            responseInfo.setMsg("场景中无设备,请在场景中添加设备！");
	        }else{
	            responseInfo.setMsg("场景中有设备！");
	        }
	        responseInfo.setCode(Result.SUCCESS.id);
	        responseInfo.setBody(isExistResult);
	        try {
	            response.getWriter().println(responseInfo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

	@Override //27一键启用场景[7]//28一键停用场景[8] √
	@RequestMapping("/setSceneOrderCon")
	public void setSceneOrderCon(@RequestParam String sceneId, @RequestParam String order) {
		//RequestContextHolder是持有上下文的Request容器（Spring MVC提供的工具类）
    	//通过RequestContextHolder获得ServletRequestAttributes
		 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse是请求的对象，通过ServletRequestAttribute对象获得HttpServletRequest
	     HttpServletResponse response = servletRequestAttributes.getResponse();
	     //responseInfo是后端往前端传数据的封装
	     response.setContentType("text/JavaScript;charset=utf-8");
	     ResponseInfo responseInfo = new ResponseInfo();
	     boolean setSceneOrderResult ;
	     String id = "1";
	     String o = "start";
	     boolean isExistResult = sSceneService.isExistFacilitySer(sceneId);
	     if(isExistResult==false) {
	    	 setSceneOrderResult = false;
	     }else {
	    	  setSceneOrderResult = sSceneService.setSceneOrderSer(sceneId, order);
	     }
	     
	     
	     if(setSceneOrderResult  == false){
	            responseInfo.setMsg("场景操作失败！");
	        }else{
	            responseInfo.setMsg("场景操作成功！");
	        }
	        responseInfo.setCode(Result.SUCCESS.id);
	        responseInfo.setBody(setSceneOrderResult);
	        try {
	            response.getWriter().println(responseInfo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		
	}
    /*!!!!!!!*/
	@Override//29更新离家场景序列图（）[9]  将前端收集到的数据信息采集到的信息保存在数据库中 √
	@RequestMapping("/renewalLHFacilityCon")
	public void renewalLHFacilityCon(@RequestParam  String sceneId,ArrayList<String> facilityId) {
		//RequestContextHolder是持有上下文的Request容器（Spring MVC提供的工具类）
    	//通过RequestContextHolder获得ServletRequestAttributes
		 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse是请求的对象，通过ServletRequestAttribute对象获得HttpServletRequest
	     HttpServletResponse response = servletRequestAttributes.getResponse();
	     //responseInfo是后端往前端传数据的封装
	     response.setContentType("text/JavaScript;charset=utf-8");
	     ResponseInfo responseInfo = new ResponseInfo();
	     
	     String sId = "notice";
	     ArrayList<String> list = new ArrayList<String>(){{add("noticef001"); add("noticef007");}};  
	     
	     boolean renewalLHFacilityResult = sSceneService.renewalLHFacilitySer(sceneId, facilityId);
	     
	     if(renewalLHFacilityResult  == false){
	            responseInfo.setMsg("添加场景设备失败！");
	        }else{
	            responseInfo.setMsg("添加场景设备成功");
	        }
	        responseInfo.setCode(Result.SUCCESS.id);
	        responseInfo.setBody(renewalLHFacilityResult);
	        try {
	            response.getWriter().println(responseInfo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override//30移除离家场景设备[10] √
	@RequestMapping("/deleteLHFacilityCon")
	public void deleteLHFacilityCon(@RequestParam String sceneId, ArrayList<String> facilityId) {
		//RequestContextHolder是持有上下文的Request容器（Spring MVC提供的工具类）
    	//通过RequestContextHolder获得ServletRequestAttributes
		 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse是请求的对象，通过ServletRequestAttribute对象获得HttpServletRequest
	     HttpServletResponse response = servletRequestAttributes.getResponse();
	     //responseInfo是后端往前端传数据的封装
	     response.setContentType("text/JavaScript;charset=utf-8");
	     ResponseInfo responseInfo = new ResponseInfo();
	     
	     String sId = "1";
	     ArrayList<String> list = new ArrayList<String>(){{add("f003"); add("f005");}};  
	     boolean deleteLHFacilityResult = sSceneService.deleteLHFacilitySer(sId, list);
	     
	     if(deleteLHFacilityResult  == false){
	            responseInfo.setMsg("移除离家场景设备失败！");
	        }else{
	            responseInfo.setMsg("移除离家场景设备成功！");
	        }
	        responseInfo.setCode(Result.SUCCESS.id);
	        responseInfo.setBody(deleteLHFacilityResult);
	        try {
	            response.getWriter().println(responseInfo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override//31设置离家场景启用时间!!!!!!![11] √
	@RequestMapping("/setLHLaunchTimeCon")
	public void setLHLaunchTimeCon(@RequestParam String sceneId, @RequestParam String startTime) {
		//RequestContextHolder是持有上下文的Request容器（Spring MVC提供的工具类）
    	//通过RequestContextHolder获得ServletRequestAttributes
		 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse是请求的对象，通过ServletRequestAttribute对象获得HttpServletRequest
	     HttpServletResponse response = servletRequestAttributes.getResponse();
	     //responseInfo是后端往前端传数据的封装
	     response.setContentType("text/JavaScript;charset=utf-8");
	     ResponseInfo responseInfo = new ResponseInfo();
	    
	     String id = "1fc1c589573f4ab7aa9e5e9f62dc4a2a";
	    
	     boolean setLHLaunchTimeResult = sSceneService.setLHLaunchTimeSer(sceneId, startTime);
	     
	     if(setLHLaunchTimeResult  == false){
	            responseInfo.setMsg("设置离家场景启用时间失败！");
	        }else{
	            responseInfo.setMsg("设置离家场景启用时间成功！");
	        }
	        responseInfo.setCode(Result.SUCCESS.id);
	        responseInfo.setBody(setLHLaunchTimeResult);
	        try {
	            response.getWriter().println(responseInfo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override//32启用离家场景[12]//33停用离家场景[13]
	@RequestMapping("/modifyLHSceneOrderCon")
	public void modifyLHSceneOrderCon(@RequestParam  String order) {
		//RequestContextHolder是持有上下文的Request容器（Spring MVC提供的工具类）
    	//通过RequestContextHolder获得ServletRequestAttributes
		 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse是请求的对象，通过ServletRequestAttribute对象获得HttpServletRequest
	     HttpServletResponse response = servletRequestAttributes.getResponse();
	     //responseInfo是后端往前端传数据的封装
	     response.setContentType("text/JavaScript;charset=utf-8");
	     ResponseInfo responseInfo = new ResponseInfo();
	     String id = "2";
	     String o = "start";
	     boolean modifyLHSceneOrderResult = sSceneService.modifyLHSceneOrderSer( order);
	     
	     if(modifyLHSceneOrderResult  == false){
	            responseInfo.setMsg("指令发送失败！");
	        }else{
	            responseInfo.setMsg("指令发送成功！");
	        }
	        responseInfo.setCode(Result.SUCCESS.id);
	        responseInfo.setBody(modifyLHSceneOrderResult);
	        try {
	            response.getWriter().println(responseInfo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		
	}
	/*!!!!!!!!!!*/
	@Override//34更新通知场景（）[14] √
	@RequestMapping("/renewalInformFacilityCon")
	public void renewalInformFacilityCon(@RequestParam String sceneId , ArrayList<String> facilityId) {
		//RequestContextHolder是持有上下文的Request容器（Spring MVC提供的工具类）
    	//通过RequestContextHolder获得ServletRequestAttributes
		 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse是请求的对象，通过ServletRequestAttribute对象获得HttpServletRequest
	     HttpServletResponse response = servletRequestAttributes.getResponse();
	     //responseInfo是后端往前端传数据的封装
	     response.setContentType("text/JavaScript;charset=utf-8");
	     ResponseInfo responseInfo = new ResponseInfo();
	     
	     String sId = "inform";
	     ArrayList<String> list = new ArrayList<String>(){{add("informf001"); add("informf007");}};  
	     
	     boolean addFacilityResult = sSceneService.renewalInformFacilitySer(sceneId, facilityId);
	     
	     if(addFacilityResult  == false){
	            responseInfo.setMsg("添加场景设备失败！");
	        }else{
	            responseInfo.setMsg("添加场景设备成功");
	        }
	        responseInfo.setCode(Result.SUCCESS.id);
	        responseInfo.setBody(addFacilityResult);
	        try {
	            response.getWriter().println(responseInfo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override//35设置通知场景启用时间!!!!!!!!![16]31 √
	@RequestMapping("/setInformTimeCon")
	public void setInformTimeCon(@RequestParam String sceneId, String startTime) {
		//RequestContextHolder是持有上下文的Request容器（Spring MVC提供的工具类）
    	//通过RequestContextHolder获得ServletRequestAttributes
		 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse是请求的对象，通过ServletRequestAttribute对象获得HttpServletRequest
	     HttpServletResponse response = servletRequestAttributes.getResponse();
	     //responseInfo是后端往前端传数据的封装
	     response.setContentType("text/JavaScript;charset=utf-8");
	     ResponseInfo responseInfo = new ResponseInfo();
	     
	     
	     String id = "452e3f6af1da4ae29b442a6734a27838";
	     String s = "2019-12-27 18:18:01";
	     boolean setInformTimeResult = sSceneService.setInformTimeSer(id, s);
	     
	     if(setInformTimeResult  == false){
	            responseInfo.setMsg("时间设置失败！");
	        }else{
	            responseInfo.setMsg("时间设置成功！");
	        }
	        responseInfo.setCode(Result.SUCCESS.id);
	        responseInfo.setBody(setInformTimeResult);
	        try {
	            response.getWriter().println(responseInfo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override//36启用通知场景startInformOrder[16]//37停用通知场景stopInformOrder[17] √
	@RequestMapping("/modifyInformSceneOrderCon")
	public void modifyInformSceneOrderCon(String sceneId, String order) {
		//RequestContextHolder是持有上下文的Request容器（Spring MVC提供的工具类）
    	//通过RequestContextHolder获得ServletRequestAttributes
		 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse是请求的对象，通过ServletRequestAttribute对象获得HttpServletRequest
	     HttpServletResponse response = servletRequestAttributes.getResponse();
	     //responseInfo是后端往前端传数据的封装
	     response.setContentType("text/JavaScript;charset=utf-8");
	     ResponseInfo responseInfo = new ResponseInfo();
	     
	     String id = "a41242102be34bd9b37f9ee65cfc041d";
	     String o = "start";
	     
	     boolean modifyInformSceneOrderResult = sSceneService.modifyInformSceneOrderSer(sceneId, order);
	     
	     if(modifyInformSceneOrderResult  == false){
	            responseInfo.setMsg("通知场景指令发送失败！");
	        }else{
	            responseInfo.setMsg("通知场景指令发送成功！");
	        }
	        responseInfo.setCode(Result.SUCCESS.id);
	        responseInfo.setBody(modifyInformSceneOrderResult);
	        try {
	            response.getWriter().println(responseInfo);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}
		
	}
	

