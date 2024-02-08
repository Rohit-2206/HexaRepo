-- Task-1

CREATE DATABASE cms;
USE cms;

CREATE TABLE USER (
    UserID int primary key,
    Name varchar(255),
    Email varchar(255) unique,
    Password varchar(255),
    ContactNumber varchar(20),
    Address text
);

CREATE TABLE ORDERS (
    OrderID int primary key,
    SenderUserID int,
    ReciverName varchar(100),
    RecieverAddress text,
    Weight decimal(5, 2),
    Status varchar(50),
    TrackingNumber varchar(20) unique,
    DeliveryDate date,
    employeeID int,
	FOREIGN KEY (employeeID) REFERENCES Employee(employeeID),
    FOREIGN KEY (SenderUserID) REFERENCES User(UserID)
);

CREATE TABLE COURIERCOMPANY (
    CourierID int primary key,
    Name varchar(50)
);

CREATE TABLE SERVICE(
    ServiceID int primary key,
    CourierID int,
    ServiceName varchar(100),
    Cost decimal(8, 2),
    FOREIGN KEY (CourierID) REFERENCES CourierCompany(CourierID)
);

CREATE TABLE EMPLOYEE(
    EmployeeID int primary key,
    CourierID int,
    Name varchar(255),
    Email varchar(255) unique,
    ContactNumber varchar(20),
    Role varchar(50),
    Salary int,
    FOREIGN KEY (CourierID) REFERENCES CourierCompany(CourierID)
);

CREATE TABLE LOCATION (
    LocationID int primary key,
    LocationName varchar(100),
    Address text
);

CREATE TABLE PAYMENT (
    PaymentID int primary key,
    CourierID int,
    LocationID int,
    Amount decimal(10, 2),
    PaymentDate date,
    orderID int,
    servivceID int,
    FOREIGN KEY (CourierID) REFERENCES CourierCompany(CourierID),
    FOREIGN KEY (LocationID) REFERENCES Location(LocationID),
    FOREIGN KEY (orderID) REFERENCES orders(orderID),
    FOREIGN KEY (serviceID) REFERENCES service(serviceID)
);

CREATE TABLE PACKAGE
(packageID int,
orderID int,
FOREIGN KEY (orderID) REFERENCES Orders(OrderID)
);

INSERT INTO USER VALUES (1,'Manikandan','mani24@gmail.com','mani_24','9747920654','KS Buildings,North Usman Road,T-Nagar,Chennai-600017');
INSERT INTO USER VALUES (2,'Raja','raja99@gmail.com','raja@99','8796545381','Appaswamy Greensville,Sholinganallur, Chennai-600119');
INSERT INTO USER VALUES (3,'Deepak','deepdeepak21@gmail.com','deepak@21','8966894325','77, SH 49,Egattur,Chennai-600041');
INSERT INTO USER VALUES (4,'Mukesh','mmukesh2208@gmail.com','mukesh_2208','9764379761','26VJ+W7W, Ramachandra St, T. Nagar, Chennai-600017');
INSERT INTO USER VALUES (5,'Virat','virat18@gmail.com','virat@18','9843257913','13, Doraiswamy Street, Perumbakkam Main Rd,Sholinganallur, Chennai-600119');
INSERT INTO USER VALUES (6,'Ramya','rramya30@gmail.com','rramya@30','9644779541','28, New State Bank Colony , Tambaram West , chennai-600045');

INSERT INTO Orders VALUES (101,1,'Kamal','475, Wipro St, Elcot Sez, Sholinganallur, Chennai-600119',28.11,'Processing','101kamal','2024-01-21',2);
INSERT INTO Orders VALUES (102,2,'Raj','45, Kbm-Vnr Road, Mambakkam, Chennai-603103',31.90,'Delivered','102raj','2024-01-16',3);
INSERT INTO Orders VALUES (103,5,'Megha','VIT University ,Kelambakkam - Vandalur Rd, Rajan Nagar, Chennai, Tamil Nadu 600127',11.43,'Delivered','103megha','2024-01-13',6);
INSERT INTO Orders VALUES (104,4,'Sathya','3/146, Mettu Street, Payanoor, Mahabalipuram,Chennai-603104',44.76,'Cancelled','104sathya','2024-02-14',1);
INSERT INTO Orders VALUES (105,1,'Sriram','R25J+96X, Kamarajar St, Kattankulathur, Chennai-603203',18.65,'Processing','105sriram','2024-01-23',4);
INSERT INTO Orders VALUES (106,3,'Shiva','V2PF+MWF, K.R Puram, Padappai, Chennai-602301',56.20,'Processing','106shiva','2024-01-22',5);
INSERT INTO Orders VALUES (107,3,'Sreeshanth','XXJ4+4W4, Sri Ram Nagar, Sriperumbudur, Chennai-602105',26.90,'Delivered','107sreeshanth','2024-01-12',5);
INSERT INTO Orders VALUES (108,2,'Gokul','5,Amman Koil Rd ,Kamaraj Nagar, Avadi, Chennai-600071',24.60,'Cancelled','108gokul','2024-02-01',3);
INSERT INTO Orders VALUES (109,5,'Yash','12th St, V Block, Anna Nagar, Chennai-600040',21.98,'Processing','109yash','2024-01-26',1);
INSERT INTO Orders VALUES (110,4,'Prem','26, Duraiswamy St, MARKET LANE, Vadapalani, Chennai-600026',76.51,'Delivered','110prem','2024-01-10',3);
INSERT INTO Orders VALUES (111,6,'Divya','Natesan Complex , Rameshwaram Road , T-Nagar , Chennai-600017',49.51,'Delivered','111divya','2024-01-16',2);

