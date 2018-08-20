/*Create a Stored procedure to retrieve average sales of each product in a month.
Month and year will be input parameter to function.*/
DELIMITER $$
CREATE PROCEDURE avg_sale_in_month(month INTEGER, year INTEGER)
BEGIN
  SELECT p.product_id, ROUND(SUM(p.price * o.quantity) / DAY(LAST_DAY(od.placed_date)), 2) AS productAverage 
    FROM product p INNER JOIN order_line_item o ON p.product_id = o.product_id
    INNER JOIN orders od ON od.order_id = o.order_id
    WHERE MONTH(od.placed_date) = month AND YEAR(od.placed_date) = year
    GROUP BY p.product_id;
END$$


CALL avg_sale_in_month(07, 2018);


/*Create a stored procedure to retrieve table having order detail with status for a given period.
Start date and end date will be input parameter.
Put validation on input dates like start date is less than end date.
If start date is greater than end date take first date of month as start date*/
DELIMITER $$
CREATE PROCEDURE sale_between(start_date DATE, end_date DATE)
BEGIN
  IF start_date > end_date THEN SET start_date = DATE_ADD(DATE_ADD(LAST_DAY(start_date), INTERVAL 1 DAY), INTERVAL - 1 MONTH);
  END IF;
  SELECT o.order_id, oli.product_id, oli.status
  FROM orders o INNER JOIN order_line_item oli ON o.order_id = oli.order_id
  WHERE (o.placed_date BETWEEN start_date AND end_date);
END$$


CALL sale_between('2018-07-01 00:00:00', '2018-07-31 23:59:00'); 

CALL sale_between('2018-07-31 00:00:00', '2018-07-15 23:59:00');
