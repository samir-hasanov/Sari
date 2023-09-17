package com.sari.service;

import com.sari.dto.request.ReqAppointment;
import com.sari.dto.response.RespAppointment;
import com.sari.dto.response.RespStatusList;
import com.sari.dto.response.Response;

import java.util.List;

public interface AppointmentService {
    RespStatusList appointmentBooking(ReqAppointment reqAppointment);

    Response<List<RespAppointment>> getListBooking();
}
