package com.hexaware.main;

import java.util.Scanner;

import com.hexaware.controller.HospitalServiceImpl;
import com.hexaware.entity.Appointment;
import com.hexaware.entity.Doctor;
import com.hexaware.entity.Patient;

public class MainModule {

	public static void main(String[] args) {
		
		Scanner read = new Scanner (System.in);
		
		HospitalServiceImpl hsi = new HospitalServiceImpl();
		Appointment app = new Appointment();
		Patient pt = new Patient();
		Doctor dr = new Doctor();
		
		System.out.println("Enter what you want to do");
		System.out.println("1.Get Appointment ID\n"
				+ "2.Get Appointments for Patient\n"
				+ "3.Get Appointmemts for Doctor\n"
				+ "4.Schedule Appointment\n"
				+ "5.Cancel Appointment\n"
				+ "6.Return Back to Main Menu"
				+ "7.Log Out\n");
		int choice = read.nextInt();
		
		switch(choice) {
		case 1:
			hsi.getAppointmentById(app.getAppointmentId());
			break;
		case 2:
			hsi.getAppointmentsForPatient(pt.getPatientId());
			break;
		case 3:
			hsi.getAppointmentsForDoctor(dr.getDoctorId());
			break;
		case 4:
			hsi.scheduleAppointment(app);
			break;
		case 5:
			hsi.cancelAppointment(app.getAppointmentId());
			break;
		case 6:
			return;
		case 7:
			System.out.println("Thank You");
			System.exit(0);
		default:
			System.out.println("Invalid Choice");
		}	
	}
}
