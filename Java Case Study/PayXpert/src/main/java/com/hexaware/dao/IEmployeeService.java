/**
 * DAO Package.
 */

package com.hexaware.dao;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * The IEmployeeService interface provides methods for managing employee-related operations.
 */
public interface IEmployeeService {

    /**
     * Retrieves information for a specific employee by ID.
     *
     * @param employeeId The ID of the employee to retrieve.
     * @return A string representation of the employee information.
     */	
	public String getEmployeeById(int employeeId);
	
    /**
     * Retrieves information for all employees.
     */
	public void getAllEmployees();

    /**
     * Adds a new employee.
     */
	public void addEmployee();

	/**
     * Updates information for an existing employee.
     *
     * @return A string representation of the updated employee information.
     */
	public String updateEmployee();

    /**
     * Removes an employee by ID.
     *
     * @param employeeId The ID of the employee to be removed.
     * @throws SQLIntegrityConstraintViolationException If a foreign key constraint is violated during removal.
     */
	public void removeEmployee(int employeeId) throws SQLIntegrityConstraintViolationException;

}
