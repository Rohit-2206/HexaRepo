/*
 *Exception Package. 
 */

package com.hexaware.exception;

/**
 * Exception thrown when there is an issue with payroll generation.
 */
public class PayrollGenerationException extends Exception {

    /**
     * Default constructor for the PayrollGenerationException.
     * Displays a message whenever the exception arises.
     */
    public PayrollGenerationException() {
        super("Cannot Generate Payroll. Check the details entered.");
    }

    /**
     * Returns a string representation of the PayrollGenerationException.
     *
     * @return A string representation of the PayrollGenerationException.
     */
    @Override
    public String toString() {
        return "PayrollGenerationException []";
    }
}
