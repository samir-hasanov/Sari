package com.sari.repostory;

import com.sari.entity.Appointment;
import com.sari.enums.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    List<Appointment> findByAppointmentStatus(AppointmentStatus booked);
}
