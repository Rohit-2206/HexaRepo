/**
 * Entity Package.
 */
package com.hexaware.entity;

/**
 * Salary class represents the financial details related to an employee's salary.
 * It includes information such as payroll ID, employee ID, pay month, pay year, gross salary, and net salary.
 */
public class Salary {
    /**
     * payrollId - The ID generated each time when a payroll is being inserted in the Payroll table.
     * employeeId - The unique identifier of each employee.
     * payMonth - The Month the payroll is generated.
     * payYear - The year of the payroll that is generated.
     * grossSalary - Salary before deductions are made i.e BasicSalary + OvertimePay.
     * netSalary - Salary after deductions i.e BasicSalary + OvertimePay - Deductions.
     */

    private int payrollId;
    private int employeeId;
    private String payMonth;
    private int payYear;
    private double grossSalary;
    private double netSalary;

    /**
     * Default constructor for the Salary class.
     */
    public Salary() {
    }

    /**
     * Parameterized constructor for the Salary class.
     *
     * @param payrollId   The ID generated each time when a payroll is being inserted in the Payroll table.
     * @param employeeId  The unique identifier of each employee.
     * @param payMonth    The Month the payroll is generated.
     * @param payYear     The year of the payroll that is generated.
     * @param grossSalary Salary before deductions are made i.e BasicSalary + OvertimePay.
     * @param netSalary   Salary after deductions i.e BasicSalary + OvertimePay - Deductions.
     */
    public Salary(int payrollId, int employeeId, String payMonth, int payYear, double grossSalary, double netSalary) {
        this.payrollId = payrollId;
        this.employeeId = employeeId;
        this.payMonth = payMonth;
        this.payYear = payYear;
        this.grossSalary = grossSalary;
        this.netSalary = netSalary;
    }

    /**
     * Retrieves the ID generated each time when a payroll is being inserted in the Payroll table.
     *
     * @return The ID generated each time when a payroll is being inserted in the Payroll table.
     */
    public int getPayrollId() {
        return payrollId;
    }

    /**
     * Sets the ID generated each time when a payroll is being inserted in the Payroll table.
     *
     * @param payrollId The new ID to set.
     */
    public void setPayrollId(int payrollId) {
        this.payrollId = payrollId;
    }

    /**
     * Retrieves the unique identifier of each employee.
     *
     * @return The unique identifier of each employee.
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the unique identifier of each employee.
     *
     * @param employeeId The new unique identifier to set.
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Retrieves the Month the payroll is generated.
     *
     * @return The Month the payroll is generated.
     */
    public String getPayMonth() {
        return payMonth;
    }

    /**
     * Sets the Month the payroll is generated.
     *
     * @param payMonth The new Month to set.
     */
    public void setPayMonth(String payMonth) {
        this.payMonth = payMonth;
    }

    /**
     * Retrieves the year of the payroll that is generated.
     *
     * @return The year of the payroll that is generated.
     */
    public int getPayYear() {
        return payYear;
    }

    /**
     * Sets the year of the payroll that is generated.
     *
     * @param payYear The new year to set.
     */
    public void setPayYear(int payYear) {
        this.payYear = payYear;
    }

    /**
     * Retrieves the Salary before deductions are made i.e BasicSalary + OvertimePay.
     *
     * @return Salary before deductions are made i.e BasicSalary + OvertimePay.
     */
    public double getGrossSalary() {
        return grossSalary;
    }

    /**
     * Sets the Salary before deductions are made i.e BasicSalary + OvertimePay.
     *
     * @param grossSalary The new gross salary to set.
     */
    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    /**
     * Retrieves the Salary after deductions i.e BasicSalary + OvertimePay - Deductions.
     *
     * @return Salary after deductions i.e BasicSalary + OvertimePay - Deductions.
     */
    public double getNetSalary() {
        return netSalary;
    }

    /**
     * Sets the Salary after deductions i.e BasicSalary + OvertimePay - Deductions.
     *
     * @param netSalary The new net salary to set.
     */
    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    /**
     * Returns a string representation of the Salary object.
     *
     * @return A string representation of the Salary object.
     */
    @Override
    public String toString() {
        return "Salary [payrollId=" + payrollId + ", employeeId=" + employeeId + ", payMonth=" + payMonth + ", payYear="
                + payYear + ", grossSalary=" + grossSalary + ", netSalary=" + netSalary + "]";
    }
}

