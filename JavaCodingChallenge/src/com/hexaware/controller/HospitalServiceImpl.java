package com.hexaware.controller;

import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.IHospitalServiceImpl;
import com.hexaware.entity.Appointment;
import com.hexaware.exception.PatientNumberNotFoundException;

public class HospitalServiceImpl {
	
	static IHospitalServiceImpl ihs = new IHospitalServiceImpl();
	static Scanner read = new Scanner(System.in);
	
	public void getAppointmentById(int appointmentId) {
		
		System.out.println("Enter ID of the Appointment to view");
		appointmentId = read.nextInt();
	
		Appointment app = ihs.getAppointmentById(appointmentId);
		if (app.getAppointmentId() == appointmentId) {
			System.out.println("************");
			System.out.println("Appointment ID: " + app.getAppointmentId());
			System.out.println("Patient ID: " + app.getPatientId());
			System.out.println("Doctor ID: " + app.getDoctorId());
			System.out.println("Appointment Date: " + app.getAppointmentDate());
			System.out.println("Description: " + app.getDescription());
			System.out.println("************");
		}
		else 
		{
			System.out.println("Appointment with ID " + appointmentId + " not found.");
		}
	}
	
	public List<Appointment> getAppointmentsForPatient(int patientId) throws PatientNumberNotFoundException {
		System.out.println("Enter the Patient ID to view appointment details");
		patientId = read.nextInt();
		
		List<Appointment> appointments = ihs.getAppointmentsForPatient(patientId);

        if (appointments.isEmpty()) {
            throw new PatientNumberNotFoundException();
        } else {
            System.out.println("Appointments for Patient ID: " + patientId);
            for (Appointment app : appointments) {
                System.out.println("************");
                System.out.println("Appointment ID: " + app.getAppointmentId());
                System.out.println("Doctor ID: " + app.getDoctorId());
                System.out.println("Appointment Date: " + app.getAppointmentDate());
                System.out.println("Description: " + app.getDescription());
                System.out.println("************");
            }
        }
		return appointments;
    }
	
	public List<Appointment> getAppointmentsForDoctor(int doctorId) {
		System.out.println("Enter the doctor ID to view appointments");
		doctorId = read.nextInt();
		
		List<Appointment> appointments = ihs.getAppointmentsForPatient(doctorId);

        if (appointments.isEmpty()) {
            System.out.println("No appointments found for the given Doctor ID.");
        } else {
            System.out.println("Appointments for Doctor ID: " + doctorId);
            for (Appointment app : appointments) {
                System.out.println("************");
                System.out.println("Appointment ID: " + app.getAppointmentId());
                System.out.println("Doctor ID: " + app.getDoctorId());
                System.out.println("Appointment Date: " + app.getAppointmentDate());
                System.out.println("Description: " + app.getDescription());
                System.out.println("************");
            }
        }
		return appointments;
    }
	
	public boolean scheduleAppointment(Appointment app) {
		
		System.out.println("Enter PatientID");
		int patientId = read.nextInt();
	    app.setPatientId(patientId);
	    
		System.out.println("Enter DoctorID");
		int doctorId = read.nextInt();
	    app.setDoctorId(doctorId);
	    
		System.out.println("Enter Appointment Date");
	    String appointmentDate = read.next();
	    app.setAppointmentDate(appointmentDate);
	    
		System.out.println("Enter illness description");
		String description = read.next();
	    app.setDescription(description);

	    return ihs.scheduleAppointment(app);
	}
	
	public void updateAppoinment(Appointment app) {
		
		System.out.println("Enter your appointment ID");
		int appointmentId = read.nextInt();
		app.setAppointmentId(appointmentId);
	    
		System.out.println("Enter DoctorID");
		int doctorId = read.nextInt();
	    app.setDoctorId(doctorId);
	    
		System.out.println("Enter Appointment Date");
	    String appointmentDate = read.next();
	    app.setAppointmentDate(appointmentDate);
	    
		System.out.println("Enter illness description");
		String description = read.next();
	    app.setDescription(description);

	    ihs.updateAppointment(app);
	}
	
	public void cancelAppointment (int appointmentId) {
		System.out.println("Enter Appointment ID to cancel");
		appointmentId = read.nextInt();
		
		ihs.cancelAppointment(appointmentId);
	}
}

