<table>
	<tr>
		<th><ins>lastName</ins></th>
		<th><ins>firstName</ins></th>
		<th><ins>salary</ins></th>
		<th><ins>state</ins></th>
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

$sql = "SELECT s.lastname, s.firstname, s.salary, s.state FROM SalePerson s";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
     // output data of each row
     while($row = $result->fetch_assoc()) {
        $lastname = $row["lastname"];
		$firstname = $row["firstname"];
		$salary = $row["salary"];
		$state = $row["state"];
		//$bold = $row["salary"] > 100000 ? "gt100k": "";
		//echo "
			//<tr class = '$bold'>
				//<td><b>$lastname</b></td>
				//<td><b>$firstname</b></td>
				//<td><b>$salary</b></td>
				//<td><b>$state</b></td>
			//</tr>
			//";
		if ($salary > 100000){
			echo "
			<tr>
				<td><b>$lastname</b></td>
				<td><b>$firstname</b></td>
				<td><b>$salary</b></td>
				<td><b>$state</b></td>
			</tr>
			";
		}
		else {
			echo "
			<tr>
				<td>$lastname</td>
				<td>$firstname</td>
				<td>$salary</td>
				<td>$state</td>
			</tr>
			";
		}
     }
} else {
     echo "0 results";
}

$conn->close();
?>  
</table>