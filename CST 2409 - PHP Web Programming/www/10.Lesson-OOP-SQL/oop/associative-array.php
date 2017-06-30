<!-- file Name: associative-array.php -->

<?php
$age = array("test"=>"100", "Peter"=>"35", "Ben"=>"37", "David"=>"42", "Joe"=>"43");

foreach($age as $key => $value) {
     echo "Key=" . $key . ", Value=" . $value;
     echo "<br>";
}
?>