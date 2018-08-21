INSERT INTO users(first_name, last_name, email, password, phone, type) 
VALUES  ("prakalpa", "rathore", "prakalparathore@gmail.com", "prak@123", "8504855348", "admin"),
        ("deekshika", "sharma", "deekshikasharma@gmail.com", "deekshika25", "8765234395", "shopper"),
        ("arjita", "marelay", "arjitamarelay@gmail.com", "arjita#192", "8465233278", "shopper"),
        ("chirag", "jain", "chirag@gmail.com", "chirag", "9543567836", "shopper"),
        ("richa", "jain", "richa@gmail.com", "richa", "9542235667", "shopper");
        
INSERT INTO address(house_no, street, landmark, city, state, pincode, user_id)
VALUES  (101, "jln marg", "india gate", "jaipur", "rajasthan", "302022", 2),
        (502, "malviya nagar", "sms hospital", "jaipur", "rajasthan", "302022", 3),
        (102, "malviya nagar", "sms hospital", "jaipur", "rajasthan", "302022", 3),#3
        (401, "riico marg", "india gate", "jaipur", "rajasthan", "302022", 4),
        (541, "sharma mohalla", "india gate", "jaipur", "rajasthan", "302022", 4),
        (231, "paanch batti", "india gate", "jaipur", "rajasthan", "302022", 4),#6
        (678, "raisar plaza", "india gate", "jaipur", "rajasthan", "302022", 5);
        
INSERT INTO category(name, parent_category_id)
VALUES  ("Eletronics", NULL),
        ("Mobile", 1),
        ("Laptops", 1),#3
        ("Mobile Accessories", 2),
        ("Laptop Accessories", 3),
        ("Fashion", NULL),#6
        ("Men's Fashion", 6),
        ("Women's Fashion", 6),
        ("Men's Watch", 7),#9
        ("Women's Watch", 8),
        ("Sports", NULL),
        ("Cricket", 11),#12
        ("Football", 11);
        
INSERT INTO product(name, description, available_stock, price)
VALUES  ("Apple iPhone X", "Latest by apple", 13, 70000.00),
        ("Samsung S9", "Latest by samsung", 121, 62000.00),
        ("HP BS-164TU", "Top selling by HP", 34, 41000.00),#3
        ("Dell AB-220TX", "Top selling by Dell", 23, 47500.00),
        ("Sandisk Memory card 32 gb", "Top selling memory card by Sandisk", 45, 410.00),
        ("Sandisk pen drive 32 gb", "Top selling pen drive by Sandisk", 54, 540.00),#6
        ("Timex Men's Watch", "Best in men class", 132, 5000.00),
        ("Timex Women's Watch", "Best in women class", 123, 7000.00),
        ("SG Full Size Bat", "Best for batting", 546, 900.00),#9
        ("Adidas Football", "Best for football", 234, 1000.00),
        ("Apple iPhone 8", "Latest by apple", 0, 70000.00);
        
INSERT INTO product_category(product_id, category_id)
VALUES  (1, 2),
        (2, 2),
        (3, 3),
        (4, 3),
        (5, 4),
        (6, 5),
        (7, 9),
        (8, 10),
        (9, 12),
        (10, 13);
        
INSERT INTO image(product_id, alternate_text, url)
VALUES  (1, "iPhone image 1", "image.com/id101"),
        (1, "iPhone image 2", "image.com/id102"),
        (1, "iPhone image 3", "image.com/id103"),
        (2, "samsung image 1", "image.com/id201"),
        (3, "HP Laptop image 1", "image.com/id301"),
        (4, "Dell laptop image 1", "image.com/id401"),
        (7, "Men's watch image 1", "image.com/id701"),
        (8, "Women's watch image 1", "image.com/id801"),
        (8, "Women's watch image 2", "image.com/id802");
        
INSERT INTO orders(user_id, billing_address_id, total_bill, placed_date)
VALUES  (2, 1, 124000.00, NULL),
        (3, 3, 143580.00, '2018-07-04 14:29:36'),
        (5, 7, 820.00, '2018-07-07 14:29:36'),
        (5, 7, 1800.00, '2018-07-19 14:29:36');

INSERT INTO order_line_item(product_id, order_id, shipping_address_id, status, quantity, ship_date, deliver_date)
VALUES  (2, 1, 1, NULL, 2, NULL, NULL),
        (4, 2, 2, "placed", 3, NULL, NULL),
        (6, 2, 3, "shipped", 2, '2018-07-05 14:29:36', NULL),
        (5, 3, 7, "delivered", 2, '2018-07-08 14:29:36', '2018-07-20 17:29:36'),
        (9, 4, 7, "returned", 2, '2018-07-21 14:29:36', '2018-07-25 17:29:36');
