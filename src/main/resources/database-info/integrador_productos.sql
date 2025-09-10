-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: integrador
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `valor` float(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'nisl sem,',92.00),(2,'Nam consequat',51.00),(3,'ut erat.',28.00),(4,'non magna. Nam',60.00),(5,'rutrum lorem',32.00),(6,'metus.',59.00),(7,'Nam interdum',17.00),(8,'urna et',57.00),(9,'adipiscing elit. Curabitur',86.00),(10,'neque vitae',4.00),(11,'nulla. Integer',65.00),(12,'vitae sodales',78.00),(13,'per',27.00),(14,'neque tellus,',33.00),(15,'egestas nunc sed',79.00),(16,'ultrices iaculis odio.',60.00),(17,'nibh.',53.00),(18,'imperdiet ullamcorper. Duis',1.00),(19,'viverra.',1.00),(20,'Donec',52.00),(21,'et ipsum cursus',27.00),(22,'arcu. Vestibulum',95.00),(23,'malesuada malesuada.',23.00),(24,'interdum feugiat.',26.00),(25,'odio a purus.',86.00),(26,'amet, faucibus ut,',7.00),(27,'faucibus orci',15.00),(28,'pede, malesuada vel,',53.00),(29,'iaculis',96.00),(30,'orci, in',76.00),(31,'dolor quam,',10.00),(32,'dictum ultricies',9.00),(33,'pharetra',52.00),(34,'molestie arcu. Sed',64.00),(35,'magna.',30.00),(36,'consequat enim diam',47.00),(37,'In',60.00),(38,'a',56.00),(39,'parturient montes, nascetur',8.00),(40,'eros turpis',54.00),(41,'ullamcorper',56.00),(42,'gravida',6.00),(43,'Duis elementum,',29.00),(44,'risus,',58.00),(45,'Donec nibh. Quisque',10.00),(46,'tempor augue',19.00),(47,'eu eros.',88.00),(48,'tellus lorem',67.00),(49,'nec,',22.00),(50,'erat neque',41.00),(51,'metus.',98.00),(52,'enim nisl',45.00),(53,'Duis a',84.00),(54,'interdum',25.00),(55,'laoreet',99.00),(56,'Cum',70.00),(57,'Ut',38.00),(58,'diam',48.00),(59,'Proin dolor. Nulla',36.00),(60,'nunc interdum feugiat.',22.00),(61,'velit',72.00),(62,'metus facilisis lorem',63.00),(63,'libero',89.00),(64,'erat.',35.00),(65,'Sed eu',35.00),(66,'est',23.00),(67,'erat. Sed nunc',95.00),(68,'tempor arcu. Vestibulum',29.00),(69,'tempor bibendum.',40.00),(70,'enim, gravida',40.00),(71,'erat.',35.00),(72,'vitae nibh.',36.00),(73,'odio a purus.',20.00),(74,'et libero. Proin',4.00),(75,'est tempor',76.00),(76,'Morbi non',3.00),(77,'nonummy ultricies ornare,',52.00),(78,'purus. Maecenas',94.00),(79,'taciti sociosqu',2.00),(80,'a odio',75.00),(81,'id risus quis',38.00),(82,'vehicula risus.',69.00),(83,'augue ut',56.00),(84,'augue ut lacus.',89.00),(85,'scelerisque neque. Nullam',19.00),(86,'odio',89.00),(87,'ac, eleifend',62.00),(88,'vitae',4.00),(89,'Aenean egestas',65.00),(90,'leo.',15.00),(91,'quis,',99.00),(92,'sit amet, faucibus',54.00),(93,'pharetra',92.00),(94,'posuere cubilia Curae;',77.00),(95,'nec, malesuada',16.00),(96,'non,',42.00),(97,'Fusce',82.00),(98,'a felis ullamcorper',40.00),(99,'sociis natoque',56.00),(100,'felis purus ac',44.00);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-06 14:31:06
