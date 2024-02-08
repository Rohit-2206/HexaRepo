USE cms;

/*----------------------------- Task-4 Inner Join,Full Outer Join, Cross Join, Left Outer Join,Right Outer Join -------------------------*/
-- 23. Retrieve Payments with Courier Information
SELECT PaymentID , PaymentDate , OrderID  , p.CourierID , Name
FROM Payment p
LEFT JOIN CourierCompany c
ON c.CourierID = p.CourierID;

-- 24. Retrieve Payments with Location Information
SELECT PaymentID , PaymentDate ,Amount ,  OrderID ,p.CourierID , l.LocationID , LocationName , Address
FROM Payment p
JOIN Location l
ON p.LocationID = l.LocationID; 

-- 25. Retrieve Payments with Courier and Location Information
SELECT PaymentID , PaymentDate , OrderID  , p.CourierID , Name , l.LocationID , LocationName , Address
FROM Payment p
LEFT JOIN CourierCompany c
ON c.CourierID = p.CourierID
JOIN Location l
ON p.LocationID = l.LocationID;

-- 26. List all payments with courier details
SELECT PaymentID , PaymentDate , OrderID , DeliveryDate , p.CourierID , Name
FROM Payment p
LEFT JOIN CourierCompany c
ON c.CourierID = p.CourierID;

-- 27. Total payments received for each courier
SELECT COUNT(PaymentID) Total_Payments_Made , p.CourierID , Name
FROM Payment p
LEFT JOIN CourierCompany c
ON c.CourierID = p.CourierID
GROUP BY p.CourierID , Name;

-- 28. List payments made on a specific date
SELECT PaymentID , OrderID , PaymentDate , Amount
FROM Payment
WHERE PaymentDate = '2024-01-10';

-- 29. Get Courier Information for Each Payment
SELECT PaymentID , p.OrderID , DeliveryDate , p.CourierID , Name
FROM CourierCompany c 
LEFT JOIN Payment p
ON c.CourierID = p.CourierID
LEFT JOIN Orders o
ON p.OrderID = o.OrderID;

-- 30. Get Payment Details with Location
SELECT PaymentID , PaymentDate ,Amount ,  OrderID ,p.CourierID , l.LocationID , LocationName , Address
FROM Payment p
JOIN Location l
ON p.LocationID = l.LocationID; 

-- 31. Calculating Total Payments for Each Courier
SELECT COUNT(PaymentID) Total_Payments , Payment.CourierID , Name 
FROM Payment
JOIN CourierCompany
ON Payment.CourierID = CourierCompany.CourierID
GROUP BY CourierID , Name;

-- 32. List Payments Within a Date Range
SELECT Paymentid , OrderID , PaymentDate , Amount
FROM Payment
WHERE PaymentDate BETWEEN '2024-01-10' AND '2024-01-15';

-- 33. Retrieve a list of all users and their corresponding courier records, including cases where there are no matches on either side
SELECT UserID ,OrderID, Name SenderName, ReciverName , RecieverAddress, Status 
FROM User
LEFT JOIN Orders
ON User.UserID = Orders.SenderUserID;

-- 34. Retrieve a list of all couriers and their corresponding services, including cases where there are no matches on either side
SELECT CourierCompany.CourierID ,Name , ServiceName , Cost
FROM CourierCompany
LEFT JOIN Service
ON CourierCompany.CourierID = Service.CourierID;

-- 35. Retrieve a list of all couriers and their corresponding payments, including cases where there are no matches on either side
SELECT Orders.OrderID , Name SenderName , ReciverName ,Amount , Status , PaymentDate , DeliveryDate
FROM Payment
JOIN Orders 
ON Payment.OrderID = Orders.OrderID
JOIN User 
ON Orders.SenderUserID = User.UserID;

-- 36. List all users and all courier services, showing all possible combinations
SELECT UserID , Name , ServiceID , ServiceName
FROM User
CROSS JOIN Service;

-- 37. List all employees and all locations, showing all possible combinations
SELECT EmployeeID , Name , LocationID , LocationName
FROM Employee
CROSS JOIN Location;

-- 38. Retrieve a list of couriers and their corresponding sender information (if available)
SELECT UserID , Name , OrderID , DeliveryDate
FROM User 
RIGHT JOIN Orders
ON Orders.SenderUserID = User.UserID;

-- 39. Retrieve a list of couriers and their corresponding receiver information (if available)
SELECT ReciverName , RecieverAddress ,Employee.CourierID , CourierCompany.Name, OrderID , Status
FROM Orders
JOIN Employee
ON Employee.EmployeeID = Orders.EmployeeID
JOIN CourierCompany
ON Employee.CourierID = CourierCompany.CourierID;

