/**
 * Entity Package.
 */

package com.hexaware.entity;

/**
 * Tax class represents the details of an employee's tax record.
 * It includes information such as tax ID, employee ID, tax year, taxable income, and tax amount.
 */
public class Tax {
    /**
     * taxId - A unique identifier for each tax record.
     * employeeId - ID of the employee whose tax is recorded.
     * taxYear - Financial Year of the tax record.
     * taxableIncome - Amount of income which comes under the taxable category.
     * taxAmount - Amount that needs to be paid as tax.
     */

    private int taxId;
    private int employeeId;
    private int taxYear;
    private double taxableIncome;
    private double taxAmount;

    /**
     * Default constructor for the Tax class.
     */
    public Tax() {
    }

    /**
     * Parameterized constructor for the Tax class.
     *
     * @param taxId         A unique identifier for each tax record.
     * @param employeeId    ID of the employee whose tax is recorded.
     * @param taxYear       Financial Year of the tax record.
     * @param taxableIncome Amount of income which comes under the taxable category.
     * @param taxAmount     Amount that needs to be paid as tax.
     */
    public Tax(int taxId, int employeeId, int taxYear, double taxableIncome, double taxAmount) {
        this.taxId = taxId;
        this.employeeId = employeeId;
        this.taxYear = taxYear;
        this.taxableIncome = taxableIncome;
        this.taxAmount = taxAmount;
    }

    /**
     * Retrieves the unique identifier for each tax record.
     *
     * @return The unique identifier for each tax record.
     */
    public int getTaxId() {
        return taxId;
    }

    /**
     * Sets the unique identifier for each tax record.
     *
     * @param taxId The new unique identifier to set.
     */
    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }

    /**
     * Retrieves the ID of the employee whose tax is recorded.
     *
     * @return The ID of the employee whose tax is recorded.
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the ID of the employee whose tax is recorded.
     *
     * @param employeeId The new employee ID to set.
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Retrieves the Financial Year of the tax record.
     *
     * @return The Financial Year of the tax record.
     */
    public int getTaxYear() {
        return taxYear;
    }

    /**
     * Sets the Financial Year of the tax record.
     *
     * @param taxYear The new tax year to set.
     */
    public void setTaxYear(int taxYear) {
        this.taxYear = taxYear;
    }

    /**
     * Retrieves the amount of income which comes under the taxable category.
     *
     * @return The amount of income which comes under the taxable category.
     */
    public double getTaxableIncome() {
        return taxableIncome;
    }

    /**
     * Sets the amount of income which comes under the taxable category.
     *
     * @param taxableIncome The new taxable income to set.
     */
    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    /**
     * Retrieves the amount that needs to be paid as tax.
     *
     * @return The amount that needs to be paid as tax.
     */
    public double getTaxAmount() {
        return taxAmount;
    }

    /**
     * Sets the amount that needs to be paid as tax.
     *
     * @param taxAmount The new tax amount to set.
     */
    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    /**
     * Returns a string representation of the Tax object.
     *
     * @return A string representation of the Tax object.
     */
    @Override
    public String toString() {
        return "Tax [taxId=" + taxId + ", employeeId=" + employeeId + ", taxYear=" + taxYear + ", taxableIncome="
                + taxableIncome + ", taxAmount=" + taxAmount + "]";
    }
}

