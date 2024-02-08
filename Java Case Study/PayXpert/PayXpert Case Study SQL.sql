DROP DATABASE PayXpert;
CREATE DATABASE PayXpert;
USE PayXpert;

CREATE TABLE Employee (
EmployeeID INT PRIMARY KEY,
FirstName VARCHAR(50),
LastName VARCHAR(50),
DateOfBirth VARCHAR(50),
Gender VARCHAR(10),
Email VARCHAR(100),
PhoneNumber VARCHAR(20),
Address TEXT,
Position VARCHAR(50),
JoiningDate VARCHAR(50),
TerminationDate VARCHAR(50) NULL
);

CREATE TABLE Payroll (
PayrollID INT AUTO_INCREMENT PRIMARY KEY,
EmployeeID INT,
PayPeriodStartDate VARCHAR(50),
PayPeriodEndDate VARCHAR(50),
BasicSalary DECIMAL(10, 2),
OvertimePay DECIMAL(10, 2),
Deductions DECIMAL(10, 2),
FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID),
UNIQUE (EmployeeID, PayPeriodStartDate, PayPeriodEndDate)
)AUTO_INCREMENT=100;

CREATE TABLE Salary (
PayrollID INT PRIMARY KEY ,
EmployeeID INT,
PayMonth VARCHAR(50),
PayYear INT,
GrossSalary DECIMAL(10,2),
NetSalary DECIMAL(10,2),
FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID),
FOREIGN KEY (PayrollID) REFERENCES Payroll (PayrollID)
);

CREATE TABLE Payslip (
ID INT AUTO_INCREMENT PRIMARY KEY,
EmployeeID INT,
TaxYear INT,
PaidAMount DECIMAL(10, 2),
FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
)AUTO_INCREMENT = 1;

CREATE TABLE FinancialRecord (
RecordID INT AUTO_INCREMENT PRIMARY KEY,
EmployeeID INT,
RecordDate DATE,
Description VARCHAR(255),
Amount DECIMAL(10, 2),
RecordType VARCHAR(50),
FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
)AUTO_INCREMENT=8000;

CREATE TABLE Tax
(TaxID int ,
EmployeeID int ,
TaxYear int ,
TaxableIncome decimal(10,2) ,
TaxAmount decimal(10,2)
);

INSERT INTO Employee VALUES 
(1,'Raja','Ganesh','1995-01-11','Male','ganeshraja1995@gmail.com','9379281034','KS Buildings,North Usman Road,T-Nagar,Chennai-600017',
'Junior Data Analyst','2020-05-09',NULL);
INSERT INTO Employee VALUES (2,'Sathya','Priya','1989-06-23','Female','sathya230689@gmail.com','8748945892','77, SH 49,Egattur,Chennai-600041',
'Training Co-Ordinator','2021-07-12',NULL);
INSERT INTO Employee VALUES (3,'RJ','Balaji','1992-11-02','Male','balajirj@gmail.com','8291038923','Natesan Complex,Rameshwaram Road,T-Nagar,Chennai-600017',
'Project Manager','2017-05-15',NULL);
INSERT INTO Employee VALUES (4,'Sridevi','Ravichandran','1997-12-01','Female','srideviravi@gmail.com','9839294562','Bharathidasan St,Periyar Nagar,Avadi,Chennai-600071',
'DevOps Engineer','2022-03-29',NULL);
INSERT INTO Employee VALUES (5,'Praveen','Kumar','1991-08-23','Male','praveen1991@gmail.com','9388177451','3rd St,L Block,West Anna Nagar,Chennai-600040',
'Quality Analyst','2020-09-15',NULL);

INSERT INTO Payroll(EmployeeID,PayPeriodStartDate,PayPeriodEndDate,BasicSalary,OvertimePay,Deductions) VALUES 
(1,'2023-01-01','2023-01-31',31000.00,1800.00,3100.00),
(1,'2023-02-01','2023-02-28',31000.00,700.00,3100.00),
(1,'2023-03-01','2023-03-31',31000.00,0.00,3100.00),
(1,'2023-04-01','2023-04-30',31000.00,500.00,3100.00),
(1,'2023-05-01','2023-05-31',31000.00,900.00,3100.00),
(1,'2023-06-01','2023-06-30',31000.00,1500.00,3100.00),
(1,'2023-07-01','2023-07-31',31000.00,2000.00,3100.00),
(1,'2023-08-01','2023-08-31',31000.00,700.00,3100.00),
(1,'2023-09-01','2023-09-30',31000.00,800.00,3100.00),
(1,'2023-10-01','2023-10-31',31000.00,0.00,3100.00),
(1,'2023-11-01','2023-11-30',31000.00,1200.00,3100.00),
(1,'2023-12-01','2023-12-31',31000.00,0.00,3100.00);

