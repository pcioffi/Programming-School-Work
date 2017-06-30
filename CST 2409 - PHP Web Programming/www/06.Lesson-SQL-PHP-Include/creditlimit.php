<?php
$servername = "localhost:3306";
$username = "root";
$password = "";
$dbname = "CustomerDB";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
     die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT c.id, c.lastname, c.firstname, cl.creditLimit FROM Customer c INNER JOIN CreditLimit cl ON cl.customerID = c.id";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
     // output data of each row
     while($row = $result->fetch_assoc()) {
         echo "<br> id: "
			. $row["id"]. " - fName: ". $row["firstname"]
			. " - lName: ". $row["lastname"]
			." ". $row["creditLimit"] . "<br>";
     }
} else {
     echo "0 results";
}

$conn->close();
?>  