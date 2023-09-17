package com.sari.service;

import com.sari.dto.request.ReqAppointment;
import com.sari.dto.response.RespAppointment;
import com.sari.dto.response.RespStatus;
import com.sari.dto.response.RespStatusList;
import com.sari.dto.response.Response;
import com.sari.entity.Appointment;
import com.sari.entity.Barbar;
import com.sari.enums.AppointmentStatus;
import com.sari.exception.ExceptionConstants;
import com.sari.exception.MyException;
import com.sari.repostory.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public RespStatusList appointmentBooking(ReqAppointment reqAppointment) {

        RespStatusList response=new RespStatusList();

        try {
            if (reqAppointment==null){
        throw new MyException(ExceptionConstants.REQUEST_NULL,"Request null");
            }
            Appointment appointment=new Appointment();
            appointment.setAppointmentDate(reqAppointment.getAppointmentDate());
            appointment.setAppointmentStartTime(reqAppointment.getAppointmentStartTime());
            appointment.setAppointmentEndTime(reqAppointment.getAppointmentEndTime());
            appointment.setBarbarId(reqAppointment.getBarbarId());
            appointmentRepository.save(appointment);
            response.setStatus(RespStatus.getMessage());
        }catch (MyException e){
            e.printStackTrace();
            response.setStatus(new RespStatus(e.getCode(), e.getMessage()));

        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstants.INTERNAL_SERVER_ERROR,"Internal server error"));
        }



        return response;
    }

    @Override
    public Response<List<RespAppointment>> getListBooking() {
        Response<List<RespAppointment>> response=new Response<>();
        List<RespAppointment> list=new ArrayList<>();

        try {
           List<Appointment> appointments= appointmentRepository.findByAppointmentStatus(AppointmentStatus.Booked);
        if(appointments==null){
           throw new MyException(ExceptionConstants.DATA_NOT_FOUND,"Data not found");
        }
        for (Appointment appointment:appointments){
            RespAppointment respAppointment=new RespAppointment();
            respAppointment.setCreatedAt(appointment.getCreatedAt());
            respAppointment.setAppointmentDate(appointment.getAppointmentDate());
            respAppointment.setAppointmentStartTime(appointment.getAppointmentStartTime());
            respAppointment.setAppointmentEndTime(appointment.getAppointmentEndTime());
            respAppointment.setBarbarId(appointment.getBarbarId());
            respAppointment.setUserPhoneId(appointment.getUserPhoneId());
            list.add(respAppointment);
        }
        response.setT(list);
        response.setRespStatus(RespStatus.getMessage());
        } catch (MyException e) {
            e.printStackTrace();
            response.setRespStatus(new RespStatus(e.getCode(),e.getMessage()));
        }catch (Exception e){
            e.printStackTrace();
            response.setRespStatus(new RespStatus(ExceptionConstants.INTERNAL_SERVER_ERROR,"Internal server error"));
        }

        return response;
    }
}
