package com.hexaware.main;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;
import com.hexaware.controller.ReportGenerator;
import com.google.protobuf.TextFormat.ParseException;
import com.hexaware.controller.EmployeeService;
import com.hexaware.controller.FinancialRecordService;
import com.hexaware.dao.IFinancialRecordService;
import com.hexaware.dao.ITaxService;
import com.hexaware.controller.PayrollService;
import com.hexaware.controller.TaxService;
import com.hexaware.dao.IPayrollService;
import com.hexaware.dao.IEmployeeService;
import com.hexaware.entity.Employee;
import com.hexaware.entity.FinancialRecord;
import com.hexaware.entity.Payroll;
import com.hexaware.entity.Tax;

/**
 * Main Class.
 * This class serves as the entry point for the PayXPert application.
 * It provides a text-based menu for users to interact with different services.
 */
public class Main {

	static Scanner read = new Scanner(System.in);
	
    /**
     * Main method to start the PayXPert application.
     *
     * @param args Command-line arguments.
     * @throws SQLIntegrityConstraintViolationException Exception for SQL integrity
     *                                                  constraint violation.
     */
	
	public static void main(String[] args) throws SQLIntegrityConstraintViolationException{
		System.out.println("Welcome to PayXPert");

		do {
			System.out.println("What do you want to do?");
			System.out.println("1. Employee Service\n2. Payroll Service\n"
					+ "3. Tax Service\n4. Financial Record Service\n" + "5. Generate Report\n6. Log Out");

			int choice = read.nextInt();

			switch (choice) {
			case 1:
				employeeService();
				break;
			case 2:
				payrollService();
				break;
			case 3:
				taxService();
				break;
			case 4:
				financialRecordService();
				break;
			case 5:
				generateReport();
				break;
			case 6:
				System.out.println("Thank You");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}

		} while (true);
	}

	private static void employeeService() throws SQLIntegrityConstraintViolationException{

		IEmployeeService es = new EmployeeService();
		Employee emp = new Employee();
		do {
			System.out.println("Choose from the below Employee Service");
			System.out.println("1.View all Employees\n2.View Employee by ID\n"
					+ "3.Add new Employee\n4.Remove an Employee\n5.Update Employee Details\n"
					+ "6.Main Menu\n7.LogOut");
			int empServiceNumber = read.nextInt();
			switch (empServiceNumber) {
			case 1:
				es.getAllEmployees();
				break;
			case 2:
				es.getEmployeeById(emp.getEmployeeId());
				break;
			case 3:
				es.addEmployee();
				break;
			case 4:
				es.removeEmployee(emp.getEmployeeId());
				break;
			case 5:
				es.updateEmployee();
				break;
			case 6:
				System.out.println("Going back to the main menu");
				return;
			case 7:
				System.out.println("Thank You");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		} while (true);
	}

	private static void payrollService() {

		IPayrollService ps = new PayrollService();
		Payroll pr = new Payroll();
		do {
			System.out.println("Choose from the below payroll service");
			System.out
					.println("1.Generate payroll for Employee\n" + "2.View Payroll by ID\n3.View payroll for Employee\n"
							+ "4.View payroll for a period\n5.Main menu\n6.LogOut");
			int payrollServiceNumber = read.nextInt();

			switch (payrollServiceNumber) {
			case 1:
				try {
					ps.generatePayroll(pr.getEmployeeId(), pr.getPayPeriodStartDate(), pr.getPayPeriodEndDate());
				} catch (ParseException e) {
					e.printStackTrace();
				} catch (java.text.ParseException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				ps.getPayrollById(pr.getPayrollId());
				break;
			case 3:
				ps.getPayrollsForEmployee(pr.getEmployeeId());
				break;
			case 4:
				ps.getPayrollsForPeriod(pr.getPayPeriodStartDate(), pr.getPayPeriodEndDate());
				break;
			case 5:
				System.out.println("Going back to the main menu");
				return;
			case 6:
				System.out.println("Thank You");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		} while (true);
	}

	private static void taxService() {

		ITaxService ts = new TaxService();
		Tax tx = new Tax();
		do {
			System.out.println("Choose from the below tax services");
			System.out.println(
					"1.Calculate tax for Employee\n" + "2.View tax records by tax ID\n3.View tax records for Employee\n"
							+ "4.View tax for a year\n5.Main Menu\n6.LogOut");
			int taxServiceNumber = read.nextInt();

			switch (taxServiceNumber) {
			case 1:
				ts.taxCalculator(tx.getEmployeeId(), tx.getTaxYear());
				break;
			case 2:
				ts.getTaxById(tx.getTaxId());
				break;
			case 3:
				ts.getTaxesForEmployee(tx.getEmployeeId());
				break;
			case 4:
				ts.getTaxesForYear(tx.getTaxYear());
				break;
			case 5:
				System.out.println("Going back to the main menu");
				return;
			case 6:
				System.out.println("Thank You");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		} while (true);
	}

	private static void financialRecordService() {

		IFinancialRecordService frs = new FinancialRecordService();
		FinancialRecord fr = new FinancialRecord();
		do {
			System.out.println("Choose from the below Financial Record Service");
			System.out.println("1.Add a financial record\n2.Get financial record by ID\n"
					+ "3.Get financial record for employee\n4.Get financial record by date\n"
					+ "5.Main Menu\n6.LogOut");

			int financeServiceNumber = read.nextInt();
			switch (financeServiceNumber) {
			case 1:
				frs.addFinancialRecord(fr.getEmployeeId(), fr.getDescription(), fr.getAmount(), fr.getRecordType());
				break;
			case 2:
				frs.getFinancialRecordById(fr.getRecordId());
				break;
			case 3:
				frs.getFinancialRecordsForEmployee(fr.getEmployeeId());
				break;
			case 4:
				frs.getFinancialRecordsForDate(fr.getRecordDate());
				break;
			case 5:
				System.out.println("Going back to the main menu");
				return;
			case 6:
				System.out.println("Thank You");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		} while (true);
	}

	private static void generateReport() {

		ReportGenerator rg = new ReportGenerator();
		do {
			System.out.println("What report do you want to generate");
			System.out.println(
					"1.Total Salary Paid to each Employee by Year\n" + "2.Total Salary Paid to each Employee by Month\n"
							+ "3.Salary Paid by Employee\n4.Main Menu\n5.LogOut");

			int reportNumber = read.nextInt();

			switch (reportNumber) {
			case 1:
				rg.salaryPaidByYear();
				break;
			case 2:
				rg.salaryPaidByMonth();
				break;
			case 3:
				rg.salaryPaidByEmployee();
				break;
			case 4:
				System.out.println("Going back to the main menu");
				return;
			case 5:
				System.out.println("Thank You");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		} while (true);
	}

}
