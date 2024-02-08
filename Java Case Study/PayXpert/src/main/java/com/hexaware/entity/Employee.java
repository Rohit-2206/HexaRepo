/**
 * Entity package.
 */

package com.hexaware.entity;

/**
 * Represents an employee with various attributes.
 */
public class Employee {
    /**
     * Unique identifier for the employee.
     */
    private int employeeId;

    /**
     * First name of the employee.
     */
    private String firstName;

    /**
     * Last name of the employee.
     */
    private String lastName;

    /**
     * Date of birth of the employee in the format yyyy-mm-dd.
     */
    private String dateOfBirth;

    /**
     * Gender of the employee.
     */
    private String gender;

    /**
     * Email ID of the employee.
     */
    private String emailId;

    /**
     * Phone number of the employee.
     */
    private String phoneNumber;

    /**
     * Address of the employee.
     */
    private String address;

    /**
     * Job title or position of the employee.
     */
    private String position;

    /**
     * Date when the employee joined the organization.
     */
    private String joiningDate;

    /**
     * Date when the employee's association with the organization ends.
     */
    private String terminationDate;

    /**
     * Default constructor.
     */
    public Employee() {
    }

    /**
     * Parameterized constructor to initialize employee attributes.
     *
     * @param employeeId      Unique identifier for the employee.
     * @param firstName       First name of the employee.
     * @param lastName        Last name of the employee.
     * @param dateOfBirth     Date of birth of the employee.
     * @param gender          Gender of the employee.
     * @param emailId         Email ID of the employee.
     * @param phoneNumber     Phone number of the employee.
     * @param address         Address of the employee.
     * @param position        Position of the employee.
     * @param joiningDate     Date when the employee joined the organization.
     * @param terminationDate Date when the employee's association with the organization ends.
     */
    public Employee(int employeeId, String firstName, String lastName, String dateOfBirth, String gender,
                    String emailId, String phoneNumber, String address, String position, String joiningDate,
                    String terminationDate) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.position = position;
        this.joiningDate = joiningDate;
        this.terminationDate = terminationDate;
    }
    /**
     * Retrieves the unique identifier for the employee.
     *
     * @return The unique identifier for the employee.
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the unique identifier for the employee.
     *
     * @param employeeId The new unique identifier to set.
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Retrieves the first name of the employee.
     *
     * @return The first name of the employee.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the employee.
     *
     * @param firstName The new first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name of the employee.
     *
     * @return The last name of the employee.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the employee.
     *
     * @param lastName The new last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the date of birth of the employee.
     *
     * @return The date of birth of the employee.
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the employee.
     *
     * @param dateOfBirth The new date of birth to set.
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Retrieves the gender of the employee.
     *
     * @return The gender of the employee.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the employee.
     *
     * @param gender The new gender to set.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Retrieves the email ID of the employee.
     *
     * @return The email ID of the employee.
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets the email ID of the employee.
     *
     * @param emailId The new email ID to set.
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Retrieves the phone number of the employee.
     *
     * @return The phone number of the employee.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the employee.
     *
     * @param phoneNumber The new phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Retrieves the address of the employee.
     *
     * @return The address of the employee.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the employee.
     *
     * @param address The new address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Retrieves the job title or position of the employee.
     *
     * @return The job title or position of the employee.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the job title or position of the employee.
     *
     * @param position The new job title or position to set.
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Retrieves the date when the employee joined the organization.
     *
     * @return The date when the employee joined the organization.
     */
    public String getJoiningDate() {
        return joiningDate;
    }

    /**
     * Sets the date when the employee joined the organization.
     *
     * @param joiningDate The new joining date to set.
     */
    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    /**
     * Retrieves the date when the employee's association with the organization ends.
     *
     * @return The date when the employee's association with the organization ends.
     */
    public String getTerminationDate() {
        return terminationDate;
    }

    /**
     * Sets the date when the employee's association with the organization ends.
     *
     * @param terminationDate The new termination date to set.
     */
    public void setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
    }

	
	   /**
     * Returns a string representation of the Employee object.
     *
     * @return A string representation of the Employee object.
     */
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", emailId=" + emailId + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", position=" + position + ", joiningDate=" + joiningDate
				+ ", terminationDate=" + terminationDate + "]";
	}
}
