<!DOCTYPE html>
<!-- fileName: template.php-->
<html>
<style>
	table.report{
		border: solid 1px black;
	}
	table.report td, table.report th{
		border: solid 1px black;
		font-family: verdana;
		font-size: 10pt;
		padding-left: 2px;
	}
	table.report th{
		background-color: silver;
	}
</style>
<body>
	<table border = '1'>
		<caption>
			CST2409 - Cioffi, Pellegrino
		</caption>
		<tr>
			<td valign = "top">
				Menu
				<ol>
					<li> <a href = "template.php?whichMenu=1"> products </a> </li>
					<li> <a href = "template.php?whichMenu=2"> creditLimit </a> </li>
					<li> <a href = "template.php?whichMenu=3"> SalesPerson </a> </li>
				</ol>
			</td>
			<td>
				<?php
					//isset()
					$menuOption = $_GET["whichMenu"];
					$whichPage = "creditLimit.php";
					if($menuOption == 1){
						$whichPage = "productsBought.php";
					}
					elseif($menuOption == 2){
						$whichPage = "creditLimit.php";
					}
					elseif($menuOption == 3){
						$whichPage = "salesPerson.php";
					}
				include $whichPage;
				?>
			</td>
		</tr>
	</table>
</body>
</html>