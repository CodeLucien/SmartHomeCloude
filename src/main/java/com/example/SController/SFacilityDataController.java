package com.example.SController;

import com.example.SController.ISController.ISFacilityDataController;
import com.example.SService.SFacilityDataService;
import com.example.entity.FacilityDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import util.Common;
import util.ResponseInfo;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/facilityData")
public class SFacilityDataController implements ISFacilityDataController {

    @Autowired
    private SFacilityDataService sFacilityDataService;
    @PostMapping(value = "/createFacilityDataInfo")
    public void createFacilityDataInfo(@RequestParam FacilityDataInfo facilityDataInfo) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        if (facilityDataInfo==null){
            responseInfo.setCode(Common.Result.FALL.id);
            responseInfo.setMsg("保存失败");
        }else {
            boolean createResult = sFacilityDataService.addFacilityDataInfo(facilityDataInfo);
            if(createResult == false){
                responseInfo.setMsg("保存失败");
            }else{
                responseInfo.setMsg("保存成功");
            }
            responseInfo.setCode(Common.Result.SUCCESS.id);
            responseInfo.setBody(createResult);
        }
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/searchFacilityDataInfoByFacilityId")
    public void searchFacilityDataInfoByFacilityId(@RequestParam String facilityId) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        if (facilityId==null){
            responseInfo.setCode(Common.Result.FALL.id);
            responseInfo.setMsg("查询失败");
        }else {
            List<FacilityDataInfo> facilityDataInfos = sFacilityDataService.findFacilityDataInfoByFacilityId(facilityId);
            if(facilityDataInfos == null){
                responseInfo.setMsg("查询失败");
            }else{
                responseInfo.setMsg("查询成功");
            }
            responseInfo.setCode(Common.Result.SUCCESS.id);
            responseInfo.setBody(facilityDataInfos);

        }
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/deletFacilityDataInfoByFacilityId")
    public void deletFacilityDataInfoByFacilityId(@RequestParam String facilityId) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        if (facilityId==null){
            responseInfo.setCode(Common.Result.FALL.id);
            responseInfo.setMsg("删除失败");
        }else {
            boolean deletResult  = sFacilityDataService.removeFacilityDataInfoByFacilityId(facilityId);
            if(deletResult  == false){
                responseInfo.setMsg("删除失败");
            }else{
                responseInfo.setMsg("删除成功");
            }
            responseInfo.setCode(Common.Result.SUCCESS.id);
            responseInfo.setBody(deletResult);

        }
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
