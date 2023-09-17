package com.sari.controller;

import com.sari.dto.request.ReqSalon;
import com.sari.dto.response.RespSalon;
import com.sari.dto.response.RespStatusList;
import com.sari.dto.response.Response;
import com.sari.service.SalonService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class SalonController {

    @Autowired
    private SalonService service;

    @PostMapping("/save")
    public RespStatusList saveSalon(@RequestBody ReqSalon reqSalon){

        return service.saveSalon(reqSalon);
    }


    @GetMapping("/list")
    public Response<List<RespSalon>> getSalonList(){

        return service.getSalonList();
    }

    @GetMapping("/id")
    public Response<RespSalon> getSalonById(@RequestParam("id") Long id){
          return service.getSalonById(id);
    }


    @PutMapping("/up")
    public RespStatusList updateSalon(@RequestBody ReqSalon reqSalon){

        return service.updateSalon(reqSalon);
    }

    @PutMapping("/del")
    public RespStatusList delSalon(@RequestParam("id") Long id){
        return service.delSalon(id);
    }

}
