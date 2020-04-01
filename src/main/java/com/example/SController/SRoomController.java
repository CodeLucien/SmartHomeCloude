package com.example.SController;

import com.example.SController.ISController.ISRoomController;
import com.example.SService.SRoomService;
import com.example.entity.RoomInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import util.Common.Result;
import util.ResponseInfo;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/room")
public class SRoomController implements ISRoomController {

    @Autowired
    private SRoomService sRoomService;

    @RequestMapping(value = "/searchRoomInfosByHomeId")
    public void searchRoomInfosByHomeId(@RequestParam int homeId){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        List<RoomInfo> roomInfos = sRoomService.findRoomInfosByHomeId(homeId);
        if(roomInfos == null){
            responseInfo.setMsg("查询失败");
        }else{
            responseInfo.setMsg("查询成功");
        }
        responseInfo.setCode(Result.SUCCESS.id);
        responseInfo.setBody(roomInfos);
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/isExistOfRoomInfo")
    public void isExistOfRoomInfo(@RequestParam int roomId){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();

        RoomInfo roomInfo = sRoomService.findRoomInfoByRoomId(roomId);
        if(roomInfo == null){
            responseInfo.setMsg("房间不存在");
            responseInfo.setBody(false);
        }else{
            responseInfo.setMsg("查询成功");
            responseInfo.setBody(true);
        }
        responseInfo.setCode(Result.SUCCESS.id);

        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/createRoomInfo")
    public void createRoomInfo(@RequestBody RoomInfo roomInfo){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();
        if(roomInfo == null){
            responseInfo.setCode(Result.FALL.id);
            responseInfo.setMsg("保存失败");
        }else{
            boolean createResult = sRoomService.addRoomInfo(roomInfo);
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

    @ResponseBody
    @PostMapping(value ="/deletRoomsByRoomIds")
    public void deletRoomsByRoomIds(@RequestBody List<Integer> roomIds){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setContentType("text/JavaScript;charset=utf-8");
        ResponseInfo responseInfo = new ResponseInfo();

        boolean deletResult  = sRoomService.removeRoomsByRoomIds(roomIds);
        if(deletResult  == false){
            responseInfo.setMsg("删除失败");
        }else{
            responseInfo.setMsg("删除成功");
        }
        responseInfo.setCode(Result.SUCCESS.id);
        responseInfo.setBody(deletResult);
        try {
            response.getWriter().println(responseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}