INSERT INTO Payroll(EmployeeID,PayPeriodStartDate,PayPeriodEndDate,BasicSalary,OvertimePay,Deductions)  VALUES 
(2,'2024-01-01','2024-01-31',30000.00,0.00,2900.00),
(2,'2024-02-01','2024-02-28',30000.00,1900.00,2900.00),
(2,'2024-03-01','2024-03-31',30000.00,700.00,2900.00),
(2,'2024-04-01','2024-04-30',30000.00,2100.00,2900.00),
(2,'2024-05-01','2024-05-31',30000.00,1100.00,2900.00),
(2,'2024-06-01','2024-06-30',30000.00,0.00,2900.00),
(2,'2024-07-01','2024-07-31',30000.00,300.00,2900.00),
(2,'2024-08-01','2024-08-31',30000.00,700.00,2900.00),
(2,'2024-09-01','2024-09-30',30000.00,900.00,2900.00),
(2,'2024-10-01','2024-10-31',30000.00,0.00,2900.00),
(2,'2024-11-01','2024-11-30',30000.00,1200.00,2900.00),
(2,'2024-12-01','2024-12-31',30000.00,1600.00,2900.00);

INSERT INTO Payroll (EmployeeID,PayPeriodStartDate,PayPeriodEndDate,BasicSalary,OvertimePay,Deductions)  VALUES 
(3,'2023-01-01','2023-01-31',58000.00,900.00,3500.00),
(3,'2023-02-01','2023-02-28',58000.00,200.00,3500.00),
(3,'2023-03-01','2023-03-31',58000.00,0.00,3500.00),
(3,'2023-04-01','2023-04-30',58000.00,1400.00,3500.00),
(3,'2023-05-01','2023-05-31',58000.00,500.00,3500.00),
(3,'2023-06-01','2023-06-30',58000.00,0.00,3500.00),
(3,'2023-07-01','2023-07-31',58000.00,0.00,3500.00),
(3,'2023-08-01','2023-08-31',58000.00,0.00,3500.00),
(3,'2023-09-01','2023-09-30',58000.00,2100.00,3500.00),
(3,'2023-10-01','2023-10-31',58000.00,1200.00,3500.00),
(3,'2023-11-01','2023-11-30',58000.00,200.00,3500.00),
(3,'2023-12-01','2023-12-31',58000.00,600.00,3500.00);

INSERT INTO Payroll (EmployeeID,PayPeriodStartDate,PayPeriodEndDate,BasicSalary,OvertimePay,Deductions)  VALUES 
(4,'2023-01-01','2023-01-31',34000.00,1000.00,2900.00),
(4,'2023-02-01','2023-02-28',34000.00,300.00,2900.00),
(4,'2023-03-01','2023-03-31',34000.00,0.00,2900.00),
(4,'2023-04-01','2023-04-30',34000.00,500.00,2900.00),
(4,'2023-05-01','2023-05-31',34000.00,700.00,2900.00),
(4,'2023-06-01','2023-06-30',34000.00,800.00,2900.00),
(4,'2023-07-01','2023-07-31',34000.00,400.00,2900.00),
(4,'2023-08-01','2023-08-31',34000.00,600.00,2900.00),
(4,'2023-09-01','2023-09-30',34000.00,100.00,2900.00),
(4,'2023-10-01','2023-10-31',34000.00,1200.00,2900.00),
(4,'2023-11-01','2023-11-30',34000.00,0.00,2900.00),
(4,'2023-12-01','2023-12-31',34000.00,0.00,2900.00);

INSERT INTO Payroll (EmployeeID,PayPeriodStartDate,PayPeriodEndDate,BasicSalary,OvertimePay,Deductions)  VALUES 
(5,'2023-01-01','2023-01-31',35000.00,300.00,2800.00),
(5,'2023-02-01','2023-02-28',35000.00,700.00,2800.00),
(5,'2023-03-01','2023-03-31',35000.00,200.00,2800.00),
(5,'2023-04-01','2023-04-30',35000.00,1100.00,2800.00),
(5,'2023-05-01','2023-05-31',35000.00,900.00,2800.00),
(5,'2023-06-01','2023-06-30',35000.00,300.00,2800.00),
(5,'2023-07-01','2023-07-31',35000.00,600.00,2800.00),
(5,'2023-08-01','2023-08-31',35000.00,800.00,2800.00),
(5,'2023-09-01','2023-09-30',35000.00,1100.00,2800.00),
(5,'2023-10-01','2023-10-31',35000.00,700.00,2800.00),
(5,'2023-11-01','2023-11-30',35000.00,400.00,2800.00),
(5,'2023-12-01','2023-12-31',35000.00,600.00,2800.00);

