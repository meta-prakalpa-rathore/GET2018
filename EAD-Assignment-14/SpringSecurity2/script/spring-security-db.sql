CREATE DATABASE userDetails;
USE userDetails;

CREATE  TABLE users (
    username VARCHAR(100) NOT NULL ,
    password VARCHAR(50) NOT NULL ,
    enabled BOOLEAN NOT NULL DEFAULT true,
    PRIMARY KEY (username)
);

CREATE  TABLE role (
    roleId INT NOT NULL AUTO_INCREMENT ,
    username VARCHAR(100) NOT NULL ,
    role VARCHAR(50) NOT NULL ,
    FOREIGN KEY (username)
    REFERENCES users(username)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    PRIMARY KEY (roleId)
);

INSERT INTO users (username, password) VALUES
('prakalpa',12345),
('deekshika',12345),
('arjita',12345),
('chirag',12345);

INSERT INTO role (username, role) VALUES
('prakalpa', 'ADMIN'),
('deekshika', 'USER');