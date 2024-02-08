/*
 * Exception Package.
 */
package com.hexaware.exception;

/**
 * Exception thrown when there is not enough data available to calculate tax for an employee.
 */
public class TaxCalculationException extends Exception {

    /**
     * Default constructor for the TaxCalculationException.
     * Creates an instance with a specific error message.
     */
    public TaxCalculationException() {
        super("Not enough data available to calculate tax for the employee.");
    }

    /**
     * Returns a string representation of the TaxCalculationException.
     *
     * @return A string representation of the TaxCalculationException.
     */
    @Override
    public String toString() {
        return "TaxCalculationException []";
    }
}

