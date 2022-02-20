<?php

if($_SERVER['REQUEST_METHOD'] == "POST"){
		// Get data
		$Cardname  = isset($_POST['Cardname']) ? $_POST['Cardname'] : "";
		$Cardnum = isset($_POST['Cardnum']) ? $_POST['Cardnum'] : "";
		$phone = isset($_POST['phone']) ? $_POST['phone'] : "";
		$Address = isset($_POST['Address']) ? $_POST['Address'] : "";
		$Gender = isset($_POST['Gender']) ? $_POST['Gender'] : "";
		$roomtype = isset($_POST['roomtype']) ? $_POST['roomtype'] : "";
		$Checkin = isset($_POST['Checkin']) ? $_POST['Checkin'] : "";
		$editCheckout = isset($_POST['editCheckout']) ? $_POST['editCheckout'] : "";
		$roomnum = isset($_POST['roomnum']) ? $_POST['roomnum'] : "";
		
		$server_name = "localhost";
		$username = "root";
		$password = "";
		$dbname = "bookingapp";
		
		$response  = array();
		
		$conn = new mysqli($server_name, $username, $password, $dbname);
		if ($conn->connect_error) {
			die("Connection failed: " . $conn->connect_error);
		} 
		
		$sql = "INSERT INTO hoteluser values (NULL, '$Cardname' , '$Cardnum' , '$phone' , '$Address' , '$Checkin' , '$editCheckout' , '$roomnum' )";
		//$sql = "insert into hoteluser  values (NULL, '" . $Cardname . "','" . $Cardnum . "'," . $phone ."'," . $phone ."'," . $Gender ."'," . $roomtype ."'," . $Checkin ."'," . $editCheckout ."'," . $roomnum . ")";
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