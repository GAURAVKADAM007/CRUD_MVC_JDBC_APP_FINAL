DROP DATABASE IF EXISTS employeeDb;
CREATE DATABASE employeeDb ;

\c employeeDb

DROP TABLE IF EXISTS employee;
CREATE TABLE employee(
    eid SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    salary DECIMAL(7,2) NOT NULL,
    Department VARCHAR(20) NOT NULL
);

INSERT INTO employee(name,salary,department) VALUES('Gaurav Kadam','50000','IT');
INSERT INTO employee(name,salary,department) VALUES('Samarth Dhute','60000','Sales');
INSERT INTO employee(name,salary,department) VALUES('Sarthak Thorat','70000','HR');
INSERT INTO employee(name,salary,department) VALUES('Vivek Shinde','80000','Marketing');

SELECT * FROM employee;