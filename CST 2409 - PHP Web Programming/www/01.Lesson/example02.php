<!--
	fileName:example02.php
-->
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
	</style>
	
	<body>
		<h1>Example 2</h1>
		<div>
			<?php
				for($i = 0; $i <= 100; $i++){
					echo "<div id='d_$i' class='format'>$i</div>";
				}
			?>
		<div>
			
		<script>
			var x = document.getElementById("d_20");
			x.innerHTML = "test";
		</script>
	<body>
<html>