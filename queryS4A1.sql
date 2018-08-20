#Create a function to calculate number of orders in a month. Month and year will be input parameter to function.
DELIMITER $$
CREATE FUNCTION order_in_month(month INT, year INT)
   RETURNS INT NOT DETERMINISTIC
BEGIN    
DECLARE order_count INT;
SELECT COUNT(placed_date) INTO order_count
FROM orders
WHERE placed_date IS NOT NULL AND MONTH(placed_date) = month AND YEAR(placed_date) = year;
RETURN (order_count);
END$$

SELECT order_in_month(06,2018);

DROP FUNCTION order_in_month;
#Create a function to return month in a year having maximum orders. Year will be input parameter.
DELIMITER $$
CREATE FUNCTION highest_order(year INT)
   RETURNS INT NOT DETERMINISTIC
BEGIN    
DECLARE order_month INT;
SELECT temp.month
FROM
(
SELECT order_in_month(MONTH(orders.placed_date), year) AS monthly_order, MONTH(orders.placed_date) AS month
FROM orders
WHERE orders.placed_date IS NOT NULL
GROUP BY month
ORDER BY monthly_order DESC LIMIT 1
) temp
INTO order_month
;
RETURN (order_month);
END$$

SELECT highest_order(2018);

DROP FUNCTION highest_order;