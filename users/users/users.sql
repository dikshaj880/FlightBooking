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


-- Dumping database structure for users
CREATE DATABASE IF NOT EXISTS `users` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `users`;

-- Dumping structure for table users.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table users.roles: ~2 rows (approximately)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `name`) VALUES
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Dumping structure for table users.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table users.user: ~11 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `email`, `password`, `phone`, `username`) VALUES
	(1, 'test123@gmail.com', '$2a$10$VrepnvXeBJaZZo/pHhgQ1.hNT4b/i/nrequlz/CosqsuZZX/vyJIe', '123', 'test'),
	(2, 'admin@gmail.com', '$2a$10$rJKUTMu4s.VkaAS6vJTrqeR/xEFKGDzocRKoec/oKB9NYgZ.x6BlC', NULL, 'Admin'),
	(3, 'demo1@gmail.com', '$2a$10$ys7MoJustNCOCp.NkTHOWuYIIlyjrtBUmvU6xSle9Audihwdba.72', NULL, 'Demo1'),
	(4, 'demo2@gmail.com', '$2a$10$PI9ocpC/eWefhZklrCpJIOsJrw5oYDo4I71aJqpve1TYOh8UzIdju', NULL, 'Demo2'),
	(5, 'gagan@gmail.com', '$2a$10$F2/xlRDwtk7LRPX1BTSg7uw5Er171HMTM9.36pPeGpzG/SUDXyOuy', NULL, NULL),
	(6, 'test1@gmail.com', '$2a$10$.BEH5xFYE3LSLs2m5OxcQe2i34yPxGsdpc5RtgkyL1SGFLnA1.1Ou', NULL, 'test1'),
	(7, 'test2@gmail.com', '$2a$10$syr9TbM93IVC3Fa/BaxX/eI6Fs7DSvNpvgMrS6rbMKungga8lg2KC', NULL, 'test2'),
	(8, 'test3@gmail.com', '$2a$10$4ZfTfAUEUOK8FHIxzUPvMObEvmO59F.cyvX.qEBV6ktLqNIjdyqY2', NULL, 'test3'),
	(9, 'gagan1@gmail.com', '$2a$10$/tG32TsrFM2rH7CTKUMi/uHUWTXN4ZJVt4WyxR8Hx7pBGpIW5pl1a', NULL, 'gagan'),
	(10, 'testing@gmail.com', '$2a$10$Q3hv1GCOGriY.Q.SW2PxR.VRmrIEloTBbQ.mQRfcVOrNf1WZ/oenC', NULL, 'testing'),
	(11, 'arun@gmail.com', '$2a$10$GHu7iyasASwE..Z.IL/.6uFjeffziKhILqX2ZOWTeKpvmwslIIYzu', NULL, 'arun');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table users.users_roles
CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_id` bigint NOT NULL,
  `roles_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`roles_id`),
  KEY `FKa62j07k5mhgifpp955h37ponj` (`roles_id`),
  CONSTRAINT `FKa62j07k5mhgifpp955h37ponj` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table users.users_roles: ~10 rows (approximately)
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` (`user_id`, `roles_id`) VALUES
	(2, 1),
	(3, 2),
	(4, 2),
	(5, 2),
	(6, 2),
	(7, 2),
	(8, 2),
	(9, 2),
	(10, 2),
	(11, 2);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
