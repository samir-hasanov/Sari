package com.sari.dto.request;

import com.sari.entity.Barbar;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Data
public class ReqAppointment {
    private LocalDate appointmentDate;
    private Time appointmentStartTime;
    private Time appointmentEndTime;
    private Barbar barbarId;
}
