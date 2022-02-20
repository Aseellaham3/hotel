-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 20, 2022 at 10:52 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `roomspage`
--

CREATE TABLE `roomspage` (
  `roomType` varchar(20) NOT NULL,
  `price` int(5) NOT NULL,
  `imageID` int(20) NOT NULL,
  `roomNum` int(4) NOT NULL,
  `feature` varchar(100) NOT NULL,
  `floor` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roomspage`
--

INSERT INTO `roomspage` (`roomType`, `price`, `imageID`, `roomNum`, `feature`, `floor`) VALUES
('Single room', 200, 0, 1, ' single bed , with AC , Street view , WiFi , with veranda, TV', 3),
('Single room', 220, 0, 2, ' single bed , with AC , beach view , WiFi , with veranda, TV', 10),
('Single room', 180, 0, 3, ' single bed , without AC , Street view , WiFi , with veranda, TV', 5),
('Single room', 180, 0, 4, ' single bed , with AC , Street view , WiFi , without veranda, TV', 7),
('Double room', 300, 0, 5, ' double bed , with AC , pool view , WiFi , with veranda, TV', 8),
('Double room', 270, 0, 6, ' double bed , with AC , street view , WiFi , with veranda, TV', 2),
('Double room', 250, 0, 7, ' double bed , without AC , pool view , WiFi , with veranda, TV', 6),
('Double room', 330, 0, 8, ' double bed , with AC , beach view , WiFi , with veranda, TV', 10),
('Twin room', 350, 0, 9, 'two bed , with AC , Street view , WiFi , with veranda, TV', 5),
('Twin room', 370, 0, 10, 'two bed , with AC , pool view , WiFi , with veranda, TV', 9),
('Twin room', 330, 0, 11, 'two bed , without AC , Street view , WiFi , with veranda, TV', 3),
('Suite room', 500, 0, 12, 'room with double bed ,room with two bed , living room, with AC , pool view , WiFi , with veranda ,TV', 12),
('Suite room', 530, 0, 13, 'room with double bed ,room with two bed , living room, with AC , pool view , WiFi , with veranda ,TV', 12),
('Suite room', 560, 0, 14, 'room with double bed ,room with  two bed , living room, with AC , beach view , WiFi , with veranda ,', 12);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `roomspage`
--
ALTER TABLE `roomspage`
  ADD PRIMARY KEY (`roomNum`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `roomspage`
--
ALTER TABLE `roomspage`
  MODIFY `roomNum` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
