<?php

	// FileName: Database.php
	class Database {
		
		private static function getQuery($pQuery){
			
			$xml=simplexml_load_file("./oop/Query.xml") 
			or die("Error: Cannot create object");

			foreach($xml->children() as $query) {					
				if ($query["name"] == $pQuery){
					return $query;
				}								
			}		
		}
		
		// Store database information
		public static function runSQL($databaseName,$pQueryName){
			
			$servername = "localhost";
			$username = "root";
			$password = "";
			$dbname = $databaseName;
			
			// Create connection
			$conn = new mysqli($servername, $username, $password, $dbname);
			// Check connection
			if ($conn->connect_error) {
				die("Connection failed: " . $conn->connect_error);
			}			
			$sql = self::getQuery($pQueryName);			
			$result = $conn->query($sql);			
			$dbInfo['result'] = $result;
			$dbInfo['connection'] = $conn;			
			return $dbInfo;
		}
		
		//input: represents the associative array
		//sql: represents the sql w/ parameters
		public static function getParameters($input, $sql){
			foreach($input as $key => $value){
				$sql = str_replace("_"."$key"."_",$value,$sql);
			}
			return $sql;
		}
		
		public static function runSQLP($databaseName,$pQueryName,$input){
			$servername = "localhost";
			$username = "root";
			$password = "";
			$dbname = $databaseName;
			
			// Create connection
			$conn = new mysqli($servername, $username, $password, $dbname);
			// Check connection
			if ($conn->connect_error) {
				die("Connection failed: " . $conn->connect_error);
			}			
			$sql = self::getQuery($pQueryName);			
			$sql = self::getParameters($input, $sql);
			
			$result = $conn->query($sql);			
			$dbInfo['result'] = $result;
			$dbInfo['connection'] = $conn;			
			return $dbInfo;
		}
	}		
	//$r      = Database::runSQL("exam1","q1" );	
	//print_r($r);
	
?>