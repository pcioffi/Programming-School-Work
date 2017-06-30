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

	function get($pData, $returnData){
		
		if (isset($_GET[$pData])){
			$returnData = $_GET[$pData];
		}
		
		return $returnData;
	}
?>