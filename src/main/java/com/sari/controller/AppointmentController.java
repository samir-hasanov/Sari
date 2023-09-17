package com.sari.controller;

import com.sari.dto.request.ReqAppointment;
import com.sari.dto.response.RespAppointment;
import com.sari.dto.response.RespStatusList;
import com.sari.dto.response.Response;
import com.sari.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

   @PostMapping("/save")
    public RespStatusList appointmentBooking(@RequestBody ReqAppointment reqAppointment){


        return service.appointmentBooking(reqAppointment);
    }

    @GetMapping("/list")
    public Response<List<RespAppointment>> getListBooking(){

       return service.getListBooking();
    }

}
