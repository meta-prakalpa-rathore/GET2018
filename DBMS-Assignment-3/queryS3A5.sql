USE store_front;

#Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days.
CREATE OR REPLACE VIEW orders_in_past_60_days AS
		SELECT orders.order_id AS order_id,
           order_line_item.product_id AS product_id,
           order_line_item.quantity AS quantity,
           product.name AS product_name,
           orders.total_bill AS total_bill,
           CONCAT(users.first_name,' ', users.last_name) AS user_name,
           users.email AS email,
           orders.placed_date AS placed_date,
           order_line_item.status AS status
		FROM users INNER JOIN orders ON orders.user_id = users.user_id
               INNER JOIN order_line_item ON orders.order_id = order_line_item.order_id
               INNER JOIN product ON product.product_id = order_line_item.product_id
    WHERE orders.placed_date > (DATE_SUB(CURDATE(), INTERVAL 60 DAY))
    ORDER BY orders.placed_date DESC;
        
        
SELECT * FROM orders_in_past_60_days;

#Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT product_id, product_name
FROM orders_in_past_60_days
WHERE status = "shipped";

#Use the above view to display the top 5 most selling products.
SELECT product_name, SUM(quantity) AS total_bought
FROM orders_in_past_60_days
GROUP BY product_name
ORDER BY total_bought DESC LIMIT 5;
