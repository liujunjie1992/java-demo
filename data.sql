-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.11-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema test
--

CREATE DATABASE IF NOT EXISTS test;
USE test;

--
-- Temporary table structure for view `sq`
--
DROP TABLE IF EXISTS `sq`;
DROP VIEW IF EXISTS `sq`;

--
-- Definition of table `resume`
--

DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `resume_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` int(10) unsigned NOT NULL,
  PRIMARY KEY (`resume_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `resume`
--

/*!40000 ALTER TABLE `resume` DISABLE KEYS */;
INSERT INTO `resume` (`resume_id`,`name`,`age`) VALUES 
 (1,'lisi',12),
 (2,'wangwu',13),
 (3,'zhaosi',14),
 (4,'admin_1489238158233',95),
 (11,'admin_1489239140222',40),
 (12,'admin_1489239193290',33),
 (13,'admin_1489239590156',88);
/*!40000 ALTER TABLE `resume` ENABLE KEYS */;


--
-- Definition of table `work_exp`
--

DROP TABLE IF EXISTS `work_exp`;
CREATE TABLE `work_exp` (
  `work_exp_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `resume_id` int(10) unsigned NOT NULL,
  `resp_desc` varchar(255) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  PRIMARY KEY (`work_exp_id`) USING BTREE,
  KEY `FK_work_exp_1` (`resume_id`) USING BTREE,
  CONSTRAINT `resume_id_fk` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`resume_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `work_exp`
--

/*!40000 ALTER TABLE `work_exp` DISABLE KEYS */;
INSERT INTO `work_exp` (`work_exp_id`,`resume_id`,`resp_desc`,`start_date`,`end_date`) VALUES 
 (1,11,'desc.........................','2017-03-11 21:32:20','2017-03-11 21:32:20'),
 (2,12,'desc.........................','2017-03-11 21:33:13','2017-03-11 21:33:13'),
 (3,13,'desc.........................','2017-03-11 21:39:50','2017-03-11 21:39:50'),
 (4,11,'的十分大师傅','2017-03-11 21:32:20','2017-03-11 21:32:20');
/*!40000 ALTER TABLE `work_exp` ENABLE KEYS */;


--
-- Definition of view `sq`
--

DROP TABLE IF EXISTS `sq`;
DROP VIEW IF EXISTS `sq`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sq` AS select `resume`.`id` AS `id`,`resume`.`name` AS `name`,`resume`.`age` AS `age` from `resume`;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
