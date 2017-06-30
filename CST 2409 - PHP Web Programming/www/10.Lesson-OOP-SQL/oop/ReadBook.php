
<?php
// FileName: ReadBook.php;
$xml=simplexml_load_file("Books.xml") or die("Error: Cannot create object");
echo $xml->book[0]->title . "<br>";
echo $xml->book[1]->title . "<br>";

$age = array();

foreach($xml->children() as $books) {
	print_r($books);
    echo $books->title['lang'];
	$data = $books->title['lang'];
	$age[] = array($data => $data);
    echo "<hr>";
}

print_r($age);
















?> 