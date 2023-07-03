package com.appointment.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "patient_name")
	private String patientName;
	@Column(name = "doctor_name")
	private String doctorName;
	@Column(name = "date")
	private String date;
	public Appointment() {
		super();
	}
	public Appointment(int id, String patientName, String doctorName, String date) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", patientName=" + patientName + ", doctorName=" + doctorName + ", date="
				+ date + "]";
	}
}
