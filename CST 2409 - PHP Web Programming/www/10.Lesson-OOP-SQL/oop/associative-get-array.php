<!-- file Name: associative-get-array.php -->

<?php
$input = $_GET;

$sql = "select c1, c2, c3, c4 from table where c1 = '_somevalue_' and c2 = '_s2_' and c3 = '_s3_'";

foreach($input as $key => $value) {
     echo "Key=" . $key . ", Value=" . $value;
     echo "<br>";
	 $sql = str_replace("_"."$key"."_",$value,$sql);
}

echo $sql;
?>