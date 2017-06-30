<?php
/* fileName: WhichPage.php */

class WhichPage {
    
	static $page = null;
	static $firstTime = true;
	
	static function getPage() {	
		
		if (self::$page == null){
			self::$page['c1'] = "body-employee-salary.php";
			self::$page['c2'] = "body-employee-salary-warning.php";
			self::$page['c3'] = "body-employee-salary-bars.php";
			self::$page['c4'] = "body-customer-r4.php";
			self::$page['c5'] = "body-customer-r5.php";
			self::$page['c6'] = "body-customer-r6.php";
			self::$page['c7'] = "body-customer-r7.php";
			self::$page['c8'] = "body-customer-r8.php";
			self::$page['c9'] = "body-customer-r9.php";
			self::$page['c10'] = "body-customer-r10.php";
		}
		
		
		$whichPage = "";
		
		if (isset($_GET["page"])){
			$whichPage = $_GET["page"];
		}
		else{
			$whichPage = "c1";
		}
		
		$whichBody = self::$page[$whichPage];
		
		return $whichBody;
	}
}
?>