package com.appointment.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.appointment.demo.VO.Doctor;
import com.appointment.demo.VO.Patient;
import com.appointment.demo.VO.ResponseTemplateVO;
import com.appointment.demo.entity.Appointment;
import com.appointment.demo.repository.AppointmentRepository;

@Service
public class AppointmentServices {

	@Autowired
	private AppointmentRepository aptRepo;
	@Autowired
	private RestTemplate restTemplate;
	
	//Get all Appointments
	public List<Appointment> getAllAppointment(){
		List<Appointment> appointments = this.aptRepo.findAll();
		return appointments;
	}
	
	//Get Appointment By patient id
	public Appointment getAppointmentById(int id){
		Appointment appointmentById = this.aptRepo.findById(id).get();
		return appointmentById;
	}
		
	//Book an appointment
	public Appointment bookAppointment(Appointment appointment) {
		Appointment booked = aptRepo.save(appointment);
		return booked;
	}
	
	//Delete an appointment
	public void deleteAppointment(int id) {
		aptRepo.deleteById(id);
	}
	
	/*******************/

	public ResponseTemplateVO getAppointmentByDoctor(int id) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		Appointment appointment = aptRepo.findById(id).get();
		Doctor doctor = restTemplate.getForObject("http://localhost:8080/doctors/" + appointment.getId(), 
				Doctor.class);
		Patient patient = restTemplate.getForObject("http://localhost:8081/patients/" + doctor.getId(),
				Patient.class);
		vo.setApt(appointment);
		vo.setDoctor(doctor);
		vo.setPatient(patient);
		return vo;
	}
}
