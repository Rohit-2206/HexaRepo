USE cms;
-- Task-2

-- 1. List all customers
SELECT * 
FROM user;

-- 2. List all orders for a specific customer
SELECT * 
FROM orders
WHERE SenderUserID = '3';

-- 3. List all couriers
SELECT * 
FROM couriercompany;

-- 4. List all packages for a specific order
SELECT * 
FROM packages 
WHERE orderID = '101';

-- 5. List all deliveries for a specific courier
SELECT OrderID 
FROM Payment 
WHERE CourierID = '93';

-- 6. List all undelivered packages
SELECT *
FROM Orders
WHERE Status IN ('processing' , 'cancelled');

-- 7. List all packages that are scheduled for delivery today
SELECT * 
FROM orders
WHERE DeliveryDate = now();

-- 8. List all packages with a specific status
SELECT * 
FROM orders
WHERE status = 'processing';

-- 9. Calculate the total number of packages for each courier
SELECT CourierID, COUNT(*) as count_of_packages
FROM Payment
JOIN Packages
ON Payment.OrderID = Packages.OrderID
GROUP BY CourierID;

-- 10. Find the average delivery time for each courier
SELECT CourierID,AVG(DATEDIFF(deliverydate,paymentdate)) as Avg_delivery_time
FROM Payment
JOIN Orders
ON Payment.OrderID = Orders.OrderID
GROUP BY CourierID;

-- 11. List all packages with a specific weight range
SELECT * 
FROM Orders
WHERE Weight BETWEEN 20.00 AND 40.00;

-- 12. Retrieve employees whose names contain 'John'
SELECT * 
FROM employee
WHERE Name like '%john%';

-- 13. Retrieve all courier records with payments greater than $50.
SELECT * 
FROM payment
WHERE Amount > 50;
