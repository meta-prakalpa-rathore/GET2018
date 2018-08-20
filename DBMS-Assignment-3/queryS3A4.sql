/*Consider a form where providing a Zip Code populates associated City and State.*/

/*Create appropriate tables and relationships for the same and write a SQL
query for that returns a Resultset containing Zip Code, City Names and
States ordered by State Name and City Name.*/
CREATE TABLE zipcode(
pin_code INT PRIMARY KEY,
city VARCHAR(25) NOT NULL ,
state VARCHAR(25) NOT NULL 
);
INSERT INTO zipcode(pin_code,city,state)
VALUES(484001,"shahdol","mp"),
      (302022,"jaipur","raj"),
      (313002,"udaipur","raj");
SELECT pin_code , city , state
FROM zipcode
ORDER BY state,city;