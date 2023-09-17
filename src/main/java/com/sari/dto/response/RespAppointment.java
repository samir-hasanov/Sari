package com.sari.dto.response;

import com.sari.entity.Barbar;
import com.sari.entity.UserPhone;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
public class RespAppointment {
    private Timestamp createdAt;
    private LocalDate appointmentDate;
    private Time appointmentStartTime;
    private Time appointmentEndTime;
    private Barbar barbarId;
    private UserPhone userPhoneId;
}
