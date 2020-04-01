package com.example.SController;

import com.example.SController.ISController.ISFacilityController;
import com.example.SService.SFacilityDataService;
import com.example.SService.SFacilityService;
import com.example.entity.FacilityInfo;
import com.example.entity.FacilityTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import util.Common;
import util.Common.Result;
import util.ResponseInfo;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/facility")
public class SFacilityController implements ISFacilityController {


    @Autowired
    private SFacilityService sFacilityService;

    @Autowired
    private SFacilityDataService sFacilityDataService;

    @Override
    @PostMapping(value = "/createFacilityInfo")
    public void createFacilityInfo(@RequestBody  FacilityInfo facilityInfo){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        if(facilityInfo == null){
            responseInfo.setCode(Result.FALL.id);
            responseInfo.setMsg("保存失败");
        }else{
            boolean createResult = sFacilityService.addFacilityInfo(facilityInfo);
            if(createResult == false){
                responseInfo.setMsg("保存失败");
            }else{
                responseInfo.setMsg("保存成功");
            }
            responseInfo.setCode(Result.SUCCESS.id);
            responseInfo.setBody(createResult);
        }
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/searchFacilityTypeInfos")
    public void searchFacilityTypeInfos(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        List<FacilityTypeInfo> facilityTypeInfos = sFacilityService.findFacilityTypeInfos();
        if(facilityTypeInfos == null){
            responseInfo.setMsg("查询失败");
        }else{
            responseInfo.setMsg("查询成功");
        }
        responseInfo.setCode(Result.SUCCESS.id);
        responseInfo.setBody(facilityTypeInfos);
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @RequestMapping("/cancelFacilityByFacilityId")
    public void cancelFacilityByFacilityId(String facilityId) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        if (facilityId==null){
            responseInfo.setCode(Common.Result.FALL.id);
            responseInfo.setMsg("删除失败");
        }else {
            boolean deletResult  = sFacilityService.removeFacilityInfoByFacilityId(facilityId);
            if(deletResult  == true ){
                responseInfo.setMsg("删除成功");
                responseInfo.setCode(Common.Result.SUCCESS.id);
            }else{
                responseInfo.setMsg("删除失败");
                responseInfo.setCode(Common.Result.FALL.id);
            }
            responseInfo.setBody(deletResult);

        }
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/searchFacilityInfosByHomeId")
    public void searchFacilityInfosByHomeId(@RequestParam int homeId){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        List<FacilityInfo> facilityInfos = sFacilityService.findFacilityInfosByHomeId(homeId);
        if(facilityInfos == null){
            responseInfo.setMsg("查询失败");
        }else{
            responseInfo.setMsg("查询成功");
        }
        responseInfo.setCode(Result.SUCCESS.id);
        responseInfo.setBody(facilityInfos);
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/searchFacilityInfoByHomeId")
    @Override
    public void searchFacilityInfoByHomeId(@RequestParam int homeId) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        FacilityInfo facilityInfo = sFacilityService.findFacilityInfoByHomeId(homeId);
        if(facilityInfo == null){
            responseInfo.setMsg("查询失败");
        }else{
            responseInfo.setMsg("查询成功");
        }
        responseInfo.setCode(Result.SUCCESS.id);
        responseInfo.setBody(facilityInfo);
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("/searchFacilityInfoByFacilityId")
    @Override
    public void searchFacilityInfoByFacilityId(@RequestParam String facilityId) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        FacilityInfo facilityInfo = sFacilityService.findFacilityInfoByFacilityId(facilityId);
        if(facilityInfo == null){
            responseInfo.setMsg("查询失败");
        }else{
            responseInfo.setMsg("查询成功");
        }
        responseInfo.setCode(Result.SUCCESS.id);
        responseInfo.setBody(facilityInfo);
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/searchFacilityInfosByIsCommon")
    @Override
    public void searchFacilityInfosByIsCommon(@RequestParam boolean isCommon,@RequestParam int homeId) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        List<FacilityInfo> facilityInfos = sFacilityService.findFacilityInfosByIsCommon(isCommon,homeId);
        if(facilityInfos == null){
            responseInfo.setMsg("查询失败");
        }else{
            responseInfo.setMsg("查询成功");
        }
        responseInfo.setCode(Result.SUCCESS.id);
        responseInfo.setBody(facilityInfos);
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/changeFacilityInfoByIsCommon")
    @Override
    public void changeFacilityInfoByIsCommon(@RequestParam String facilityId, @RequestParam boolean isCommon) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        boolean changeResult = sFacilityService.modifyFacilityInfoByIsCommon(facilityId,isCommon);
        if(changeResult == false){
            responseInfo.setMsg("修改失败");
        }else{
            responseInfo.setMsg("修改成功");
            responseInfo.setCode(Result.SUCCESS.id);
        }
        responseInfo.setBody(changeResult);
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/changeFacilityInfoByFacilityName")
    @Override
    public void changeFacilityInfoByFacilityName(String facilityId, String facilityName) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        boolean changeResult = sFacilityService.modifyFacilityInfoByFacilityName(facilityId,facilityName);
        if(changeResult == false){
            responseInfo.setMsg("修改失败");
        }else{
            responseInfo.setMsg("修改成功");
            responseInfo.setCode(Result.SUCCESS.id);
        }
        responseInfo.setBody(changeResult);
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}