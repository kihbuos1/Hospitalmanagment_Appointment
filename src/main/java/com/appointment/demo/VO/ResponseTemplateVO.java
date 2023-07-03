package com.appointment.demo.VO;

import com.appointment.demo.entity.Appointment;

public class ResponseTemplateVO {

	private Appointment apt;
	private Patient patient;
	private Doctor doctor;
	public ResponseTemplateVO() {
		super();
	}
	public ResponseTemplateVO(Appointment apt, Patient patient, Doctor doctor) {
		super();
		this.apt = apt;
		this.patient = patient;
		this.doctor = doctor;
	}
	public Appointment getApt() {
		return apt;
	}
	public void setApt(Appointment apt) {
		this.apt = apt;
	}
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
		
}
