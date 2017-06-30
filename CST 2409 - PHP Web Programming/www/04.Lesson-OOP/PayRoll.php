<html>
	<body>
		<!-- fileName PayRoll.php -->
		<h1 style="color:red;">Pay Roll</h1>
		<form>
			<label>hourly wage:</label> <input type="text" name="txtHourlyWage" id="txtHourlyWage"/>
		
			<label>hours worked:</label> <input type="text" name="txtHoursWorked" id="txtHoursWorked"/>
		
			<label> status: </label>
			<select name="selStatus" id="selStatus">
				<option value="S"> Single </option>
				<option value="M"> Married </option>
			</select>

			<input type="submit" value="process" />	
			
			<hr />
			<?php
				include "globalFunction.php";
				$hourlyWage = 0;
				$hoursWorked = 0;
				$status = "S";
				
				$hourlyWage = get("txtHourlyWage", 0);
				$hoursWorked = get("txtHoursWorked", 0);
				$status = get("selStatus", "S");	

				$grossSalary = 0;
				$grossSalary = getMyMoney($hourlyWage,$hoursWorked, $status);
			?>
			Your pay check is: <?php echo $grossSalary["gross"]; ?> <br/>
			Your tax is: <?php echo $grossSalary["tax"]; ?> <br/>
			Your net pay check is: <?php echo $grossSalary["netpay"]; ?>
		</form>
		
		<script>
			var hourlyWage = document.getElementById("txtHourlyWage");
			hourlyWage.value = <?php echo $hourlyWage ?>;
			
			var hoursWorked = document.getElementById("txtHoursWorked");
			hoursWorked.value = <?php echo $hoursWorked ?>;
			
			var xstatus = document.getElementById("selStatus");
			xstatus.value = "<?php echo $status ?>";
		</script>
	</body>
</html>