<html>
	<body>
		<!-- fileName PayRoll02.php -->
		<h1>Pay Roll Two</h1>
		<form>
			<label>hourly wage:</label> <input type="text" name="txtHourlyWage" id="txtHourlyWage"/>
		
			<label>hours worked:</label> <input type="text" name="txtHoursWorked" id="txtHoursWorked"/>
		
			<label> status: </label>
			<select name="selStatus" id="selStatus">
				<option value="S"> Single </option>
				<option value="M"> Married </option>
			</select>

			<input type="submit" value="process" />	
			<?php
				function getMyMoney($phourlyWage, $phoursWorked, $pstatus){
					$payCheck = $phourlyWage * $phoursWorked;
					
					$cPayCheck["gross"] = $payCheck;
					
					if($pstatus == "S"){
						$cPayCheck["tax"] = $payCheck * 0.3;
					}
					elseif($pstatus == "M"){
						$cPayCheck["tax"] = $payCheck * 0.25;
					}
					
					$cPayCheck["netpay"] = $payCheck - $cPayCheck["tax"];
					
					return $cPayCheck;
				}
			?>
			
			<hr />
			<?php
				$hourlyWage = 0;
				$hoursWorked = 0;
				$status = "S";
				
				if (isset($_GET["txtHourlyWage"])){
					$hourlyWage = $_GET["txtHourlyWage"];
				}
				
				if (isset($_GET["txtHoursWorked"])){
					$hoursWorked = $_GET["txtHoursWorked"];
				}
				if (isset($_GET["selStatus"])){
					$status = $_GET["selStatus"];
				}				

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