INSERT INTO CourierCompany VALUES (91,'BlueDart');
INSERT INTO CourierCompany VALUES (92,'BlueDart Express');
INSERT INTO CourierCompany VALUES (93,'BlueDart Premium');

INSERT INTO Service VALUES (9101,91,'Express Mail',500.00);
INSERT INTO Service VALUES (9102,91,'Speed Post',150.00);
INSERT INTO Service VALUES (9201,92,'Internation Delivery',2500.00);
INSERT INTO Service VALUES (9202,92,'Overnight Delivery',450.00);
INSERT INTO Service VALUES (9301,93,'Domestic Services',250.00);
INSERT INTO Service VALUES (9302,93,'Premium Express',799.00);

INSERT INTO Employee VALUES (1,91,'John Cadman','jon_18@gmail.com','8776655443','Delivery Representative',28000);
INSERT INTO Employee VALUES (2,91,'Vinayak','vinayak22@gmail.com','8268920181','Senior Delivery Representative',38000);
INSERT INTO Employee VALUES (3,92,'Manish','msmanish@gmail.com','9289279191','Truck Driver',21000);
INSERT INTO Employee VALUES (4,92,'Rajesh','rajesh@gmail.com','9926267101','Delivery Manager',45000);
INSERT INTO Employee VALUES (5,93,'Logesh','loki@gmail.com','9352781901','Delivery Representative',27000);
INSERT INTO Employee VALUES (6,93,'Yuvaraj','uvrj@gmail.com','9225719901','Delivery Assistant',28000);

INSERT INTO Location VALUES (600040,'Anna Nagar','3rd St, L Block, West Anna Nagar, Chennai-600040');
INSERT INTO Location VALUES (600032,'Guindy','SIDCO Industrial Estate, Guindy, Chennai-600032');
INSERT INTO Location VALUES (600071,'Avadi','Bharathidasan St, Periyar Nagar, Avadi, Chennai-600071');
INSERT INTO Location VALUES (600045,'Tambaram','81,Kambar Street,East Tambaram, Chennai-600045');
INSERT INTO Location VALUES (602105,'Sriperumbadur','Sivanthangal, Sriperumbudur, Chennai-602105');

INSERT INTO Payment VALUES (301, 91, 600045, 150.00, '2024-01-14', 101,9102);
INSERT INTO Payment VALUES (302, 92, 600045, 490.00, '2024-01-15', 102,9202);
INSERT INTO Payment VALUES (303, 93, 600040, 280.00, '2024-01-11', 103,9301);
INSERT INTO Payment VALUES (304, 92, 602105, 510.00, '2024-01-22', 105,9202);
INSERT INTO Payment VALUES (305, 93, 600045, 830.00, '2024-01-21', 106,9302);  
INSERT INTO Payment VALUES (306, 93, 602105, 285.00, '2024-01-10', 107,9301);    
INSERT INTO Payment VALUES (307, 91, 600040, 175.00, '2024-01-19', 109,9102);  
INSERT INTO Payment VALUES (308, 92, 600032, 410.00, '2024-01-05', 110,9202);  
INSERT INTO Payment VALUES (309, 93, 600045, 540.00, '2024-01-11', 103,9302); -- sample added for task 3 question 20
INSERT INTO Payment VALUES (310, 92, 600032, 430.00, '2024-01-15', 111,9202);

INSERT INTO Packages VALUES (7819,101);
INSERT INTO Packages VALUES (2629,101);
INSERT INTO Packages VALUES (29271,102);
INSERT INTO Packages VALUES (13628,103);
INSERT INTO Packages VALUES (1855,103);
INSERT INTO Packages VALUES (17256,103);
INSERT INTO Packages VALUES (4728,105);
INSERT INTO Packages VALUES (1836,105);
INSERT INTO Packages VALUES (9271,106);
INSERT INTO Packages VALUES (6278,106);
INSERT INTO Packages VALUES (8391,107);
INSERT INTO Packages VALUES (9219,107);
INSERT INTO Packages VALUES (18371,107);
insert into packages VALUES (1918,109);
INSERT INTO Packages VALUES (1983,110);
INSERT INTO Packages VALUES (7381,110);
INSERT INTO Packages VALUES (4729,110);
INSERT INTO Packages VALUES (2249,111);

SELECT * FROM User;
SELECT * FROM CourierCompany;
SELECT * FROM Employee;
SELECT * FROm Location;
SELECT * FROM Orders;
SELECT * FROM Packages;
SELECT * FROM Payment;
SELECT * FROM Service;





