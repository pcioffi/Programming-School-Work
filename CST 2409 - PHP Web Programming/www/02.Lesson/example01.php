<html>
	<style>
		.format{
			background-color:silver;
			border:1px solid black;
			width:100px;
			height:60px;
			text-align:center;
			padding-top:30px;
			font-family:verdana;
			display:inline-block;
			margin:1px;
		}
		.even{
			color:red;
		}
	</style>
	
	<body>
		<h1>Example 1, Lesson 2</h1>
		<div>
			<?php
				$limit = 10;
				$multiple = 1;
				
				if ( isset($_GET["countto"]) ){
					$limit = $_GET["countto"];
				}
				
				if ( isset ($_GET["multiple"]) ){
					$multiple = $_GET["multiple"];
				}
				
				$m = 0;
				$i = 0;
				while($i <= $limit){
					$highLight = "";
					if($i % 2 == 0){
						$highLight = "even";
					}
					$m = $i * $multiple;
					if ($m > $limit){
						break;
					}
					
					echo "<div id='d_$i' class='format $highLight'>$m</div>";
					$i++;
				}
			?>
		<div>
			
		<!--
			var x = document.querySelectorAll("div.format.even")
			var length = x.length;
			
			for(i = 0; i < length; i++){
				x[i].innerHTML += "e";
			}
		-->
	<body>
<html>