-- 40. Retrieve a list of couriers along with the courier service details (if available)
SELECT o.OrderID , PaymentID ,PaymentDate ,Status, s.ServiceID , ServiceName
FROM Payment p
LEFT OUTER JOIN Service s
ON p.ServiceID = s.ServiceID
JOIN Orders o
ON p.OrderID = o.OrderID;

-- 41. Retrieve a list of employees and the number of couriers assigned to each employee
SELECT Employee.EmployeeID , Name , COUNY(OrderID) Assigned_Orders
FROM Orders
RIGHT JOIN employee
ON Orders.Employeeid = Employee.Employeeid
GROUP BY EmployeeID , Name;

-- 42. Retrieve a list of locations and the total payment amount received at each location
SELECT Location.LocationID , LocationName , SUM(Amount)
FROM Location
LEFT JOIN Payment  
ON Payment.Locationid = Location.Locationid
GROUP BY LocationID;

-- 43. Retrieve all couriers sent by the same sender (based on SenderName)
SELECT OrderID ,Name SenderName, ReciverName ReceiverName, RecieverAddress ReceiverAddress
FROM Orders
JOIN User 
ON User.UserID = Orders.SenderUserID
WHERE Name IN (SELECT Name 
FROM User u
join orders o
on u.userID = o.SenderUSerID 
GROUP BY Name
HAVING COUNT(SenderUserID) > 1); --------------

-- 44. List all employees who share the same role
WITH CTE AS (
SELECT Role , COUNT(Role) as count
FROM Employee
GROUP BY Role
)
Select EmployeeID , Name , cte.Role , count
FROM Employee 
JOIN cte 
ON Employee.Role = cte.Role
HAVING count > 1;

-- 45. Retrieve all payments made for couriers sent from the same location
SELECT PaymentID , CourierID , Amount, l.LocationId , PaymentDate
FROM Payment P
JOIN Location l
ON P.LocationId = l.LocationId;

-- 46. Retrieve all couriers sent from the same location (based on SenderAddress)
SELECT OrderID , Name senderName ,address SenderAddress , ReciverName ReceiverName , RecieverAddress ReceiverAddress
FROM User u
JOIN Orders o
ON u.userid = o.senderuserID
GROUP BY address, orderID;

-- 47. List employees and the number of couriers they have delivered
SELECT Employee.EmployeeID , Name , COUNT(Status) Delivered
FROM Employee
LEFT JOIN Orders
ON Employee.Employeeid = Orders.Employeeid
AND Status = 'Delivered'
GROUP BY EmployeeID;

-- 48. Find couriers that were paid an amount greater than the cost of their respective courier services
SELECT PaymentID , OrderID , PaymentDate, p.ServiceID , p.Amount Paid_Amount , s.Cost Actual_Amount
FROM Payment p
JOIN Service s
ON p.ServiceID = s.ServiceID 
WHERE p.Amount > s.Cost; 

-- Scope: Inner Queries, Non Equi Joins, Equi joins,Exist,Any,All

-- 49. Find couriers that have a weight greater than the average weight of all couriers
SELECT OrderID , SenderUserID , Weight 
FROM Orders 
WHERE Weight > (SELECT AVG(Weight) FROM Orders);

-- 50. Find the names of all employees who have a salary greater than the average salary
SELECT EmployeeID , Name , Salary 
FROM Employee 
WHERE Salary > ANY (SELECT AVG(salary) FROM Employee);

-- 51. Find the total cost of all courier services where the cost is less than the maximum cost
SELECT COUNT(*) no_of_couriers_less_than_max_cost , SUM(cost) total_cost_of_all_couriers
FROM service 
WHERE Cost < (
SELECT MAX(cost)
FROM service
);
-- 52. Find all couriers that have been paid for
select c.CourierID , Name , s.ServiceID , ServiceName , PaymentDate
FROM Payment p
JOIN CourierCompany c
ON p.CourierID = c.CourierID
JOIN Service s
ON p.ServiceID = s.ServiceID;

-- 53. Find the locations where the maximum payment amount was made
SELECT l.LocationID , LocationName , Amount
FROM Location l
JOIN Payment p
ON p.locationID = l.LocationID 
WHERE Amount = (SELECT MAX(Amount) FROM Payment);

-- 54. Find all couriers whose weight is greater than the weight of all couriers sent by a specific sender(e.g., 'SenderName')
SELECT OrderID , SenderUserID , Status , DeliveryDate , Weight
FROM Orders
WHERE Weight > (
SELECT SUM(Weight) 
FROM Orders
WHERE SenderUserID = 1
);
