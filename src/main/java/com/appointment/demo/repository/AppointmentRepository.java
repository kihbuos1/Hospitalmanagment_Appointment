package com.appointment.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.demo.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{



}
