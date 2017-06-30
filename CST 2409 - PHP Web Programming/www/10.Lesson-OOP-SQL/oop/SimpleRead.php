<?php
// FileName: SimpleRead.php
$xml=simplexml_load_file("note.xml") 
	or die("Error: Cannot create object");

	$to = $xml->to;
	$from = $xml->from;
	echo $to ;
	echo "<br />from $from";
?> 