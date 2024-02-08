/**
 * DAO Package.
 */

package com.hexaware.dao;

import com.google.protobuf.TextFormat.ParseException;

/**
 * The IPayrollService interface provides methods for managing payroll-related operations.
 */
public interface IPayrollService {

	/**
     * Generates payroll for an employee within a specified pay period.
     *
     * @param employeeId The ID of the employee for whom payroll is to be generated.
     * @param startDate  The start date of the pay period in the format "yyyy-mm-dd".
     * @param endDate    The end date of the pay period in the format "yyyy-mm-dd".
	 * @throws java.text.ParseException If an error occurs during parsing.
	 * @throws ParseException If an error occurs during parsing.
     */
	public void generatePayroll(int employeeId, String startDate, String endDate) throws ParseException, java.text.ParseException;

    /**
     * Retrieves payroll information for a specific payroll ID.
     *
     * @param payrollId The ID of the payroll to retrieve.
     */
	public void getPayrollById(int payrollId);

    /**
     * Retrieves payroll information for a specific employee.
     *
     * @param employeeId The ID of the employee for whom payroll information is to be retrieved.
     */
	public void getPayrollsForEmployee(int employeeId);

    /**
     * Retrieves payroll information for a specified pay period.
     *
     * @param startDate The start date of the pay period in the format "yyyy-mm-dd".
     * @param endDate   The end date of the pay period in the format "yyyy-mm-dd".
     * @return A string representation of payrolls for the specified period.
     */
	public String getPayrollsForPeriod(String startDate, String endDate);

}
