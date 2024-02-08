create database courier_management_system;
use courier_management_system;

CREATE TABLE User ( 
UserID INT PRIMARY KEY, 
UserName VARCHAR(50) , 
Email VARCHAR(50) , 
Password VARCHAR(50) , 
ContactNumber VARCHAR(100) , 
Address TEXT);

CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY,
    EmployeeName VARCHAR(255),
    Email VARCHAR(255),
    ContactNumber VARCHAR(20),
    Role VARCHAR(255),
    Salary INT
);

CREATE TABLE Location (
    LocationID INT PRIMARY KEY,
    LocationName VARCHAR(255),
    Address TEXT
);

CREATE TABLE Payment (
    PaymentID BIGINT PRIMARY KEY,
    CourierID BIGINT,
    Amount DOUBLE,
    PaymentDate DATE
);

CREATE TABLE Couriers (
    OrderID INT PRIMARY KEY,
    SenderName VARCHAR(255),
    SenderAddress TEXT,
    RecieverName VARCHAR(100),
    RecieverAddress TEXT,
    Weight DECIMAL(5, 2),
    Status VARCHAR(50),
    TrackingNumber VARCHAR(20),
    DeliveryDate DATE,
    userid INT
);

CREATE TABLE CourierCompany (
    CompanyID INT PRIMARY KEY,
    CompanyName VARCHAR(255),
    CourierID INT,
    EmployeeID INT,
    LocationID INT
);

INSERT INTO User (UserID, userName, Email, Password, ContactNumber, Address)VALUES 
(1, 'Manikandan', 'mani24@gmail.com', 'mani_24', '9747920654', 'KS Buildings, North Usman Road, T-Nagar, Chennai-600017'),
(2, 'Raja', 'raja99@gmail.com', 'raja@99', '8796545381', 'Appaswamy Greensville, Sholinganallur, Chennai-600119'),
(3, 'Deepak', 'deepdeepak21@gmail.com', 'deepak@21', '8966894325', '77, SH 49, Egattur, Chennai-600041'),
(4, 'Mukesh', 'mmukesh2208@gmail.com', 'mukesh_2208', '9764379761', '26VJ+W7W, Ramachandra St, T. Nagar, Chennai-600017'),
(5, 'Virat', 'virat18@gmail.com', 'virat@18', '9843257913', '13, Doraiswamy Street, Perumbakkam Main Rd, Sholinganallur, Chennai-600119'),
(6, 'Ramya', 'rramya30@gmail.com', 'rramya@30', '9644779541', '28, New State Bank Colony, Tambaram West, Chennai-600045');

INSERT INTO Couriers (OrderID, SenderName, SenderAddress, RecieverName, RecieverAddress, Weight, Status, TrackingNumber, DeliveryDate, UserID , EmployeeID) VALUES 
(101, 'Manikandan', 'KS Buildings, North Usman Road, T-Nagar, Chennai-600017', 'Kamal', '475, Wipro St, Elcot Sez, Sholinganallur, Chennai-600119', 28.11, 'Processing', '101kamal', '2024-01-21', 2,1),
(102, 'Raja', 'Appaswamy Greensville, Sholinganallur, Chennai-600119', 'Raj', '45, Kbm-Vnr Road, Mambakkam, Chennai-603103', 31.90, 'Delivered', '102raj', '2024-01-16', 3,1),
(103, 'Deepak', '77, SH 49, Egattur, Chennai-600041', 'Megha', 'VIT University, Kelambakkam - Vandalur Rd, Rajan Nagar, Chennai, Tamil Nadu 600127', 11.43, 'Delivered', '103megha', '2024-01-13', 6,2),
(104, 'Mukesh', '26VJ+W7W, Ramachandra St, T. Nagar, Chennai-600017', 'Sathya', '3/146, Mettu Street, Payanoor, Mahabalipuram,Chennai-603104', 44.76, 'Cancelled', '104sathya', '2024-02-14', 1,3),
(105, 'Manikandan', 'KS Buildings, North Usman Road, T-Nagar, Chennai-600017', 'Sriram', 'R25J+96X, Kamarajar St, Kattankulathur, Chennai-603203', 18.65, 'Processing', '105sriram', '2024-01-23', 4,2),
(106, 'Deepak', '77, SH 49, Egattur, Chennai-600041', 'Shiva', 'V2PF+MWF, K.R Puram, Padappai, Chennai-602301', 56.20, 'Processing', '106shiva', '2024-01-22', 5,1),
(107, 'Manikandan', 'KS Buildings, North Usman Road, T-Nagar, Chennai-600017', 'Sreeshanth', 'XXJ4+4W4, Sri Ram Nagar, Sriperumbudur, Chennai-602105', 26.90, 'Delivered', '107sreeshanth', '2024-01-12', 5,2),
(108, 'Mukesh', '26VJ+W7W, Ramachandra St, T. Nagar, Chennai-600017', 'Gokul', '5,Amman Koil Rd ,Kamaraj Nagar, Avadi, Chennai-600071', 24.60, 'Cancelled', '108gokul', '2024-02-01', 3,3),
(109, 'Virat', '13, Doraiswamy Street, Perumbakkam Main Rd, Sholinganallur, Chennai-600119', 'Yash', '12th St, V Block, Anna Nagar, Chennai-600040', 21.98, 'Processing', '109yash', '2024-01-26', 1,5),
(110, 'Raja', 'Appaswamy Greensville, Sholinganallur, Chennai-600119', 'Prem', '26, Duraiswamy St, MARKET LANE, Vadapalani, Chennai-600026', 76.51, 'Delivered', '110prem', '2024-01-10', 3,3),
(111, 'Ramya', '28, New State Bank Colony , Tambaram West , chennai-600045', 'Divya', 'Natesan Complex , Rameshwaram Road , T-Nagar , Ch0ennai-600017', 49.51, 'Delivered', '111divya', '2024-01-16', 2,4);

