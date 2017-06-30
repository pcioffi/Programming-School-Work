<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>(8)cioffi, pellegrino - final project</title>
		<link rel="stylesheet" href="styles.css" type="text/css" />
		<link rel="stylesheet" href="addon-styles.css" type="text/css" />
	</head>
	<body>
		<div id="wrapper">
			<?php include "./include/header.php" ?>
			
			<div id="body" class="clear">
				<?php include "./include/leftNavBar-customer.php" ?>
				<?php include "./include/WhichPage.php" ?>
				<?php
					$whichBody = WhichPage::getPage();
					include "./include/$whichBody";
				?>
			</div>
		</div>
		<?php include "./include/footer.php" ?>
	</body>
</html>