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


-- Dumping database structure for airlines
CREATE DATABASE IF NOT EXISTS `airlines` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `airlines`;

-- Dumping structure for table airlines.airline
CREATE TABLE IF NOT EXISTS `airline` (
  `id` int NOT NULL AUTO_INCREMENT,
  `airline_name` varchar(50) DEFAULT NULL,
  `contact_number` varchar(13) DEFAULT NULL,
  `contactAddress` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table airlines.airline: ~7 rows (approximately)
/*!40000 ALTER TABLE `airline` DISABLE KEYS */;
INSERT INTO `airline` (`id`, `airline_name`, `contact_number`, `contactAddress`) VALUES
	(1, 'Jet Airways', '741258963', 'Bangalore'),
	(2, 'Air India', '8523654789', 'New Delhi'),
	(6, 'SpiceJet', '7852365478', 'Delhi'),
	(15, 'Vistara', '9632587412', 'Bangalore'),
	(17, 'Air Canada', '+196523658963', 'Ontario'),
	(18, 'kingfisher', '8563254147', 'Bangalore'),
	(19, 'Emirates', '98563525874', 'Dubai');
/*!40000 ALTER TABLE `airline` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
