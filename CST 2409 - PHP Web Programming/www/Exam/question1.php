<!DOCTYPE html>
<!-- fileName: question1.php-->
<html>
<style>
	caption{
		font-family: Calibri;
		font-size: 24pt;
		text-align: center;
		font-weight: bold;
	}
	table.report{
		font-family: Calibri;
		font-size: 11pt;
		border: solid 1px black;
		border-collapse: collapse;
	}
	table.report th{
		font-weight: bold;
		text-align: center;
		border: solid 1px black;
	}
	table.report td{
		border: solid 1px black;
		text-align: left;
	}
</style>
<body>
<table class = "report">
	<caption>Tax Code</caption>
	<tr>
		<th class = "field">id</th>
		<th class = "field">code</th>
		<th class = "field">description</th>
	</tr>
<?php
$servername = "localhost:3306";
$username = "root";
$password = "";
$dbname = "TaxRates2015";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
     die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT * FROM TaxCode";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
     // output data of each row
	 $total = 0;
     while($row = $result->fetch_assoc()) {
        $id = $row["id"];
		$code = $row["code"];
		$description = $row["description"];
		echo "
		<tr>
			<td>$id</td>
			<td>$code</td>
			<td>$description</td>
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