/**
 * Entity package.
 */

package com.hexaware.entity;

/**
 * Represents financial records associated with employees.
 */
public class FinancialRecord {
	/**
	 * recordId - Unique Identifier of each record being saved.
	 * employeeId - Unique Identifier assigned to each employee.
	 * recordDate - Date of the record being recorded.
	 * description - Short description about the record.
	 * amount - How much amount is spent or collected for that particular record.
	 * recordType - Whether its a credit or debit.
	 */
	
	private int recordId;
	private int employeeId;
	private String recordDate;
	private String description;
	private double amount;
	private String recordType;

    /**
     * Default constructor for the FinancialRecord class.
     */
	public FinancialRecord() {
	}

    /**
     * Parameterized constructor for the FinancialRecord class.
     *
     * @param recordId     Unique Identifier of each record being saved.
     * @param employeeId   Unique Identifier assigned to each employee.
     * @param recordDate   Date of the record being recorded.
     * @param description  Short description about the record.
     * @param amount       How much amount is spent or collected for that particular record.
     * @param recordType   Whether it's a credit or debit.
     */
	public FinancialRecord(int recordId, int employeeId, String recordDate, String description, double amount,
			String recordType) {
		super();
		this.recordId = recordId;
		this.employeeId = employeeId;
		this.recordDate = recordDate;
		this.description = description;
		this.amount = amount;
		this.recordType = recordType;
	}
	
	 /**
     * Retrieves the unique identifier of the financial record.
     *
     * @return The unique identifier of the financial record.
     */
    public int getRecordId() {
        return recordId;
    }

    /**
     * Sets the unique identifier of the financial record.
     *
     * @param recordId The new unique identifier to set.
     */
    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    /**
     * Retrieves the unique identifier assigned to the employee.
     *
     * @return The unique identifier assigned to the employee.
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the unique identifier assigned to the employee.
     *
     * @param employeeId The new unique identifier to set.
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Retrieves the date of the financial record.
     *
     * @return The date of the financial record.
     */
    public String getRecordDate() {
        return recordDate;
    }

    /**
     * Sets the date of the financial record.
     *
     * @param recordDate The new date to set.
     */
    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * Retrieves a short description of the financial record.
     *
     * @return A short description of the financial record.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets a short description of the financial record.
     *
     * @param description The new description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the amount spent or collected for the financial record.
     *
     * @return The amount spent or collected for the financial record.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount spent or collected for the financial record.
     *
     * @param amount The new amount to set.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Retrieves whether the financial record is a credit or debit.
     *
     * @return Whether the financial record is a credit or debit.
     */
    public String getRecordType() {
        return recordType;
    }

    /**
     * Sets whether the financial record is a credit or debit.
     *
     * @param recordType The new record type to set.
     */
    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    /**
     * Returns a string representation of the FinancialRecord object.
     *
     * @return A string representation of the FinancialRecord object.
     */
    @Override
    public String toString() {
        return "FinancialRecord [recordId=" + recordId + ", employeeId=" + employeeId + ", recordDate=" + recordDate
                + ", description=" + description + ", amount=" + amount + ", recordType=" + recordType + "]";
    }
}

