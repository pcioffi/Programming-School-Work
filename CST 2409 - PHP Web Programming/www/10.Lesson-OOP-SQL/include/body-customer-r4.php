<!-- fileName: ./include/body-customer-r1.php -->
<style>
	.focus{
		font-size: 120%;
		color: red;
		font-weight:bold;		
	}

</style>

<?php
	$code="a";
	$hCode = array("code"=>"a");
	if( isset($_GET["code"]) ){
		$code = $_GET["code"];
		$hCode = $_GET;
	}

	$dbInfo = Database::runSQLP("customerDB","q4",$hCode);
	$result = $dbInfo["result"];
	$conn = $dbInfo["connection"];
?> 

<div id="content" class="column-right">
<h3>Customer Report 4</h3>	

<?php	
	for($i = 97; $i <= 122; $i++){
		$letter = chr($i);
		$highlight = $code == $letter ? "focus":"";		
		echo(" <a class='$highlight' href='index.php?page=c4&code=$letter'>$letter</a>"); 	
	}
?>
<table>
	<tr>
		<th>ID</th>
		<th>first name</th>
		<th>last Name</th>
	</tr>	
	<?php	
		if ($result->num_rows > 0) {	
			while($row = $result->fetch_assoc()) {				
				
				$firstName = $row["firstname"];
				$lastName = $row["lastname"];
				$focusFname =  str_replace($code,"<span class='focus'>$code</span>",$firstName);				
				$ucode = strtoupper($code);
				$focusFname =  str_replace($ucode,"<span class='focus'>$ucode</span>",$firstName);
				
				$focusLname =  str_ireplace($code,"<span class='focus'>$code</span>",$lastName);
											
				echo "<tr>";
				echo "<td>" . $row["id"]." </td>" ;
				echo "<td>$focusFname</td>";
				echo "<td>$focusLname</td> ";
				echo "</tr>";
			}
		} else {
			echo "0 results";
		}		
		$conn->close();	
	?>
</table>
</div>