<html>
	<body>
		<h1>Pay Roll</h1>
		<form>
			<label>hourly wage:</label> <input type="text" name="txtHourlyWage" />
		
			<label>hours worked:</label> <input type="text" name="txtHoursWorked" />
		
			<label> status: </label>
			<select name="selStatus">
				<option value="S"> Single </option>
				<option value="M"> Married </option>
			</select>

			<input type="submit" value="process" />	
			<?php
				function getMyMoney($hourlyWage, $hoursWorked){
					$payCheck = $hourlyWage * $hoursWorked;
					return $payCheck;
				}
			?>
			
			<hr />
			<?php
				$hourlyWage = 0;
				$hoursWorked = 0;
				
				if (isset($_GET["txtHourlyWage"])){
					$hourlyWage = $_GET["txtHourlyWage"];
				}
				
				if (isset($_GET["txtHoursWorked"])){
					$hoursWorked = $_GET["txtHoursWorked"];
				}				

				$grossSalary = 0;
				$grossSalary = getMyMoney($hourlyWage,$hoursWorked);
			?>
			Your pay check is <?php echo $grossSalary?>
		</form>
	</body>
</html>