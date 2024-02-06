package com.hexaware.dao;

import com.hexaware.entity.Appointment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.util.DBConnection;

public class IHospitalServiceImpl implements IHospitalService {

	Connection connection;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;

	public IHospitalServiceImpl() {
		connection = DBConnection.getConnection();
	}

	@Override
	public Appointment getAppointmentById(int appointmentId) {
		Appointment app = new Appointment();
		try {
			ps = connection.prepareStatement("SELECT * FROM Appointment WHERE appointmentId = ?");
			ps.setInt(1, appointmentId);

			rs = ps.executeQuery();

			if (rs.next()) {
				app.setAppointmentId(rs.getInt(1));
				app.setPatientId(rs.getInt(2));
				app.setDoctorId(rs.getInt(3));
				app.setAppointmentDate(rs.getString(4));
				app.setDescription(rs.getString(5));
				return app;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return app;
	}

	@Override
	public List<Appointment> getAppointmentsForPatient(int patientId) {
		List<Appointment> appointments = new ArrayList<>();
		Appointment app = new Appointment();
		try {
			ps = connection.prepareStatement("SELECT * FROM Appointment WHERE patientId = ?");
			ps.setInt(1, patientId);
			rs = ps.executeQuery();
			while (rs.next()) {
				app.setAppointmentId(rs.getInt(1));
				app.setPatientId(rs.getInt(2));
				app.setDoctorId(rs.getInt(3));
				app.setAppointmentDate(rs.getString(4));
				app.setDescription(rs.getString(5));
				appointments.add(app);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return appointments;
	}

	@Override
	public List<Appointment> getAppointmentsForDoctor(int doctorId) {
		List<Appointment> appointments = new ArrayList<>();
		Appointment app = new Appointment();
		try {
			ps = connection.prepareStatement("SELECT * FROM Appointment WHERE doctorId = ?");
			ps.setInt(1, doctorId);
			rs = ps.executeQuery();
			while (rs.next()) {
				app.setAppointmentId(rs.getInt(1));
				app.setPatientId(rs.getInt(2));
				app.setDoctorId(rs.getInt(3));
				app.setAppointmentDate(rs.getString(4));
				app.setDescription(rs.getString(5));
				appointments.add(app);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return appointments;
	}

	@Override
	public boolean scheduleAppointment(Appointment app) {
		try {
			connection = DBConnection.getConnection();

			ps = connection.prepareStatement("INSERT INTO Appointment (patientId, doctorId, appointmentDate, description) VALUES (?, ?, ?, ?)");
			ps.setInt(1, app.getPatientId());
			ps.setInt(2, app.getDoctorId());
			ps.setString(3, app.getAppointmentDate());
			ps.setString(4, app.getDescription());

			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println(rowsAffected +" row inserted succesfully");
			}
			else
			{
				System.out.println("Cannot insert data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateAppointment(Appointment app) {
		try {
			connection = DBConnection.getConnection();

			ps = connection.prepareStatement("UPDATE Appointment SET doctorId = ?, appointmentDate = ?, description = ? WHERE appointmentId = ?");
			ps.setInt(1, app.getPatientId());
			ps.setInt(2, app.getDoctorId());
			ps.setString(3, app.getAppointmentDate());
			ps.setString(4, app.getDescription());

			int rowsAffected = ps.executeUpdate(); 
			if(rowsAffected > 0) {
				System.out.println(rowsAffected +" row updated succesfully");
			}
			else
			{
				System.out.println("Cannot insert data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
    public boolean cancelAppointment(int appointmentId) {
        try {
            connection = DBConnection.getConnection();

            ps = connection.prepareStatement("DELETE FROM Appointment WHERE appointmentId = ?");
            ps.setInt(1, appointmentId);

            int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println(rowsAffected +" row deleted succesfully");
			}
			else
			{
				System.out.println("Cannot delete data");
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}
}
