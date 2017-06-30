<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>cioffi, pellegrino - final project</title>
<link rel="stylesheet" href="styles.css" type="text/css" />
</head>
<body>
	<div id="wrapper">
		<?php include "./include/header.php" ?>
		
		<div id="body" class="clear">
			<?php include "./include/leftNavBar-customer.php" ?>
			<?php 
				$whichPage = "";			
				
				$page['c1'] = "body-customer-r1.php";
				$page['c2'] = "body-customer-r2.php";
				$page['c3'] = "body-customer-r3.php";
				$page['c4'] = "body-customer-r4.php";
				$page['c5'] = "body-customer-r5.php";
				$page['c6'] = "body-customer-r6.php";
				$page['c7'] = "body-customer-r7.php";
				$page['c8'] = "body-customer-r8.php";
				$page['c9'] = "body-customer-r9.php";
				$page['c10'] = "body-customer-r10.php";				
				
				if  ( isset($_GET["page"]) ){
					$whichPage = $_GET["page"];
				}
			    else
				{
					$whichPage ="c1";
				}			
				
				$whichBody = $page[$whichPage];
				
				include "./include/$whichBody";
			?>
		</div>
	</div>
    <?php include "./include/footer.php" ?>
</body>
</html>