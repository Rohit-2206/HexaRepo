package com.hexaware.dao;

import java.util.List;

import com.hexaware.entity.Appointment;

public interface IHospitalService {
	
	public Appointment getAppointmentById(int appoinmentId);
	
	public List<Appointment> getAppointmentsForPatient(int patientId);

	public List<Appointment> getAppointmentsForDoctor(int doctorId);
	
	public boolean scheduleAppointment(Appointment app);
	
	public void updateAppointment(Appointment app);

	public boolean cancelAppointment(int appointmentId);


}
