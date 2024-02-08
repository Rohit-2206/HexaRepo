/**
 * DAO Package.
 */

package com.hexaware.dao;

/**
 * The ITaxService interface provides methods for managing tax-related operations.
 */
public interface ITaxService {

    /**
     * Retrieves tax information for a specific tax ID.
     *
     * @param taxId The ID of the tax to retrieve.
     */
	public void getTaxById(int taxId);

    /**
     * Retrieves tax information for a specific employee.
     *
     * @param employeeId The ID of the employee for whom tax information is to be retrieved.
     */
	public void getTaxesForEmployee(int employeeId);

    /**
     * Retrieves tax information for a specified tax year.
     *
     * @param taxYear The year for which tax information is to be retrieved.
     * @return The total taxes for the specified year.
     */
	public int getTaxesForYear(int taxYear);
	
    /**
     * Calculates the tax amount for a specific employee and year.
     *
     * @param employeeId The ID of the employee for whom tax is to be calculated.
     * @param year       The tax year for which tax is to be calculated.
     * @return The calculated tax amount.
     */
	public double taxCalculator(int employeeId , int year);

}
