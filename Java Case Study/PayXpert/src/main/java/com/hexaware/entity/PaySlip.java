/**
 * Entity Package. 
 */
package com.hexaware.entity;

/**
 * PaySlip class represents the details of a payments, including unique identifiers, employee information, and payment details.
 * It includes value such as ID, employee ID, year, and paid amount.
 */
public class PaySlip {
	
    /**
     * Id - The unique identifier of each payslip.
     * employeeId - The unique identifier of employeeId.
     * year - The year of the amount being paid.
     * paidAmount - How much amount is being paid till date for each employee.
     */

    private int Id;
    private int employeeId;
    private int year;
    private double paidAmount;

    /**
     * Default constructor for the PaySlip class.
     */
    public PaySlip() {
    }

    /**
     * Parameterized constructor for the PaySlip class.
     *
     * @param id          The unique identifier of each payslip.
     * @param employeeId  The unique identifier of the employee.
     * @param year        The year of the amount being paid.
     * @param paidAmount  How much amount is being paid till date for each employee.
     */
    public PaySlip(int id, int employeeId, int year, double paidAmount) {
        this.Id = id;
        this.employeeId = employeeId;
        this.year = year;
        this.paidAmount = paidAmount;
    }

    /**
     * Retrieves the unique identifier of the payslip.
     *
     * @return The unique identifier of the payslip.
     */
    public int getId() {
        return Id;
    }

    /**
     * Sets the unique identifier of the payslip.
     *
     * @param id The new unique identifier to set.
     */
    public void setId(int id) {
        Id = id;
    }

    /**
     * Retrieves the unique identifier of the employee.
     *
     * @return The unique identifier of the employee.
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the unique identifier of the employee.
     *
     * @param employeeId The new unique identifier to set.
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Retrieves the year of the amount being paid.
     *
     * @return The year of the amount being paid.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of the amount being paid.
     *
     * @param year The new year to set.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Retrieves the amount being paid till date for each employee.
     *
     * @return The amount being paid till date for each employee.
     */
    public double getPaidAmount() {
        return paidAmount;
    }

    /**
     * Sets the amount being paid till date for each employee.
     *
     * @param paidAmount The new amount to set.
     */
    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    /**
     * Returns a string representation of the PaySlip object.
     *
     * @return A string representation of the PaySlip object.
     */
    @Override
    public String toString() {
        return "PaySlip [Id=" + Id + ", employeeId=" + employeeId + ", year=" + year + ", paidAmount=" + paidAmount
                + "]";
    }
}