INSERT INTO Employee (EmployeeID, employeeName, Email, ContactNumber, role, Salary) VALUES
(1, 'John Cadman', 'jon_18@gmail.com', '8776655443', 'Delivery Representative', 28000),
(2, 'Vinayak', 'vinayak22@gmail.com', '8268920181', 'Senior Delivery Representative', 38000),
(3, 'Manish', 'msmanish@gmail.com', '9289279191', 'Truck Driver', 21000),
(4, 'Rajesh', 'rajesh@gmail.com', '9926267101', 'Delivery Manager', 45000),
(5, 'Logesh', 'loki@gmail.com', '9352781901', 'Delivery Representative', 27000),
(6,'Yuvaraj', 'uvrj@gmail.com', '9225719901', 'Delivery Assistant', 28000);

INSERT INTO Location (LocationID, LocationName, Address) VALUES
(600040, 'Anna Nagar', '3rd St, L Block, West Anna Nagar, Chennai-600040'),
(600045, 'Tambaram', '81, Kambar Street, East Tambaram, Chennai-600045'),
(600071, 'Avadi', 'Bharathidasan St, Periyar Nagar, Avadi, Chennai-600071'),
(600032, 'Guindy', 'SIDCO Industrial Estate, Guindy, Chennai-600032'),
(602105, 'Sriperumbadur', 'Sivanthangal, Sriperumbudur, Chennai-602105');

INSERT INTO CourierCompany VALUES 
(3512,'BlueDart Express',102,3,600040 ),
(3513,'BlueDart Preimum',103, 2,602015),
(3514,'BlueDart',104, 4,600032),
(3515, 'BlueDart Preimum', 105,3,600071),
(3516, 'BlueDart Express', 106,5,600045),
(3517,'BlueDart Express' , 107,1,600040),
(3518,'BlueDart Preimum', 108,5,600045),
(3519, 'BlueDart Express', 109,6,602105);

INSERT INTO Payment (PaymentID, CourierID, Amount, PaymentDate) VALUES 
(301, 91, 150.00, '2024-01-14'),
(302, 92, 490.00, '2024-01-15'),
(303, 93, 280.00, '2024-01-11'),
(304, 92, 510.00, '2024-01-22'),
(305, 93, 830.00, '2024-01-21'),
(306, 93, 285.00, '2024-01-10'),
(307, 91, 175.00, '2024-01-19'),
(308, 92, 410.00, '2024-01-05'),
(309, 93, 540.00, '2024-01-11'),
(310, 92, 430.00, '2024-01-15');

SELECT * FROM couriers;
select * from employee;
select * from user;
select locationid from location;


