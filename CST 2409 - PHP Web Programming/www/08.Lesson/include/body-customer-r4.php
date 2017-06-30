<!-- fileName: ./include/body-customer-r3.php -->
<style>
	.focus{
		font-size: 120%;
		color: red;
		font-weight: bold;
	}
</style>

<?php
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "customerDB";

	// Create connection
	$conn = new mysqli($servername, $username, $password, $dbname);
	// Check connection
	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	} 
	
	$code = "a";
	if(isset($_GET["code"])){
		$code = $_GET["code"];
	}
	
	$sql = "SELECT id, firstname, lastname FROM Customer WHERE lastName || firstName LIKE '%$code%' ORDER BY lastname desc";
	$result = $conn->query($sql);

?>


<div id="content" class="column-right">
	<h3>Customer Report 4</h3>
	
	<?php
		for($i = 97; $i <= 122; $i++){
			$letter = chr($i);
			$highlight = $code == $letter ? "focus" : "";
			echo(" <a class = '$highlight' href='index.php?page=c4&code=$letter'>$letter</a>");
		}
	?>
	
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
					$firstName = $row["firstname"];
					$lastName = $row["lastname"];
					$ucode = strtoupper($code);
					$codeCompare = $code.localeCompare($firstName)
					
					if($codeCompare == 0)
						$focusFName = str_replace($code, "<span class = 'focus'>$code</span>", $firstName);
					else{
						$focusFName = str_replace($ucode, "<span class = 'focus'>$ucode</span>", $firstName);
					}
					
					$focusLName = str_replace($code, "<span class = 'focus'>$code</span>", $lastName);
					//$focusLName = str_replace($ucode, "<span class = 'focus'>$ucode</span>", $lastName);
					
					echo "<tr>";
					echo "<td>" . $row["id"]. " </td>";
					echo "<td>$focusFName</td>";
					echo "<td> $focusLName</td>";
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