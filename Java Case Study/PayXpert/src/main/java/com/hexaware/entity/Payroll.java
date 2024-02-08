/**
 * Entity Package.
 */

package com.hexaware.entity;

/**
 * The Payroll class represents the details of a payroll for an employee.
 * It includes information such as payroll ID, employee ID, pay period dates,
 * basic salary, overtime pay, deductions, gross salary, and net salary.
 */
public class Payroll {
	
	// payrollId - Unique identifier assigned each time a payroll is generated.
	private int payrollId;
	// employeeId - ID of the Employee related to that Payroll.
	private int employeeId;
	// payPeriodStartDate - The starting date of the payroll being generated.
	private String payPeriodStartDate;
	// payPeriodEnddate - The Ending date of the payroll being generated.
	private String payPeriodEndDate;
	// basicSalary - The Basic Salary of the Employee. 
	private double basicSalary;
	// overTimePay - Amount for Over Time Pay.
	private double overTimePay;
	// deductions - Deductions made from salary.
	private double deductions;
	// grossSalary - basicSalary + overTimePay
	private double grossSalary;
	// netSalary - basicSalary + overTimePay - Deductions
	private double netSalary;

    /**
     * Default constructor for the Payroll class.
     */
	public Payroll() {
	}

    /**
     * Parameterized constructor for the Payroll class.
     *
     * @param payrollId           Unique identifier assigned each time a payroll is generated.
     * @param employeeId          ID of the Employee related to that Payroll.
     * @param payPeriodStartDate  The starting date of the payroll being generated.
     * @param payPeriodEndDate    The ending date of the payroll being generated.
     * @param basicSalary         The basic salary of the Employee.
     * @param overTimePay         Amount for Overtime Pay.
     * @param deductions          Deductions made from the salary.
     * @param grossSalary         The total salary before deductions.
     * @param netSalary           The total salary after deductions.
     */
	public Payroll(int payrollId, int employeeId, String payPeriodStartDate, String payPeriodEndDate,
			double basicSalary, double overTimePay, double deductions, double grossSalary, double netSalary) {
		super();
		this.payrollId = payrollId;
		this.employeeId = employeeId;
		this.payPeriodStartDate = payPeriodStartDate;
		this.payPeriodEndDate = payPeriodEndDate;
		this.basicSalary = basicSalary;
		this.overTimePay = overTimePay;
		this.deductions = deductions;
		this.grossSalary = grossSalary;
		this.netSalary = netSalary;
	}

	/**
	 * Retrieves the unique identifier assigned to each payroll.
	 *
	 * @return The payroll ID.
	 */
	public int getPayrollId() {
		return payrollId;
	}

	/**
	 * Sets the unique identifier assigned to each payroll.
	 *
	 * @param payrollId The new payroll ID to set.
	 */
	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}

	/**
	 * Retrieves the employee ID associated with the payroll.
	 *
	 * @return The employee ID.
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee ID associated with the payroll.
	 *
	 * @param employeeId The new employee ID to set.
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Retrieves the starting date of the payroll period.
	 *
	 * @return The starting date of the payroll period.
	 */
	public String getPayPeriodStartDate() {
		return payPeriodStartDate;
	}

	/**
	 * Sets the starting date of the payroll period.
	 *
	 * @param payPeriodStartDate The new starting date to set.
	 */
	public void setPayPeriodStartDate(String payPeriodStartDate) {
		this.payPeriodStartDate = payPeriodStartDate;
	}

	/**
	 * Retrieves the ending date of the payroll period.
	 *
	 * @return The ending date of the payroll period.
	 */
	public String getPayPeriodEndDate() {
		return payPeriodEndDate;
	}

	/**
	 * Sets the ending date of the payroll period.
	 *
	 * @param payPeriodEndDate The new ending date to set.
	 */
	public void setPayPeriodEndDate(String payPeriodEndDate) {
		this.payPeriodEndDate = payPeriodEndDate;
	}

    /**
     * Retrieves the basic salary of the employee.
     *
     * @return The basic salary of the employee.
     */
	public double getBasicSalary() {
		return basicSalary;
	}

    /**
     * Sets the basic salary of the employee.
     *
     * @param basicSalary The new basic salary to set.
     */
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	/**
	 * Retrieves the overtime pay amount.
	 *
	 * @return The amount for overtime pay.
	 */
	public double getOverTimePay() {
	    return overTimePay;
	}

	/**
	 * Sets the amount for overtime pay.
	 *
	 * @param overTimePay The new amount for overtime pay to set.
	 */
	public void setOverTimePay(double overTimePay) {
	    this.overTimePay = overTimePay;
	}
    /**
     * Retrieves the deductions made from the salary.
     *
     * @return The deductions made from the salary.
     */
	public double getDeductions() {
		return deductions;
	}

    /**
     * Sets the deductions made from the salary.
     *
     * @param deductions The new deductions to set.
     */
	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	/**
	 * Retrieves the gross salary (basic salary + overtime pay) of the employee.
	 *
	 * @return The gross salary of the employee.
	 */
	public double getGrossSalary() {
	    return grossSalary;
	}

	/**
	 * Sets the gross salary (basic salary + overtime pay) of the employee.
	 *
	 * @param grossSalary The new gross salary to set.
	 */
	public void setGrossSalary(double grossSalary) {
	    this.grossSalary = grossSalary;
	}

	/**
	 * Retrieves the net salary (gross salary - deductions) of the employee.
	 *
	 * @return The net salary of the employee.
	 */
	public double getNetSalary() {
	    return netSalary;
	}

	/**
	 * Sets the net salary (gross salary - deductions) of the employee.
	 *
	 * @param netSalary The new net salary to set.
	 */
	public void setNetSalary(double netSalary) {
	    this.netSalary = netSalary;
	}

    /**
     * Returns a string representation of the Payroll object.
     *
     * @return A string representation of the Payroll object.
     */
	@Override
	public String toString() {
		return "Payroll [payrollId=" + payrollId + ", employeeId=" + employeeId + ", payPeriodStartDate="
				+ payPeriodStartDate + ", payPeriodEndDate=" + payPeriodEndDate + ", basicSalary=" + basicSalary
				+ ", overTimePay=" + overTimePay + ", deductions=" + deductions + ", grossSalary=" + grossSalary
				+ ", netSalary=" + netSalary + "]";
	}

}
