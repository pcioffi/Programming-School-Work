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
		<h1>Example 3</h1>
		<div>
			<?php
				for($i = 0; $i <= 100; $i++){
					$highLight = "";
					if($i % 2 == 0){
						$highLight = "even";
					}
					echo "<div id='d_$i' class='format $highLight'>$i</div>";
				}
			?>
		<div>
			
		<script>
			var x = document.getElementById("d_20");
			x.innerHTML = "test";
		</script>
	<body>
<html>