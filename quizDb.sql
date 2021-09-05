-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.34-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table quiz_db.question_master
CREATE TABLE IF NOT EXISTS `question_master` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `optiona` varchar(50) DEFAULT NULL,
  `optionb` varchar(50) DEFAULT NULL,
  `optionc` varchar(50) DEFAULT NULL,
  `optiond` varchar(50) DEFAULT NULL,
  `question_name` varchar(500) DEFAULT NULL,
  `correct_answer` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table quiz_db.question_master: ~5 rows (approximately)
/*!40000 ALTER TABLE `question_master` DISABLE KEYS */;
INSERT INTO `question_master` (`question_id`, `optiona`, `optionb`, `optionc`, `optiond`, `question_name`, `correct_answer`) VALUES
	(1, 'Kalpana Chawla', ' Sunita Williams', 'Koneru Humpy', 'None of the above', 'Who was the first Indian woman in Space?', 'a'),
	(2, 'Vikram Ambalal', 'Ravish Malhotra', 'Rakesh Sharma', 'Nagapathi Bhat', 'Who was the first Indian in space?', 'c'),
	(3, ' Junko Tabei', ' Reinhold Messner', ' Peter Habeler', 'Phu Dorji', 'Who was the first Man to Climb Mount Everest Without Oxygen?', 'd'),
	(4, 'Jahangir', 'Akbar', 'Imam Bukhari', 'Shah Jahan', 'Who built the Jama Masjid?', 'd'),
	(5, ' Bakim Chandra Chatterji', 'Rabindranath Tagore', 'Swami Vivekanand', 'None of the above', ' Who wrote the Indian National Anthem?', 'b');
/*!40000 ALTER TABLE `question_master` ENABLE KEYS */;

-- Dumping structure for table quiz_db.user_master
CREATE TABLE IF NOT EXISTS `user_master` (
  `registration_id` int(11) NOT NULL AUTO_INCREMENT,
  `highest_score` double DEFAULT NULL,
  `registration_mail` varchar(50) DEFAULT NULL,
  `registration_name` varchar(500) DEFAULT NULL,
  `registration_password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`registration_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table quiz_db.user_master: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_master` DISABLE KEYS */;
INSERT INTO `user_master` (`registration_id`, `highest_score`, `registration_mail`, `registration_name`, `registration_password`) VALUES
	(1, 60, 'siddhantk951@gmail.com', 'Sid', '8600804627'),
	(2, 40, 'prajakta@gmail.com', 'Prajakta', '9112398592'),
	(3, 80, 'john@gmail.com', 'John', '9856324101'),
	(4, 20, 'omkar12@gmail.com', 'Omkar', '9876543210'),
	(5, 20, 'shubham12@gmail.com', 'Shubham', '8545254120'),
	(6, 100, 'anagha@gmail.com', 'Angha', '9638527415'),
	(7, 60, 'chinmay@gmail.com', 'Chinmay', '9532484125'),
	(8, 40, 'neha@gmail.com', 'Neha', '8695742151'),
	(9, 40, 'prathmesh@gmail.com', 'Prathmesh', '9325846215'),
	(10, 80, 'manjiri@gmail.com', 'Manjiri', '9872654135');
/*!40000 ALTER TABLE `user_master` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
