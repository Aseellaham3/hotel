<?php

if($_SERVER['REQUEST_METHOD'] == "POST"){
		// Get data
		$Cardname  = isset($_POST['Cardname']) ? $_POST['Cardname'] : "";
		$Cardnum = isset($_POST['Cardnum']) ? $_POST['Cardnum'] : "";
		$phone = isset($_POST['phone']) ? $_POST['phone'] : "";
		$Address = isset($_POST['Address']) ? $_POST['Address'] : "";
		$Gender = isset($_POST['Gender']) ? $_POST['Gender'] : "";
		
		
		$server_name = "localhost";
		$username = "root";
		$password = "";
		$dbname = "bookingapp";
		
		$response  = array();
		
		$conn = new mysqli($server_name, $username, $password, $dbname);
		if ($conn->connect_error) {
			die("Connection failed: " . $conn->connect_error);
		} 
		//$sql = "insert into customer_info values (NULL, '" . $Cardname . "','" . $Cardnum . "'," . $phone . ")";
		
		
		$sql = "INSERT INTO customer_info  values(NULL, '$Cardname' , '$Cardnum' , '$phone' , '$Address' )";
		if ($conn->query($sql) === TRUE) {
			$response['error'] = false;
			$response['message'] = "user information added successfully!";
		} else {
			$response['error'] = true;
			$response['message'] = "Error, " . $conn->error;
			
		}
		echo json_encode($response);

		$conn->close();
	
	}



?>