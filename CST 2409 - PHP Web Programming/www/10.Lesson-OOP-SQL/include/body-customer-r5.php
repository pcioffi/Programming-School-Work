<!-- fileName: ./include/body-customer-r5.php -->
<?php
	$city = "Brooklyn";
	if (isset($_GET["city"])){
		$city = $_GET["city"];
	}
?>

<a href="index.php?page=c5&city=Bronx">Bronx</a> |
<a href="index.php?page=c5&city=Queens">Queens</a> |
<a href="index.php?page=c5&city=Brooklyn">Brooklyn</a> |
<a href="index.php?page=c5&city=LIC">LIC</a>

<!--
	Display id, lastname, firstname, city, salary
-->

<div id="content" class="column-right">
	<h3>Display <%= $city %> </h3>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<tr>
			<td>1</td>
			<td>John Smith</td>
			<td>28</td>

		</tr>
		<tr>
			<td>2</td>
			<td>Fred James</td>
			<td>49</td>
		</tr>
		<tr>
			<td>3</td>
			<td>Rachel Johnson</td>
			<td>19</td>
		</tr>

		<tr>
			<td>1</td>
			<td>John Smith</td>
			<td>28</td>

		</tr>
		<tr>
			<td>2</td>
			<td>Fred James</td>
			<td>49</td>
		</tr>
		<tr>
			<td>3</td>
			<td>Rachel Johnson</td>
			<td>19</td>
		</tr>
		
		<tr>
			<td>1</td>
			<td>John Smith</td>
			<td>28</td>

		</tr>
		<tr>
			<td>2</td>
			<td>Fred James</td>
			<td>49</td>
		</tr>
		<tr>
			<td>3</td>
			<td>Rachel Johnson</td>
			<td>19</td>
		</tr>
		
		<tr>
			<td>1</td>
			<td>John Smith</td>
			<td>28</td>

		</tr>
		<tr>
			<td>2</td>
			<td>Fred James</td>
			<td>49</td>
		</tr>
		<tr>
			<td>3</td>
			<td>Rachel Johnson</td>
			<td>19</td>
		</tr>
		
		<tr>
			<td>1</td>
			<td>John Smith</td>
			<td>28</td>

		</tr>
		<tr>
			<td>2</td>
			<td>Fred James</td>
			<td>49</td>
		</tr>
		<tr>
			<td>3</td>
			<td>Rachel Johnson</td>
			<td>19</td>
		</tr>
	</table>
</div>