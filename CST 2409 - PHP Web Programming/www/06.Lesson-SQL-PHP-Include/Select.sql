-- fileName: Select.sql
-- display id, lastname, firstname, creditLimit
SELECT customer.id, lastname, firstname, creditLimit FROM Customer, CreditLimit WHERE customerID = customer.id;

-- ANSI Standard
SELECT c.id, c.lastname, c.firstname, cl.creditLimit FROM Customer c INNER JOIN CreditLimit cl ON cl.customerID = c.id;