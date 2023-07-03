package com.appointment.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.appointment.demo.entity.Appointment;
import com.appointment.demo.repository.AppointmentRepository;
import com.appointment.demo.services.AppointmentServices;


@SpringBootTest(classes = { AppointmentServicesTest.class })
@TestMethodOrder(OrderAnnotation.class)
public class AppointmentServicesTest {

	@Mock
	private AppointmentRepository aptRepo;
	@InjectMocks
	private AppointmentServices aptService;

	public List<Appointment> list;

	// Get All Doctors Test
	@Test
	@Order(1)
	public void test_getAllDoctors() {
		List<Appointment> list = new ArrayList<>();
		list.add(new Appointment(1, "Ken", "Dr.Deshmukh", "26-08-22"));
		list.add(new Appointment(2, "Ben", "Dr.Pandey", "07-09-22"));
		list.add(new Appointment(3, "Hart", "Dr.Ghosh", "10-10-22"));

		when(aptRepo.findAll()).thenReturn(list); // Mocking the dummy data
		assertEquals(list.size(), aptService.getAllAppointment().size());
	}

	// Get Appointment by id Test
	@Test
	@Order(2)
	public void test_getDoctorById() {
		Optional<Appointment> myDoctor = Optional.of(new Appointment(6, "Sam", "Dr Rama", "11-10-22"));
		when(aptRepo.findById(6)).thenReturn(myDoctor);
		assertEquals(myDoctor, Optional.of(aptService.getAppointmentById(6)));
	}
	
	@Test @Order(3)
	public void test_addDoctor() {
		Appointment apt = new Appointment(4, "Vicky", "DR. R.Sen", "11-09-22");
		when(aptRepo.save(apt)).thenReturn(apt);
		assertEquals(apt,aptService.bookAppointment(apt));
	}

	@Test @Order(4)
	public void test_deleteDoctor() {
		aptService.deleteAppointment(1);
		assertNull(aptService.getAppointmentById(1));
	}
	
}
