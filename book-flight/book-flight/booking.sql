-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.19 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for booking
CREATE DATABASE IF NOT EXISTS `booking` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `booking`;

-- Dumping structure for table booking.booking
CREATE TABLE IF NOT EXISTS `booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `source` varchar(200) DEFAULT NULL,
  `destination` varchar(200) DEFAULT NULL,
  `airline_name` varchar(200) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table booking.booking: ~9 rows (approximately)
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` (`id`, `source`, `destination`, `airline_name`, `price`) VALUES
	(1, 'Delhi', 'Pune', 'Air India', '5000'),
	(7, 'Delhi', 'Pune', 'Air India', '6900'),
	(12, 'Amritsar', 'Mumbai', 'Indigo', '8420'),
	(15, 'Chennai', 'Kolkata', 'Air Aisa', '7412'),
	(16, 'Delhi', 'Pune', 'Indigo', '3256'),
	(18, 'Delhi', 'Pune', 'Air India', '9512'),
	(19, 'Delhi', 'Pune', 'Air India', '8520'),
	(20, 'Delhi', 'Montreal', 'Air Canada', '120000'),
	(22, 'Delhi', 'Pune', 'Indigo', '3999');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
