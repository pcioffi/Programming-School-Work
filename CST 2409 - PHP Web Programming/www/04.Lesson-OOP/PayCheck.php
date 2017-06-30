<?php
	//FileName: PayCheck.php
	class PayCheck{
		private $hourlyWage = 0;
		private $hoursWorked = 0;
		private $overTimeHours = 0;
		
		public function __construct($pStatus,$pHourlyWages,$pHoursWorked){
			$this->hourlyWage = $pHourlyWages;
			$this->hoursWorked = $pHoursWorked;
		}
		
		public function getWeekSalary(){
			return ($this->hourlyWage * ($this->hoursWorked - $this->getOverTimeHours())) + $this->getOverTimePay();
		}
		
		public function getOverTimeHours(){
			if($this->hoursWorked > 40){
				$this->overTimeHours = $this->hoursWorked - 40;
			}
				return $this->overTimeHours;

			//return $this->hoursWorked > 40 ? $this->hoursWorked - 40 : 0;
		}
		
		public function getOverTimePay(){
			return $this->overTimeHours * $this->hourlyWage * 1.5;
			//return $this->getOverTimeHours() * $this->hourlyWage * 1.5;
		}
	}
	
	//test
	
	//$paycheck = new PayCheck("S",10,42);
	//$salary = $paycheck->getWeekSalary();
	//$otHours = $paycheck->getOverTimeHours();
	//$otPay = $paycheck->getOverTimePay();
	
	//echo "<br/> I am rich $salary over time hours is $otHours (with overtime pay of $otPay)";
?>