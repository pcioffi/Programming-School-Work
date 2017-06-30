<!-- fileName: ./include/body-customer-r1.php -->
<?php
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "exam1";

	// Create connection
	$conn = new mysqli($servername, $username, $password, $dbname);
	// Check connection
	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	} 
	
	$sql = "SELECT e.id, e.firstname, e.lastname, e.salary, et.description FROM employee e INNER JOIN employeetitle et ON e.titleid = et.id ORDER BY e.lastname";
	$result = $conn->query($sql);

?>


<div id="content" class="column-right">
	<h3>Extra Credit</h3>
	<table class = "report">
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
					$displayImage = $salary > 90000 ? "<div class = 'money'></div>" : "";
					$bars = 0;
					
					echo "<tr>";
					echo "<td>" . $row["id"]. " </td>";
					echo "<td>" . $row["firstname"]. "</td>";
					echo "<td>" . $row["lastname"]. "</td>";
					/*if($salary >= 90000){
						echo "<td>" . $row["salary"]. " <img width = 20px height = 20px src = './images/money.jpg' </td>";
					}
					else{
						echo "<td>" . $row["salary"]. " </td>";
					}*/
					
					echo "<td>" . $row["salary"];
					while($salary >= 50000){
						echo " " . "<div class = 'money'></div>";
						$salary -= 50000;
					}
					echo "</td>";
					
					echo "<td>" . $row["description"]. "</td>";
					echo "</tr>";
				}
			} 
			else {
				echo "0 results";
			}
			
			$conn->close();
		?>
	</table>
</div>