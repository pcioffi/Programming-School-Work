<!-- fileName: ./include/body-customer-r1.php -->

<?php
$dbInfo = Database::runSQL("exam1","q1");
$result = $dbInfo["result"];
$conn = $dbInfo["connection"];
?> 
<div id="content" class="column-right">
<h3>Employee and Salary (Warning)</h3>	
<table class="report">
	<tr>
		<th>ID</th>
		<th>First Name</th>
		<th>Last Name</th>		
		<th>Salary</th>
		<th>Description</th>
	</tr>	
	<?php
	
		if ($result->num_rows > 0) {
		// output data of each row
			while($row = $result->fetch_assoc()) {
				$salary = $row["salary"];
				$displayImage = $salary > 90000
				              ? "<div class='warning'></div>"
							  : "";							  
				echo "<tr>";
				echo "<td>" . $row["id"]. " </td>" ;
				echo "<td>" . $row["firstName"]. "</td> ";
				echo "<td>" . $row["lastName"]. "</td>";
				echo "<td>" . $row["salary"]. " $displayImage </td>";
				echo "<td>" . $row["description"]. "</td>";
				echo "</tr>";
			}
		} else {
			echo "0 results";
		}		
		$conn->close();	
	?>
</table>
</div>