INSERT INTO FinancialRecord (EmployeeID, RecordDate, Description, Amount,  RecordType)VALUES 
(1,'2023-01-12','Travel Expense','1800.00','Debit'),
(1,'2023-04-29','Medical Expense','13000.00','Debit'),
(1,'2023-07-01','OvertimePay','2000.00','Credit'),
(2,'2023-01-31','Insurance Claim','7000.00','Credit'),
(2,'2023-08-21','Travel Expense','1000.00','Debit'),
(2,'2023-11-01','Overtime Pay','2100.00','Credit'),
(3,'2023-03-11','Loan Expense','20000.00','Debit'),
(4,'2023-09-27','Kids Education Expense','25000.00','Debit'),
(5,'2023-09-01','Overtime Pay','1100.00','Credit');

--------------------------------------------------- Triggers ----------------------------------------------------------
-- Trigger work flow Payroll --> FinacialRecord , Salary. Payroll Table triggers Salary table and FinancialRecord Table
-- Salary --> PaySlip --> Tax Salary table triggers Payslip table. Payslip table triggers Tax table.

-- The NetSalary trigger calculates the gross salary and net salary every time afetr a value is being inserted into the payroll table.
DROP TRIGGER NetSalary;
DELIMITER //
CREATE TRIGGER NetSalary
AFTER INSERT ON Payroll
FOR EACH ROW 
BEGIN 
INSERT INTO Salary VALUES (new.payrollID, new.EmployeeID, MONTHNAME(new.PayPeriodStartDate),YEAR(new.PayPeriodStartDate),
new.BasicSalary + new.OvertimePay, new.BasicSalary + new.OvertimePay - new.Deductions);
END //
DELIMITER ;

-- This Trigger calculates year end payslip for each employee and total amount paid to them
DROP TRIGGER PayslipCalculator;
DELIMITER //
CREATE TRIGGER PaySlipCalculator
AFTER INSERT ON Salary
FOR EACH ROW
BEGIN
DECLARE EmpID INT;
DECLARE TotalSalary DECIMAL(10,2);
SET EmpID = new.EmployeeID;
SET TotalSalary = (SELECT SUM(GrossSalary) FROM Salary WHERE EmployeeID = EmpID AND payyear = new.payyear GROUP BY EmployeeID, payyear);
INSERT INTO Payslip VALUES (ID , EmpID, new.PayYear, TotalSalary);	
END //
DELIMITER ;

-- Based on the payslip the 12th month i.e the financial year end amount is taken and tax amount is calculated from it
DROP TRIGGER Tax;
DELIMITER //
CREATE TRIGGER Tax
AFTER INSERT ON Payslip
FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM Payslip WHERE EmployeeID = new.EmployeeID) % 12 = 0  THEN             -- %12 is to find whether a financial year 

IF new.PaidAmount > 250000 AND new.PaidAmount < 500000 THEN 
INSERT INTO Tax VALUES (new.ID, new.EmployeeID, new.TaxYear, new.PaidAmount - 250000, (new.PaidAmount -250000) * 0.05);

ELSEIF new.PaidAmount > 500000 AND new.PaidAmount < 750000 THEN 
INSERT INTO Tax VALUES (new.ID, new.EmployeeID, new.TaxYear, new.PaidAmount - 250000, (new.PaidAmount -250000) * 0.10);

ELSEIF new.PaidAmount > 750000 AND new.PaidAmount < 1000000 THEN 
INSERT INTO Tax VALUES (new.ID, new.EmployeeID, new.TaxYear, new.PaidAmount - 250000, (new.PaidAmount -250000) * 0.20);

ELSEIF new.PaidAmount > 1000000 THEN 
INSERT INTO Tax VALUES (new.ID, new.EmployeeID, new.TaxYear, new.PaidAmount - 250000, (new.PaidAmount -250000) * 0.30);

END IF;
END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS FinancialRecord;
DELIMITER //
CREATE TRIGGER FinancialRecord 
AFTER INSERT ON Payroll
FOR EACH ROW
BEGIN 
INSERT INTO FinancialRecord VALUES(recordid, new.EmployeeID ,new.PayPeriodStartDate,"Monthly Salary", new.BasicSalary + new.OvertimePay ,"Debit");
END //
DELIMITER ;

SELECT * FROM Employee;
SELECT * FROM Payroll;
SELECT * FROM Salary;
SELECT * FROM Payslip;
SELECT * FROM Tax;
SELECT * FROM FinancialRecord;

SELECT salary.EmployeeID , CONCAT(firstName," ", lastName) as Name, PayMonth , PayYear, GrossSalary 
FROM Salary
JOIN Employee
ON salary.employeeid = employee.employeeid
WHERE salary.EmployeeID = 1;

select employeeid,max(paidamount) 
from payslip
group by employeeid , taxyear