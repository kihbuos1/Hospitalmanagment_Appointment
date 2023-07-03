package com.appointment.demo.VO;

public class Patient {

	private int id;
	private String name;
	private long contact;
	private String problem;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(int id, String name, long contact, String problem) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.problem = problem;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", contact=" + contact + ", problem=" + problem + "]";
	}
}
