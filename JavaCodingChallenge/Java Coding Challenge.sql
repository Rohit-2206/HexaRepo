DROP DATABASE Java_Coding_Challenge;
CREATE DATABASE Java_Coding_Challenge;
USE Java_Coding_Challenge;

CREATE TABLE Patient 
(patientId INT AUTO_INCREMENT PRIMARY KEY,
firstName VARCHAR(50),
lastName VARCHAR(50),
dateOfBirth DATE,
gender VARCHAR(20),
contactNumber VARCHAR(10) CHECK (LENGTH(contactNumber) = 10) ,
address TEXT) AUTO_INCREMENT = 100;

CREATE TABLE Doctor
(doctorId INT AUTO_INCREMENT PRIMARY KEY,
firstName VARCHAR(50),
lastName VARCHAR(50),
specialization VARCHAR(50),
contactNumber VARCHAR(10) CHECK (LENGTH(contactNumber) = 10) ) AUTO_INCREMENT = 7000;

CREATE TABLE Appointment 
(appointmentId INT AUTO_INCREMENT PRIMARY KEY,
patientId INT,
doctorId INT,
appointmentDate DATE,
description TEXT,
FOREIGN KEY (patientId) REFERENCES Patient(patientId),
FOREIGN KEY (doctorId) REFERENCES Doctor(doctorId)
) AUTO_INCREMENT = 4000;

INSERT INTO Patient (FirstName , LastName, DateofBirth , Gender , ContactNumber , Address ) VALUES
("Mahesh","M","2004-01-11","Male","9918961901","KMR Street, CIT Colony, West Mambalam, Chennai-600091"),
("Mohit","Jain","2019-07-11","Male","8929192349","28,CTO Colony, Second Cross Street, West Tambaram, Chennai-600045"),
("Meghna","Manikandan","2011-01-19","Female","8918199675","20,Nehru Nagar,Guindy,Chennai-600073"),
("Mohana","Piya","2017-05-10","Female","9101078191","KM Street,Madipakkam,Chennai-600081"),
("Ganesh","Raj","2024-01-01","Male","9100194031","MM Nagar,Chengalpet,Chennai-600095");

INSERT INTO Doctor (FirstName , LastName , Specialization , ContactNumber) VALUES 
("Aravind","K","ENT","9001920012"),
("Sathya","Narayanan","Dermatology","9919286748"),
("Kavitha","Krishnan","Pediatrics","8499283451");

INSERT INTO Appointment (patientid , doctorid , appointmentDate , description) VALUES 
(100,7000,"2024-02-03","High Fever");

SELECT * FROM Doctor;
SELECT * From patient;
SELECT * FROM Appointment;