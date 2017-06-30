<!DOCTYPE html>
<!-- fileName: question3.php-->
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
	#numbers{
		text-align: right;
	}
	#black{
		background-color: black;
		color: white;
	}
</style>
<body>
<table class = "report">
	<caption>Tax Rates</caption>
	<tr>
		<th class = "field">id</th>
		<th class = "field">taxRate</th>
		<th class = "field">startSalary</th>
		<th class = "field">endSalary</th>
		<th class = "field">taxId</th>
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

$sql = 	"select ti.*, tc.code, tc.description
			from TaxableIncome ti
			inner join TaxCode tc
			on ti.taxId = tc.id
			order by taxRate;"		
;
$result = $conn->query($sql);

if ($result->num_rows > 0) {
     // output data of each row
	 $total = 0;
     while($row = $result->fetch_assoc()) {
        $id = $row["id"];
		$taxRate = $row["taxRate"];
		$startSalary = $row["startSalary"];
		$endSalary = $row["endSalary"];
		$taxID = $row["taxId"];
		$code = $row["code"];
		$description = $row["description"];
		
		if(isset($_GET["highlight"])){
			$get = $_GET["highlight"];
			
			if($get == $code){
				echo "<tr id = 'black'>";
				echo "<td>" . $id . " </td>";
				echo "<td id = 'numbers'>" . $taxRate . "</td>";
				echo "<td id = 'numbers'>" . $startSalary . "</td>";
				echo "<td id = 'numbers'>" . $endSalary . "</td>";
				echo "<td>" . $taxID . "</td>";
				echo "<td>" . $code . "</td>";
				echo "<td>" . $description . "</td>";
				echo "</tr>";
			}
			else{
				echo "<tr>";
				echo "<td>" . $id . " </td>";
				echo "<td id = 'numbers'>" . $taxRate . "</td>";
				echo "<td id = 'numbers'>" . $startSalary . "</td>";
				echo "<td id = 'numbers'>" . $endSalary . "</td>";
				echo "<td>" . $taxID . "</td>";
				echo "<td>" . $code . "</td>";
				echo "<td>" . $description . "</td>";
				echo "</tr>";
			}
		}
		else{
			echo "<tr>";
			echo "<td>" . $id . " </td>";
			echo "<td id = 'numbers'>" . $taxRate . "</td>";
			echo "<td id = 'numbers'>" . $startSalary . "</td>";
			echo "<td id = 'numbers'>" . $endSalary . "</td>";
			echo "<td>" . $taxID . "</td>";
			echo "<td>" . $code . "</td>";
			echo "<td>" . $description . "</td>";
			echo "</tr>";
		}
	}
} else {
     echo "0 results";
}

$conn->close();
?>
</table>

</body>
</html>