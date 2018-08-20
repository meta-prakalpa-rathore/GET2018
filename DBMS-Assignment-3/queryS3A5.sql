USE store_front;
#Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days.
CREATE OR REPLACE VIEW orders_in_past_60_days
	AS
		SELECT orders.order_id, order_line_item.product_id, order_line_item.quantity, product.name, orders.total_bill, users.first_name, users.last_name, users.email, orders.placed_date, order_line_item.status
		FROM orders, product, users, order_line_item
    WHERE order_line_item.order_id = orders.order_id AND orders.order_id = users.user_id AND order_line_item.product_id = product.product_id AND orders.placed_date > (DATE_SUB(CURDATE(), INTERVAL 2 MONTH))
    ORDER BY order_line_item.order_id DESC;
        
        
SELECT * FROM orders_in_past_60_days;

#Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT product_id, name
FROM orders_in_past_60_days
WHERE status = "shipped";

#Use the above view to display the top 5 most selling products.
SELECT name, SUM(quantity) AS total_bought
FROM orders_in_past_60_days
GROUP BY name
ORDER BY total_bought DESC LIMIT 5;