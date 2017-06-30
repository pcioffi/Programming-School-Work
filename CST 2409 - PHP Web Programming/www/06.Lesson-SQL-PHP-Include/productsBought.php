<table class = "report">
	<tr>
		<th>Product name</th>
		<th>Quantity</th>
		<th>Cost</th>
		<th>Purchased</th>
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

$sql = "SELECT p.description, o.quantity, p.cost, p.cost * o.quantity AS spent FROM Product p INNER JOIN Orders o ON p.id = o.productid";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
     // output data of each row
	 $total = 0;
     while($row = $result->fetch_assoc()) {
        $description = $row["description"];
		$quantity = $row["quantity"];
		$cost = $row["cost"];
		//$spent2 = $row["spent"];
		$spent = $cost * $quantity;
		$total = $total + $spent;
		echo "
		<tr>
			<td>$description</td>
			<td>$quantity</td>
			<td>$cost</td>
			<td>$spent</td>
		</tr>
		";
     }	
} else {
     echo "0 results";
}

$conn->close();
?>
	<tfoot>
		<th colspan = '3'> Total Spent:</th>
		<th><?php echo $total ?></th>
	</tfoot>
</table>