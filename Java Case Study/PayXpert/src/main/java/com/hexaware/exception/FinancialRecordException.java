/*
 *Exception Package. 
 */
package com.hexaware.exception;

/**
 * Exception thrown when a financial record is not found.
 */
public class FinancialRecordException extends Exception {

    /**
     * Default constructor for the FinancialRecordException.
     * Displays a message indicating that the financial record is not found.
     */
    public FinancialRecordException() {
        super("Financial Record Not Found");
    }

    /**
     * Returns a string representation of the FinancialRecordException.
     *
     * @return A string representation of the FinancialRecordException.
     */
    @Override
    public String toString() {
        return "FinancialRecordException []";
    }
}
