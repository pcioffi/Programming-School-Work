
<?php
// FileName: ReadBook.php;
$xml=simplexml_load_file("Query.xml") or die("Error: Cannot create object");

foreach($xml->children() as $query) {	
    echo $query;  
	echo " ";
	echo $query["name"];   
	echo "<hr />";
}


















?> 