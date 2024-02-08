/*
 *Util Package. 
 */
package com.hexaware.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import com.hexaware.entity.Employee;
import com.hexaware.exception.EmployeeNotFoundException;

/**
 * A class responsible for retrieving and managing employee related data from database. 
 */
public class EmployeeServiceDb {

	Connection connection;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;

	/**
	 *Establishing connection with the database.
	 */
	public EmployeeServiceDb() {
		connection = DBConnectionUtil.getConnection();
	}
	/**
	 * Retrieves and displays details of an employee based on the provided employee ID.
	 * 
	 * @param employeeId The unique identifier of the employee.
	 * @return The details of the employee, or null if not found.
	 * @throws EmployeeNotFoundException If the employee with the given ID is not found.
	 */
	public String viewEmployeeById(int employeeId) throws EmployeeNotFoundException{
		try {
			ps = connection.prepareStatement("SELECT * FROM Employee WHERE EmployeeID = ?");
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
	        if (!rs.next()) {
	            throw new EmployeeNotFoundException();
	        }
			do {
				System.out.println("***************");
				System.out.println("EmployeeID : " + rs.getInt(1));
				System.out.println("First Name : " + rs.getString(2));
				System.out.println("Last Name : " + rs.getString(3));
				System.out.println("Date OF Birth : " + rs.getString(4));
				System.out.println("Gender : " + rs.getString(5));
				System.out.println("Email : " + rs.getString(6));
				System.out.println("Phone Number : " + rs.getString(7));
				System.out.println("Address : " + rs.getString(8));
				System.out.println("Position : " + rs.getString(9));
				System.out.println("Joining Date : " + rs.getString(10));
				System.out.println("Termination Date : " + rs.getString(11));
				System.out.println("***************");
			}while (rs.next());
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * Retrieves and displays details of all employees available in the database.
	 * @return Returns Nothing.
	 */
	public String showEmployee() {
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from employee");
			while (rs.next()) {
				System.out.println("***************");
				System.out.println("EmployeeID : " + rs.getInt(1));
				System.out.println("First Name : " + rs.getString(2));
				System.out.println("Last Name : " + rs.getString(3));
				System.out.println("Date OF Birth : " + rs.getString(4));
				System.out.println("Gender : " + rs.getString(5));
				System.out.println("Email : " + rs.getString(6));
				System.out.println("Phone Number : " + rs.getString(7));
				System.out.println("Address : " + rs.getString(8));
				System.out.println("Position : " + rs.getString(9));
				System.out.println("Joining Date : " + rs.getString(10));
				System.out.println("Termination Date : " + rs.getString(11));
				System.out.println("***************");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * Adds a new employee to the database with the provided details.
	 * 
	 * @param emp The Employee object containing details of the employee to be added.
	 * @return Returns Nothing.
	 */
	public String addEmployeeToDb(Employee emp) {
		try {
			ps = connection.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, emp.getEmployeeId());
			ps.setString(2, emp.getFirstName());
			ps.setString(3, emp.getLastName());
			ps.setString(4, emp.getDateOfBirth());
			ps.setString(5, emp.getGender());
			ps.setString(6, emp.getEmailId());
			ps.setString(7, emp.getPhoneNumber());
			ps.setString(8, emp.getAddress());
			ps.setString(9, emp.getPosition());
			ps.setString(10, emp.getJoiningDate());
			ps.setString(11, emp.getTerminationDate());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " employee added successfully !!!");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * Removes an employee from the database based on the provided employee ID.
	 * 
	 * @param employeeId The unique identifier of the employee to be removed.
	 * @return True if the employee is successfully removed, false otherwise.
	 * @throws SQLIntegrityConstraintViolationException Whenever a problem arises.
	 */
	public String removeEmployeeFromDb(int employeeId)throws SQLIntegrityConstraintViolationException{
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM Employee WHERE EmployeeID = ?");
			{
				ps.setInt(1, employeeId);
				int noofrows = ps.executeUpdate();

				if (noofrows > 0) {
					return noofrows + " Employee removed";
				} else {
					throw new EmployeeNotFoundException();
				}
			}
		} 
		catch(SQLIntegrityConstraintViolationException e) 
		{
			System.out.println(e.getMessage());
		}
		catch(EmployeeNotFoundException e) 
		{
			System.out.println(e.getMessage());
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return "Error occurred during employee removal";
	}
	
	/**
	 * Updates the information of an existing employee in the database.
	 * 
	 * @param emp The Employee object containing the updated information.
	 * @param employeeId ID of the employee whose details needs to be updated.
	 * @return A empty string as the updating process is done and message is printed to the console.
	 */
    public String updateEmployee(Employee emp, int employeeId) {
        try {
            employeeId = emp.getEmployeeId();
            StringBuilder sb = new StringBuilder("UPDATE employee SET");

            int index = 1;

            if(emp.getFirstName() != null) {
                sb.append(" firstName = ?,");
            }
            if(emp.getLastName() != null) {
                sb.append(" lastName = ?,");
            }
            if(emp.getDateOfBirth() != null) {
                sb.append(" dateOfBirth = ?,");
            }
            if(emp.getGender() != null) {
            	sb.append(" gender = ?,");
            }
            if(emp.getEmailId() != null) {
                sb.append(" email = ?,");
            }
            if(emp.getPhoneNumber() != null) {
                sb.append(" phonenumber = ?,");
            }
            if(emp.getAddress() != null) {
                sb.append(" address = ?,");
            }
            if(emp.getPosition() != null) {
            	sb.append(" position = ?,");
            }
            if(emp.getTerminationDate()!=null) {
            	sb.append(" terminationdate =?,");
            }

            if(sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(" WHERE employeeid = ?");

            ps = connection.prepareStatement(sb.toString());

            if(emp.getFirstName() != null) {
                ps.setString(index++, emp.getFirstName());
            }
            if(emp.getLastName() != null) {
                ps.setString(index++, emp.getLastName());
            }
            if(emp.getDateOfBirth() != null) {
                ps.setString(index++, emp.getDateOfBirth());
            }
            if(emp.getGender() != null) {
            	ps.setString(index++, emp.getGender());
            }
            if(emp.getEmailId() != null) {
            	ps.setString(index++, emp.getEmailId());
            }
            if(emp.getPhoneNumber() != null) {
            	ps.setString(index++, emp.getPhoneNumber());
            }
            if(emp.getAddress() != null) {
            	ps.setString(index++, emp.getAddress());
            }
            if(emp.getPosition() != null) {
            	ps.setString(index++, emp.getPosition());
            }
            if(emp.getTerminationDate() != null) {
            	ps.setString(index++, emp.getTerminationDate());
            }

            ps.setInt(index, employeeId);

            int noOfRows = ps.executeUpdate();

            if(noOfRows > 0) {
            	System.out.println("***********");
                System.out.println(noOfRows + " employee data updated successfully!");
                System.out.println("***********");
            } else {
                throw new EmployeeNotFoundException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return "";
}
	/**
	 *Checks the whether the employeeID being used to update employee details is correct or not. 
	 * @param employeeId Unique identifier of each employee.
	 * @return Returns true if the Employee ID is valid else false.
	 */
	public boolean isValidEmployee(int employeeId) {
		try {
			ps = connection.prepareStatement("SELECT EmployeeID FROM Employee WHERE EmployeeID = ?");
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();	
			return rs.next();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		return false;
	}
}
