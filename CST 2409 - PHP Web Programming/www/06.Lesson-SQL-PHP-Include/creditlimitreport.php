<!DOCTYPE html>
<!-- fileName: creditlimit.php-->
<html>
<body>
<table>
	<tr>
		<th>id</th>
		<th>lastname</th>
		<th>firstname</th>
		<th>credit limit</th>
	</tr>
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
        $id = $row["id"];
		$firstName = $row["firstname"];
		$lastName = $row["lastname"];
		$creditLimit = $row["creditLimit"];
		echo "
		<tr>
			<td>$id</td>
			<td>$firstName</td>
			<td>$lastName</td>
			<td>$creditLimit</td>
		</tr>
		";
     }
} else {
     echo "0 results";
}

$conn->close();
?>  
</table>

</body>
</html>