CREATE DATABASE store_front;
USE store_front;

CREATE TABLE users
(
    user_id INTEGER AUTO_INCREMENT,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20),
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(30) NOT NULL,
    phone CHAR(10) UNIQUE NOT NULL, 
    type VARCHAR(7) CHECK(type IN ("admin", "shopper")),
    PRIMARY KEY(user_id)
);

CREATE TABLE address
(
    address_id INTEGER AUTO_INCREMENT,
    house_no VARCHAR(7),
    street VARCHAR(30) NOT NULL,
    landmark VARCHAR(30),
    city VARCHAR(30) NOT NULL,
    state VARCHAR(30) NOT NULL,
    country VARCHAR(30) DEFAULT "india",
    pincode VARCHAR(6) NOT NULL,
    user_id INTEGER,
    PRIMARY KEY(address_id),
    FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE category
(
    category_id INTEGER AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    parent_category_id INTEGER,
    PRIMARY KEY(category_id),
    FOREIGN KEY(parent_category_id) REFERENCES category(category_id)
);

CREATE TABLE product
(
    product_id INTEGER AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(500),
    available_stock INTEGER NOT NULL,
    price FLOAT NOT NULL,
    PRIMARY KEY(product_id)
 );
 
 CREATE TABLE product_category
 (
    product_id INTEGER,
    category_id INTEGER,
    PRIMARY KEY(product_id, category_id),
    FOREIGN KEY(product_id) REFERENCES product(product_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(category_id) REFERENCES category(category_id) ON UPDATE CASCADE ON DELETE CASCADE
 );
 
 CREATE TABLE image
 (
    image_id INTEGER AUTO_INCREMENT,
    product_id INTEGER NOT NULL,
    alternate_text VARCHAR(30),
    url VARCHAR(200) NOT NULL,
    PRIMARY KEY(image_id),
    FOREIGN KEY(product_id) REFERENCES product(product_id)
);

CREATE TABLE orders
(
    order_id INTEGER AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    billing_address_id INTEGER NOT NULL,
    total_bill FLOAT,
    placed_date DATETIME,
    PRIMARY KEY(order_id),
    FOREIGN KEY(user_id) REFERENCES users(user_id),
    FOREIGN KEY(billing_address_id) REFERENCES address(address_id)
);

CREATE TABLE order_line_item
(
    product_id INTEGER NOT NULL,
    order_id INTEGER NOT NULL,
    shipping_address_id INTEGER NOT NULL,
    status VARCHAR(10) CHECK(status IN (NULL, "placed", "shipped", "delivered", "cancelled", "returned")),
    quantity INTEGER NOT NULL,
    ship_date DATETIME,
    deliver_date DATETIME,
    PRIMARY KEY(order_id, product_id),
    FOREIGN KEY(product_id) REFERENCES product(product_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(shipping_address_id) REFERENCES address(address_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(order_id) REFERENCES orders(order_id) ON UPDATE CASCADE ON DELETE CASCADE
);
