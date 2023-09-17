package com.sari.controller;

import com.sari.dto.request.ReqBarbar;
import com.sari.dto.response.RespBarbar;
import com.sari.dto.response.RespStatusList;
import com.sari.dto.response.Response;
import com.sari.service.BarbarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v3")
public class BarbarController {

    @Autowired
    private BarbarService service;


    @GetMapping("/list")
    public Response<List<RespBarbar>> barbarList(){
       return service.barbarList();
    }

    @PostMapping("/save")
    public RespStatusList saveBarbar(@RequestBody ReqBarbar reqBarbar){

        return service.saveBarbar(reqBarbar);
    }


    @PutMapping("/del")
    public RespStatusList delBarabar(@RequestParam("id") Long id ){
        return service.delBarbar(id);
    }

    @PutMapping("/id")
    public Response<RespBarbar> getBarbarById(@RequestParam("id") Long id){

        return service.getBarbarById(id);
    }



}
