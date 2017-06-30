<?php include "./oop/Database.php" ?>
<?php
$dbInfo = Database::runSQL("exam1","q1");
$result = $dbInfo["result"];
$conn = $dbInfo["result"];




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



?> 
