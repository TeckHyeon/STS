-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 58.239.58.243    Database: java404_kdh_1_db
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
-- Table structure for table `post_file`
--

DROP TABLE IF EXISTS `post_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_file` (
  `postfile_idx` int NOT NULL AUTO_INCREMENT,
  `post_idx` int NOT NULL,
  `original_name` varchar(200) NOT NULL,
  `file_path` varchar(500) NOT NULL,
  `file_size` int NOT NULL,
  `created_date` datetime NOT NULL,
  `deleted_yn` varchar(45) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`postfile_idx`),
  KEY `post_idx` (`post_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_file`
--

LOCK TABLES `post_file` WRITE;
/*!40000 ALTER TABLE `post_file` DISABLE KEYS */;
INSERT INTO `post_file` VALUES (1,1,'cat.jpg','C:\\Users\\rims2\\Desktop\\JSPBackup\\STS\\Gametalk\\/post_file/20220128/11838572587100.jpg',6677,'2022-01-28 01:04:20','N'),(2,1,'chef.jpg','C:\\Users\\rims2\\Desktop\\JSPBackup\\STS\\Gametalk\\/post_file/20220128/11838573213700.jpg',42036,'2022-01-28 01:04:20','N'),(3,1,'cherries.jpg','C:\\Users\\rims2\\Desktop\\JSPBackup\\STS\\Gametalk\\/post_file/20220128/11838573609100.jpg',28867,'2022-01-28 01:04:20','N'),(4,2,'workshop.jpg','C:\\Users\\rims2\\Desktop\\JSPBackup\\STS\\Gametalk\\/post_file/20220128/12796075440300.jpg',13906,'2022-01-28 01:20:18','N');
/*!40000 ALTER TABLE `post_file` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-08  2:35:40
