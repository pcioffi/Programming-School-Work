--FileName: peopleDB.sql

--creates a database
CREATE DATABASE peopleDB;

--to display all database
SHOW DATABASES;

--select a database
USE peopledb;

--create a table
CREATE TABLE Employee
(
	id int not null,
	lastName varchar(25) not null,
	firstName varchar(25) not null,
	salary decimal (10,2) not null,
	address varchar(50) not null,
	city varchar (255) not null,
	state varchar(2) not null
);

--check properties of the database
DESC Employee;

--add a primary key
ALTER TABLE Employee
ADD CONSTRAINT pk_EmployeeId PRIMARY KEY (id);

--ID = 2000

--display all the employees who live in brooklyn
select * from Employee where city = 'Brooklyn';

--display all the employees who live in brooklyn or queens
select * from Employee where city = 'Brooklyn' || city = 'Queens';
--select * from Employee where city = 'Brooklyn' OR city = 'Queens';
--select * from Employee where city in ('Brooklyn', 'Queens');

--display lastname, firstnam, salary of all employees that make more than 70,000
select lastName, firstName, salary from Employee where salary > 70000;

--display lastname, firstnam, salary of all employees that make more than 70,000 sort by salary in ascending order
select lastName, firstName, salary from Employee where salary > 70000 order by salary;

--display (only lastname, firstname) all the employee that  contain the letter "e" in their lastname (sort name in desc order)
select lastName, firstName from Employee where lastName like '%E%' order by lastName desc;

--display all salaries by borough
select city, sum(salary) from employee group by city order by city;

--fix with Manhattan & New York
UPDATE Employee set city = 'Manhattan' where city = 'Manhatten';
UPDATE Employee set city = 'New York' where city = 'New York City';

--display all salaries by borough & number of employees
select city, sum(salary), COUNT(lastName) from employee group by city order by city;

--display all salaries by borough & number of employees, show the rows that have a count of 1
select city, sum(salary), count(lastName) from employee group by city having count(lastName) = 1;

--display all salaries by borough & number of employees, show the rows that have a count of 1
select city, sum(salary) AS totalSalary, count(lastName) AS numberOfPeople from employee group by city having count(lastName) = 1;

--display all salaries by borough & number of employees, show the rows that have a count of 1 (change the table names)
select city, sum(salary) AS totalSalary, count(lastName) AS numberOfPeople from employee group by city having count(lastName) = 1;

--give everyone a raise of 5%
UPDATE Employee set salary = salary * 1.05;

--display blocks of people who earn 70k & 100k (display lastName, firstName, salary)
select 1 as sortNo, lastName, firstName, salary from Employee where salary <= 70000
union 
select 2, lastName, firstName, salary from Employee where salary >= 100000 order by 1, lastname;

--select lastName, firstName, salary from Employee where salary <= 70000 group by lastName
--UNION
--select lastName, firstName, salary from Employee where salary >= 70000 group by lastName
--(DOES NOT WORK, LAST NAMES WERE GROUPED TOGETHER)