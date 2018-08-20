#Display Recent 50 Orders placed(Id, Order Date, Order Total)
SELECT order_id, placed_date, total_bill 
FROM orders
WHERE placed_date IS NOT NULL
ORDER BY placed_date DESC LIMIT 50;

#Display 10 most expensive Orders.
SELECT order_id, total_bill
FROM orders
ORDER BY total_bill DESC LIMIT 10;

#Display all the Orders which are placed more than 10 days old AND one or more items FROM those orders are still not shipped.
SELECT o.order_id , o.total_bill
FROM orders o
WHERE
o.placed_date < (DATE_SUB(CURDATE(), INTERVAL 10 DAY))
AND
o.order_id IN (SELECT DISTINCT order_id FROM order_line_item WHERE status = "placed");

#Display list of shoppers which haven't ordered anything since lASt mONth.
SELECT user_id, first_name 
FROM users
WHERE users.user_id NOT IN
(
SELECT user_id AS active_user 
FROM orders O
WHERE placed_date > (DATE_SUB(CURDATE(), INTERVAL 1 MONTH))
)
AND users.type = "shopper";

#Display list of shopper along with orders placed BY them in last 15 days.
SELECT u.user_id , u.first_name , o.total_bill
FROM orders o INNER JOIN users u
ON u.user_id = o.user_id
WHERE placed_date > (DATE_SUB(CURDATE(), INTERVAL 15 DAY));

#Display list of ORDER items which are in “shipped” state for particular Order Id (i.e.: 1020))
SELECT p.product_id , p.name
FROM product p INNER JOIN order_line_item o
ON p.product_id = o.product_id
WHERE o.status = "shipped" AND o.order_id = 2;

#Display list of ORDER items along with ORDER placed date which fall between Rs 20k to Rs 50k price.
SELECT p.name , o.placed_date
FROM product p INNER JOIN order_line_item os
ON os.product_id = p.product_id
INNER JOIN orders o
ON o.order_id = os.order_id
WHERE p.price >=20000 AND p.price<=50000;

#Update first 20 Order items status to “Shipped” which are placed today.
SET SQL_SAFE_UPDATES = 0;
UPDATE order_line_item 
SET order_line_item.status = "shipped"
WHERE order_line_item.order_id IN
(
SELECT orders.order_id 
from orders 
where orders.placed_date=CURDATE()
)
LIMIT 20;
