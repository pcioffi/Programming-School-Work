<!-- fileName: ./include/body-customer-r1.php -->



<?php

$sql = "SELECT id, firstname, lastname 
		FROM Customer
		Where firstName like '%a%' or lastName like '%a%'
		order by lastname desc";
		
$result = Database::runSQL("customerDB",$sql);

?> 

<div id="content" class="column-right">
<h3>Customer Report 3</h3>	
<table>
	<tr>
		<th>ID</th>
		<th>fName</th>
		<th>lName</th>
	</tr>	
	<?php
	
		if ($result->num_rows > 0) {
		// output data of each row
			while($row = $result->fetch_assoc()) {
				echo "<tr>";
				echo "<td>" . $row["id"]. " </td>" ;
				echo "<td>" . $row["firstname"]. "</td> ";
				echo "<td>" . $row["lastname"]. "</td>";
				echo "</tr>";
			}
		} else {
			echo "0 results";
		}
		
		$conn->close();
		
	
	?>
	
	<tr>
		<td>1</td>
		<td>John Smith</td>
		<td>28</td>
	</tr>
	<tr>
		<td>2</td>
		<td>Fred James</td>
		<td>49</td>
	</tr>
	<tr>
		<td>3</td>
		<td>Rachel Johnson</td>
		<td>19</td>
	</tr>
	<tr>
		<td>1</td>
		<td>John Smith</td>
		<td>28</td>

	</tr>
	<tr>
		<td>2</td>
		<td>Fred James</td>
		<td>49</td>
	</tr>
	<tr>
		<td>3</td>
		<td>Rachel Johnson</td>
		<td>19</td>
	</tr>
	<tr>
		<td>1</td>
		<td>John Smith</td>
		<td>28</td>

	</tr>
	<tr>
		<td>2</td>
		<td>Fred James</td>
		<td>49</td>
	</tr>
	<tr>
		<td>3</td>
		<td>Rachel Johnson</td>
		<td>19</td>
	</tr>
	<tr>
		<td>1</td>
		<td>John Smith</td>
		<td>28</td>

	</tr>
	<tr>
		<td>2</td>
		<td>Fred James</td>
		<td>49</td>
	</tr>
	<tr>
		<td>3</td>
		<td>Rachel Johnson</td>
		<td>19</td>
	</tr>
	<tr>
		<td>1</td>
		<td>John Smith</td>
		<td>28</td>

	</tr>
	<tr>
		<td>2</td>
		<td>Fred James</td>
		<td>49</td>
	</tr>
	<tr>
		<td>3</td>
		<td>Rachel Johnson</td>
		<td>19</td>
	</tr>
	<tr>
		<td>1</td>
		<td>John Smith</td>
		<td>28</td>

	</tr>
	<tr>
		<td>2</td>
		<td>Fred James</td>
		<td>49</td>
	</tr>
	<tr>
		<td>3</td>
		<td>Rachel Johnson</td>
		<td>19</td>
	</tr>

</table>
</div>