<?php
	$firstname = "firstname";
	$lastname = "lastname";
	$fullname = "Cioffi, Pellegrino";
	$email = "ZeroVirusEXE@gmail.com";
	
	if(isset($_GET["mode"])){
		$get = $_GET["mode"];
		
		if($get == "fullname"){
			echo $fullname . "<br/>";
		} 
		else if($get == "email"){
			echo $email . "<br/>";
		}
	}
	else {
		echo $lastname . ", " . $firstname . "<br/>";
	}
	
?>