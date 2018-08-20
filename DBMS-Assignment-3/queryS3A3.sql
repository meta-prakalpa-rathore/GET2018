/*Display Shopper’s information along with number of orders he/she placed during last 30 days.*/
SELECT users.user_id, users.first_name, users.last_name, COUNT(orders.user_id) AS orders_in_last_30_days
FROM users INNER JOIN orders
ON users.user_id = orders.user_id
WHERE orders.placed_date > (DATE_SUB(CURDATE(), INTERVAL 1 MONTH))
GROUP BY orders.user_id;

/*Display the top 10 Shoppers who generated maximum number of revenue in last 30 days*/
SELECT users.user_id, users.first_name , SUM(orders.total_bill) as sum
FROM orders INNER JOIN users
ON orders.user_id = users.user_id
WHERE orders.placed_date > (DATE_SUB(CURDATE(), INTERVAL 1 MONTH))
GROUP BY orders.user_id
ORDER BY sum DESC
LIMIT 10;

/*Display top 20 Products which are ordered most in last 60 days along with numbers*/
SELECT product.product_id ,  product.name , COUNT(order_line_item.product_id) as product_count
FROM product INNER JOIN order_line_item
ON product.product_id = order_line_item.product_id
INNER JOIN orders
ON order_line_item.order_id = orders.order_id
WHERE orders.placed_date > (DATE_SUB(CURDATE(), INTERVAL 2 MONTH))
GROUP BY order_line_item.product_id
ORDER BY product_count
LIMIT 20;

/*Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale*/
SELECT MONTHNAME(orders.placed_date) AS month , SUM(orders.total_bill) AS total_order
FROM orders
WHERE orders.placed_date > (DATE_SUB(CURDATE(), INTERVAL 6 MONTH))
GROUP BY month(orders.placed_date);

/*Mark the products as Inactive which are not ordered in last 90 days.*/
SET SQL_SAFE_UPDATES = 0;
ALTER TABLE product 
ADD product_state varchar(8) DEFAULT "active"
AFTER description;

UPDATE product
SET product_state = "inactive"
WHERE product.product_id IN 
    (SELECT order_line_item.product_id
     FROM orders INNER JOIN order_line_item
     ON orders.order_id= order_line_item.order_id
     WHERE orders.placed_date < (DATE_SUB(CURDATE(), INTERVAL 3 MONTH))
    );
                     
/*Given a category search keyword, display all the Products present in this category/categories*/
SELECT product.name
FROM product INNER JOIN product_category
ON product.product_id = product_category.product_id
INNER JOIN category
ON category.category_id = product_category.category_id
WHERE category.name = "Mobile Accessories";

/*Display top 10 Items which were cancelled most.*/
SELECT product.product_id , product.name , COUNT(order_line_item.status) as cancel_count
FROM product INNER JOIN order_line_item
ON product.product_id = order_line_item.product_id
WHERE order_line_item.status = "cancelled"
GROUP BY order_line_item.product_id
ORDER BY cancel_count DESC
LIMIT 10;