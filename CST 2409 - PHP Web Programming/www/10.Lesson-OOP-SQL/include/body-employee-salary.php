<!-- fileName: ./include/body-customer-r1.php -->
<?php

$sql = "select 
          e.id
		, e.firstName
		, e.lastName
		, e.salary
		, et.description
	from Employee e
	inner join EmployeeTitle et
	on e.titleId = et.id
	order by e.id ";

$result = Database::runSQL("exam1",$sql);

?> 
<div id="content" class="column-right">
<h3>Employee and Salary</h3>	
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
				              ? "<div class='money'></div>"
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