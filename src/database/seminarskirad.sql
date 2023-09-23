/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 10.4.27-MariaDB : Database - seminarskirad
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarskirad` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `seminarskirad`;

/*Table structure for table `odgovor` */

DROP TABLE IF EXISTS `odgovor`;

CREATE TABLE `odgovor` (
  `odgovorId` int(11) NOT NULL,
  `sadrzaj` varchar(100) NOT NULL,
  `resenje` tinyint(1) NOT NULL,
  `pitanjeId` int(11) NOT NULL,
  PRIMARY KEY (`odgovorId`),
  KEY `pitanje_foreignkey` (`pitanjeId`),
  CONSTRAINT `pitanje_foreignkey` FOREIGN KEY (`pitanjeId`) REFERENCES `pitanje` (`pitanjeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `odgovor` */

insert  into `odgovor`(`odgovorId`,`sadrzaj`,`resenje`,`pitanjeId`) values 
(1,'Jeste',1,1),
(2,'Nije',0,1),
(3,'Klasa',1,2),
(4,'Interfejs',1,2),
(5,'Proceduralne osobine',0,2),
(6,'Apstrakcija',1,2),
(7,'Republika',1,3),
(8,'Monarhija',0,3),
(9,'Knezevina',1,3),
(10,'Albanija',0,4),
(11,'Bugarska',1,4),
(12,'Madjarska',1,4),
(13,'Grcka',0,4);

/*Table structure for table `pitanje` */

DROP TABLE IF EXISTS `pitanje`;

CREATE TABLE `pitanje` (
  `pitanjeId` int(11) NOT NULL,
  `sadrzaj` varchar(100) NOT NULL,
  PRIMARY KEY (`pitanjeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `pitanje` */

insert  into `pitanje`(`pitanjeId`,`sadrzaj`) values 
(1,'Da li je Java objektno orijentisan programski jezik?'),
(2,'Koji od navedenih pojmova predstavljaju pojmove objektno orijentisanog jezika?'),
(3,'Da li je Srbija?'),
(4,'Sa kojim drzavama se granici Srbija?');

/*Table structure for table `pitanjetest` */

DROP TABLE IF EXISTS `pitanjetest`;

CREATE TABLE `pitanjetest` (
  `pitanjeId` int(11) NOT NULL,
  `testId` int(11) NOT NULL,
  `brojPoena` int(11) NOT NULL,
  PRIMARY KEY (`pitanjeId`,`testId`),
  KEY `test_fk` (`testId`),
  CONSTRAINT `pitanje_fk` FOREIGN KEY (`pitanjeId`) REFERENCES `pitanje` (`pitanjeId`),
  CONSTRAINT `test_fk` FOREIGN KEY (`testId`) REFERENCES `test` (`testId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `pitanjetest` */

insert  into `pitanjetest`(`pitanjeId`,`testId`,`brojPoena`) values 
(1,1,30),
(2,1,30),
(3,2,30),
(3,4,30),
(4,2,30),
(4,3,30),
(4,4,30);

/*Table structure for table `polaganje` */

DROP TABLE IF EXISTS `polaganje`;

CREATE TABLE `polaganje` (
  `polaganjeId` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) NOT NULL,
  `datum` date DEFAULT NULL,
  `nazivSale` varchar(100) NOT NULL,
  `testId` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`polaganjeId`),
  KEY `test_foreign_key` (`testId`),
  CONSTRAINT `test_foreign_key` FOREIGN KEY (`testId`) REFERENCES `test` (`testId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `polaganje` */

insert  into `polaganje`(`polaganjeId`,`naziv`,`datum`,`nazivSale`,`testId`) values 
(2,'Polaganje testa opste kulture','2020-08-21','D201',2),
(3,'Polaganje iz projektovanja softvera','2018-08-23','B103',1),
(4,'Polaganje iz geografije','2022-06-21','Citaonica',3),
(6,'',NULL,'0',1);

/*Table structure for table `rezultatpolaganja` */

DROP TABLE IF EXISTS `rezultatpolaganja`;

CREATE TABLE `rezultatpolaganja` (
  `studentId` int(11) NOT NULL,
  `polaganjeId` int(11) NOT NULL,
  `datumOd` date NOT NULL,
  `datumDo` date NOT NULL,
  `brojPoena` int(11) NOT NULL,
  `ocena` int(11) NOT NULL,
  PRIMARY KEY (`studentId`,`polaganjeId`),
  KEY `polaganje_fk` (`polaganjeId`),
  CONSTRAINT `polaganje_fk` FOREIGN KEY (`polaganjeId`) REFERENCES `polaganje` (`polaganjeId`),
  CONSTRAINT `student_fk` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `rezultatpolaganja` */

insert  into `rezultatpolaganja`(`studentId`,`polaganjeId`,`datumOd`,`datumDo`,`brojPoena`,`ocena`) values 
(1,3,'2018-08-23','2018-08-23',91,91),
(2,3,'2018-08-23','2018-08-23',80,7),
(3,3,'2018-08-23','2018-08-23',94,10),
(3,4,'2022-06-21','2022-06-21',0,5),
(4,2,'2020-08-21','2020-08-21',20,10),
(4,4,'2022-06-21','2022-06-21',0,5),
(5,2,'2020-08-21','2020-08-21',25,10),
(6,2,'2020-08-21','2020-08-21',19,9);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brojIndeksa` varchar(100) NOT NULL,
  `ime` varchar(100) NOT NULL,
  `prezime` varchar(100) NOT NULL,
  `pol` varchar(100) NOT NULL,
  `datumRodjenja` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `student` */

insert  into `student`(`id`,`brojIndeksa`,`ime`,`prezime`,`pol`,`datumRodjenja`) values 
(1,'2019-0048','Vuk','Manojlovic','Musko','2000-06-21'),
(2,'2019-0025','Dimitrije','Jovanovic','Musko','2000-07-26'),
(3,'2019-0071','Andjela','Lausevic','Zensko','2000-05-26'),
(4,'2019-0129','Ognjen','Jankovic','Musko','2000-08-04'),
(5,'2018-0231','Milica','Mitrovic','Zensko','1999-05-20'),
(6,'2020-0001','Milena','Djuric','Zensko','2001-09-20');

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `testId` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) NOT NULL,
  `autor` varchar(100) NOT NULL,
  `maxBrojPoena` int(11) NOT NULL,
  PRIMARY KEY (`testId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `test` */

insert  into `test`(`testId`,`naziv`,`autor`,`maxBrojPoena`) values 
(1,'Objektno orijentisano programiranje','Vuk Manojlovic',100),
(2,'Opsta kultura','Jasmina Zivanovic',25),
(3,'Geografija','Jasna Markovic',30),
(4,'Test opste informisanosti','Vuk Manojlovic',50);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
