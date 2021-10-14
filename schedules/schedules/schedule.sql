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


-- Dumping database structure for schedules
CREATE DATABASE IF NOT EXISTS `schedules` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `schedules`;

-- Dumping structure for table schedules.schedule
CREATE TABLE IF NOT EXISTS `schedule` (
  `id` int NOT NULL AUTO_INCREMENT,
  `airline_name` varchar(200) DEFAULT NULL,
  `source` varchar(200) DEFAULT NULL,
  `destination` varchar(200) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table schedules.schedule: ~7 rows (approximately)
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` (`id`, `airline_name`, `source`, `destination`, `price`) VALUES
	(1, 'Air India', 'Delhi', 'Pune', '7999'),
	(2, 'Indigo', 'Amritsar', 'Mumbai', '4596'),
	(3, 'Air Aisa', 'Chennai', 'Kolkata', '7699'),
	(4, 'Jet Airways', 'Goa', 'Delhi', '8599'),
	(5, 'Indigo', 'Delhi', 'Pune', '3999'),
	(7, 'Vistara', 'Delhi', 'Pune', '5399'),
	(8, 'Air Canada', 'Delhi', 'Montreal', '120000');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
