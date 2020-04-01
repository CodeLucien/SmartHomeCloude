package com.example.SController;

import command.LightCommand;
import com.alibaba.fastjson.JSON;
import com.example.SController.ISController.ISCommandController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import server.FacilitySocketManager;

@RestController
@RequestMapping("/command")
public class SCommandController implements ISCommandController {

    @RequestMapping(value = "/controlLight")
    public void controlLight(@RequestParam String facilityId,@RequestParam boolean state) {
        System.out.println("facilityId:"+facilityId);
        System.out.println(""+state);
        if (state){
            FacilitySocketManager.getManager().sendCommand(facilityId,""+0);
        }else {
            FacilitySocketManager.getManager().sendCommand(facilityId,""+1);
        }

    }
}
