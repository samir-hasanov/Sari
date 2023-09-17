package com.sari.entity;

import com.sari.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    private LocalDate appointmentDate;
    private Time appointmentStartTime;
    private Time appointmentEndTime;
    @ManyToOne(fetch = FetchType.EAGER)
    private Barbar barbarId;
    @OneToOne(fetch = FetchType.EAGER)
    private UserPhone userPhoneId;
    private AppointmentStatus appointmentStatus = AppointmentStatus.Booked;


}
