<?php

	
	if($_SERVER['REQUEST_METHOD'] == "POST"){
		// Get data
		$Checkin = isset($_POST['Checkin']) ? $_POST['Checkin'] : "";
		$Checkout = isset($_POST['Checkout']) ? $_POST['Checkout'] : "";
		$roomnum = isset($_POST['roomnum']) ? $_POST['roomnum'] : "";
		$roomtype = isset($_POST['roomtype']) ? $_POST['roomtype'] : "";
		
		

		$server_name = "localhost";
		$username = "root";
		$password = "";
		$dbname = "bookingapp";
		
		$response  = array();
		
		$conn = new mysqli($server_name, $username, $password, $dbname);
		if ($conn->connect_error) {
			die("Connection failed: " . $conn->connect_error);
		} 
		$sql = "INSERT INTO Room_info values (NULL,'$Checkin' , '$Checkout' , '$roomnum' )";
			if ($conn->query($sql) === TRUE) {
			$response['error'] = false;
			$response['message'] = " successfully booking information !";
		} else {
			$response['error'] = true;
			$response['message'] = "Error, " . $conn->error;
			
		}
		echo json_encode($response);

		$conn->close();
	
	}


?>