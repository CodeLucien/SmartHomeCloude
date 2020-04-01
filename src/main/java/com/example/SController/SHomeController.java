package com.example.SController;

import com.example.SController.ISController.ISHomeController;
import com.example.SService.SHomeService;
import com.example.entity.HomeInfo;
import com.example.entity.HomeRelationshipInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import util.Common;
import util.ResponseInfo;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/home")
public class SHomeController implements ISHomeController {
    @Autowired
    private SHomeService sHomeService;

    @Override
    @PostMapping("/createHomeInfo")
    public void createHomeInfo(@RequestParam HomeInfo homeInfo) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();

        if(homeInfo == null){
            responseInfo.setCode(Common.Result.FALL.id);
            responseInfo.setMsg("保存失败");
        }else{
            boolean createResult = sHomeService.addHomeInfo(homeInfo);
            if(createResult){
                responseInfo.setMsg("保存成功");
            }else{
                responseInfo.setMsg("保存失败");
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

    @Override
    @RequestMapping("/searchHomeInfoByHomeId")
    public void searchHomeInfoByHomeId(@RequestParam int homeId) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();

        HomeInfo roomInfo = sHomeService.findHomeInfoByHomeId(homeId);
        if(roomInfo == null){
            responseInfo.setMsg("查询失败");
        }else{
            responseInfo.setMsg("查询成功");
        }
        responseInfo.setBody(roomInfo);
        responseInfo.setCode(Common.Result.SUCCESS.id);

        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @RequestMapping("/deletHomeInfoByHomeId")
    public void deletHomeInfoByHomeId(@RequestParam int homeId) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();

        boolean deletResult  = sHomeService.removeHomeInfoByHomeId(homeId);
        if(deletResult){
            responseInfo.setMsg("删除成功");
        }else{
            responseInfo.setMsg("删除失败");
        }
        responseInfo.setCode(Common.Result.SUCCESS.id);
        responseInfo.setBody(deletResult);
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @PostMapping("/changeHomeInfo")
    public void changeHomeInfo(@RequestParam HomeInfo homeInfo) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();

        if(homeInfo == null){
            responseInfo.setCode(Common.Result.FALL.id);
            responseInfo.setMsg("修改失败");
        }else{
            boolean createResult = sHomeService.modifyHomeInfo(homeInfo);
            if(createResult){
                responseInfo.setMsg("修改成功");
            }else{
                responseInfo.setMsg("修改失败");
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

    @Override
    @RequestMapping("/searchHomeInfosByTelePhone")
    public void searchHomeInfosByTelePhone(@RequestParam String telePhone) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        List<HomeInfo> homeInfos = sHomeService.findHomeInfosByTelePhone(telePhone);
        if(homeInfos == null){
            responseInfo.setMsg("查询失败");
        }else{
            responseInfo.setMsg("查询成功");
        }
        responseInfo.setCode(Common.Result.SUCCESS.id);
        responseInfo.setBody(homeInfos);
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * HomeRelationshipInfo
     *
     * */
    @Override
    @PostMapping("/createHomeRelationshipInfo")
    public void createHomeRelationshipInfo(@RequestBody HomeRelationshipInfo homeRelationshipInfo) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();

        if(homeRelationshipInfo == null){
            responseInfo.setCode(Common.Result.FALL.id);
            responseInfo.setMsg("保存失败");
        }else{
            boolean createResult = sHomeService.addHomeRelationshipInfo(homeRelationshipInfo);
            if(createResult){
                responseInfo.setMsg("保存成功");
            }else{
                responseInfo.setMsg("保存失败");
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

    @Override
    @RequestMapping("/searchHomeRelationshipInfoByHomeId")
    public void searchHomeRelationshipInfoByHomeId(@RequestParam int homeId) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();

        List<HomeRelationshipInfo> homeRelationshipInfos = sHomeService.findHomeRelationshipInfoByHomeId(homeId);
        if(homeRelationshipInfos == null){
            responseInfo.setMsg("查询失败");
        }else{
            responseInfo.setMsg("查询成功");
        }
        responseInfo.setBody(homeRelationshipInfos);
        responseInfo.setCode(Common.Result.SUCCESS.id);

        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @RequestMapping("/searchHomeRelationshipInfoByTelephone")
    public void searchHomeRelationshipInfoByTelephone(@RequestParam String telePhone) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();

        List<HomeRelationshipInfo> homeRelationshipInfos = sHomeService.findHomeRelationshipInfoByTelephone(telePhone);
        if(homeRelationshipInfos == null){
            responseInfo.setMsg("查询失败");
        }else{
            responseInfo.setMsg("查询成功");
        }
        responseInfo.setBody(homeRelationshipInfos);

        responseInfo.setCode(Common.Result.SUCCESS.id);

        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @RequestMapping("/searchHomeRelationshipInfoByTelephoneAndHomeId")
    public void searchHomeRelationshipInfoByTelephoneAndHomeId(@RequestParam String telePhone, @RequestParam int homeId) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();

        HomeRelationshipInfo homeRelationshipInfo = sHomeService.findHomeRelationshipInfoByTelephoneAndHomeId(telePhone,homeId);
        if(homeRelationshipInfo == null){
            responseInfo.setMsg("查询失败");
        }else{
            responseInfo.setMsg("查询成功");
        }
        responseInfo.setBody(homeRelationshipInfo);

        responseInfo.setCode(Common.Result.SUCCESS.id);

        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @RequestMapping("/deletHomeRelationshipInfoByHomeId")
    public void deletHomeRelationshipInfoByHomeId(@RequestParam int homeId) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();


        boolean deletResult  = sHomeService.removeHomeRelationshipInfoByHomeId(homeId);
        if (deletResult) {
            responseInfo.setMsg("删除成功");
        } else {
            responseInfo.setMsg("删除失败");
        }
        responseInfo.setCode(Common.Result.SUCCESS.id);
        responseInfo.setBody(deletResult);
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @RequestMapping("/deletHomeRelationshipInfoByTelephoneAndHomeId")
    public void deletHomeRelationshipInfoByTelephoneAndHomeId(@RequestParam String telePhone,@RequestParam int homeId) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();


        boolean deletResult  = sHomeService.removeHomeRelationshipInfoByTelephoneAndHomeId(telePhone,homeId);
        if (deletResult) {
            responseInfo.setMsg("删除成功");
        } else {
            responseInfo.setMsg("删除失败");
        }
        responseInfo.setCode(Common.Result.SUCCESS.id);
        responseInfo.setBody(deletResult);
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @PostMapping("/changeHomeRelationshipInfo")
    public void changeHomeRelationshipInfo(@RequestParam HomeRelationshipInfo homeRelationshipInfo) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();

        if(homeRelationshipInfo == null){
            responseInfo.setCode(Common.Result.FALL.id);
            responseInfo.setMsg("修改失败");
        }else{
            boolean createResult = sHomeService.modifyHomeRelationshipInfo(homeRelationshipInfo);
            if(createResult){
                responseInfo.setMsg("修改成功");
            }else{
                responseInfo.setMsg("修改失败");
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




}
