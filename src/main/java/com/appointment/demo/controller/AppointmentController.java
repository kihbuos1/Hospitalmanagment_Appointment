package com.appointment.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.demo.VO.ResponseTemplateVO;
import com.appointment.demo.entity.Appointment;
import com.appointment.demo.services.AppointmentServices;


@RestController
public class AppointmentController {

	@Autowired
	private AppointmentServices aptService;

	@GetMapping("/appointments")
	public ResponseEntity<Object> getAllAppointment() {
		List<Appointment> allAppointment = aptService.getAllAppointment();
		if (allAppointment.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(allAppointment);
	}

	@GetMapping("/appointments/{id}")
	public ResponseEntity<Object> getAppointmentById(@PathVariable("id") int id) {
		Appointment appointmentById = aptService.getAppointmentById(id);
		if (appointmentById == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(appointmentById);
	}

	@PostMapping("/appointments")
	public ResponseEntity<Object> bookAppointment(@RequestBody Appointment appointment) {
		Appointment bookAppointment = null;
		try {
			bookAppointment = this.aptService.bookAppointment(appointment);
			System.out.println(bookAppointment);
			return ResponseEntity.ok(Optional.of(appointment));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/appointments/{id}")
	public ResponseEntity<Object> deleteAppointment(@PathVariable("id")int id){
		try{
			this.aptService.deleteAppointment(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}	
	}
	
	/**********************/
	
	@GetMapping("/appointments/doctors/{id}")
	public ResponseEntity<Object> getAppointmentByDoctorId(@PathVariable("id")int id) {
		ResponseTemplateVO appointmentByDoctor = this.aptService.getAppointmentByDoctor(id);
		if(appointmentByDoctor == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(appointmentByDoctor);
	}
}
