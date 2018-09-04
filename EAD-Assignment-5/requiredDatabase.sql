CREATE DATABASE advertise;

USE advertise;

CREATE TABLE category
(   
    id INT AUTO_INCREMENT,
    category_name VARCHAR(30) UNIQUE NOT NULL,
    CONSTRAINT PK_id PRIMARY KEY(id)
);

CREATE TABLE advertisement
(   
    id INT AUTO_INCREMENT,
    title VARCHAR(30),
    description VARCHAR(500),
    category_id INT,
    CONSTRAINT PK_id PRIMARY KEY(id),
    CONSTRAINT FK_id_category_id FOREIGN KEY(category_id) REFERENCES category(id)
);
