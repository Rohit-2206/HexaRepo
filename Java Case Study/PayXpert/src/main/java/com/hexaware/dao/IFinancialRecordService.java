/**
 * DAO Package.
 */

package com.hexaware.dao;

/**
 * The IFinancialRecordService interface provides methods for managing financial record-related operations.
 */
public interface IFinancialRecordService {

    /**
     * Adds a new financial record for an employee.
     *
     * @param employeeId   The ID of the employee for whom the financial record is added.
     * @param description  The description of the financial record.
     * @param amount       The amount associated with the financial record.
     * @param recordType   The type of the financial record.
     */
	public void addFinancialRecord(int employeeId, String description, double amount, String recordType);

	/**
     * Retrieves information for a specific financial record by ID.
     *
     * @param recordId The ID of the financial record to retrieve.
     */
	public void getFinancialRecordById(int recordId);

	/**
     * Retrieves financial records for a specific employee.
     *
     * @param employeeId The ID of the employee for whom financial records are to be retrieved.
     */
	public void getFinancialRecordsForEmployee(int employeeId);

    /**
     * Retrieves financial records for a specific date.
     *
     * @param recordDate The date for which financial records are to be retrieved.
     */
	public void getFinancialRecordsForDate(String recordDate);

}