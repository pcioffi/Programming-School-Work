<ol>
<?php
// FileName: ReadEmployee.php

$myfile = fopen("C:\data\Employee.csv", "r") or die("Unable to open file!");
// Output one line until end-of-file
include "PayCheck.php";

while(!feof($myfile)) {
	$row = fgets($myfile);
	$column = explode (",", $row);
	$hourlyWage = $column[2];
	$hoursWorked = $column[3];
	$fullName = $column[1] . ", " . $column[0];
  
	$paycheck = new PayCheck("S",$hourlyWage,$hoursWorked);
	$salary = $paycheck->getWeekSalary();
	$otHours = $paycheck->getOverTimeHours();
	$otPay = $paycheck->getOverTimePay();
	
	echo "<li>$fullName </br> Hourly Wage: $hourlyWage Hours Worked: $hoursWorked ";
	echo "</br> Salary: $salary </br> Overtime Hours: $otHours </br> Overtime Pay: $otPay</li>";
	//print_r($column);
	//echo "<hr/>";
}
fclose($myfile);
?>
</ol>