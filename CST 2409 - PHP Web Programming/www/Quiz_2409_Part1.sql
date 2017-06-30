-- Question 1
SELECT e.id, firstname, lastname, et.description, salary FROM employee e INNER JOIN employeetitle et ON e.titleid = et.id WHERE e.salary > 70000;

-- Question 2
SELECT * FROM marginaltax;

-- Question 3
SELECT * FROM employee e INNER JOIN employeetitle et ON e.titleid = et.id;

-- Question 5
SELECT id, firstname, lastname, percentage FROM employee e INNER JOIN marginaltax mt ON e.taxcode = mt.code WHERE lastname LIKE '%e%';