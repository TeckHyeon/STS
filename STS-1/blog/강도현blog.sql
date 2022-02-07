-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: blogdb
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_blog`
--

DROP TABLE IF EXISTS `t_blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_blog` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `contents` text,
  `creator_id` varchar(45) NOT NULL,
  `created_dt` datetime NOT NULL,
  `updator_id` varchar(45) DEFAULT NULL,
  `updated_dt` varchar(45) DEFAULT NULL,
  `hit_cnt` int NOT NULL DEFAULT '0',
  `deleted_yn` char(1) NOT NULL DEFAULT 'N',
  `category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog`
--

LOCK TABLES `t_blog` WRITE;
/*!40000 ALTER TABLE `t_blog` DISABLE KEYS */;
INSERT INTO `t_blog` VALUES (1,'공지사항','공지사항입니다.','tester01','2022-01-11 21:56:09',NULL,NULL,0,'N','공지사항');
/*!40000 ALTER TABLE `t_blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_guestbook`
--

DROP TABLE IF EXISTS `t_guestbook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_guestbook` (
  `seq` int NOT NULL AUTO_INCREMENT,
  `guest_name` varchar(45) NOT NULL,
  `guest_pw` varchar(45) NOT NULL,
  `guest_contents` varchar(45) NOT NULL,
  `guest_created_dt` datetime NOT NULL,
  `deleted_yn` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='방명록 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_guestbook`
--

LOCK TABLES `t_guestbook` WRITE;
/*!40000 ALTER TABLE `t_guestbook` DISABLE KEYS */;
INSERT INTO `t_guestbook` VALUES (1,'guest01','bitc1234','글 올라가는지 확인','2022-01-10 15:56:06','N'),(2,'guest01','bitc1234','글 올라가는지 확인','2022-01-10 15:58:06','N'),(3,'guest01','bitc1234','등록되는지 확인','2022-01-10 15:59:40','N'),(4,'guest02','bitc1234','등록되는지 확인','2022-01-11 20:04:48','N'),(5,'guest03','bitc1234','등록되는지 확인','2022-01-11 20:07:15','N'),(6,'guest04','bitc1234','등록되는지 확인','2022-01-11 20:12:05','N'),(7,'guest04','bitc1234','수정되는지 확인','2022-01-11 20:12:17','Y'),(8,'guest05','bitc1234','수정되는지 확인3','2022-01-11 20:12:38','Y'),(10,'guest06','bitc1234','등록되는지 재확인','2022-01-11 21:16:01','N');
/*!40000 ALTER TABLE `t_guestbook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member`
--

DROP TABLE IF EXISTS `t_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_member` (
  `seq` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `user_pw` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `user_email` varchar(45) DEFAULT NULL,
  `user_level` int DEFAULT '0',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member`
--

LOCK TABLES `t_member` WRITE;
/*!40000 ALTER TABLE `t_member` DISABLE KEYS */;
INSERT INTO `t_member` VALUES (1,'tester01','bitc1234','KDH','KDH@bitc.co.kr',0);
/*!40000 ALTER TABLE `t_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'blogdb'
--

--
-- Dumping routines for database 'blogdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-11 22:08:42
