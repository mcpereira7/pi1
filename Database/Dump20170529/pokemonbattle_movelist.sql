-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: pokemonbattle
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movelist`
--

DROP TABLE IF EXISTS `movelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movelist` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `power` int(11) DEFAULT NULL,
  `acc` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movelist`
--

LOCK TABLES `movelist` WRITE;
/*!40000 ALTER TABLE `movelist` DISABLE KEYS */;
INSERT INTO `movelist` VALUES (1,'Absorb',20,100,7),(2,'Acid',40,100,11),(3,'Aurora Beam',65,100,9),(4,'Barrage',15,85,10),(5,'Bind',15,85,10),(6,'Bite',60,100,10),(7,'Body Slam',85,100,10),(8,'Bone Club',65,85,8),(9,'Bonemerang',50,90,8),(10,'Bubble',40,100,14),(11,'Clamp',35,85,14),(12,'Comet Punch',18,85,10),(13,'Confusion',50,100,12),(14,'Constrict',10,100,10),(15,'Crabhammer',100,90,14),(16,'Dig',80,100,8),(17,'Dizzy Punch',70,100,10),(18,'Double Kick',30,100,4),(19,'Double Slap',15,85,10),(20,'Double-Edge',120,100,10),(21,'Dream Eater',100,100,12),(22,'Drill Peck',80,100,10),(23,'Earthquake',100,100,8),(24,'Ember',40,100,5),(25,'Explosion',250,10,10),(26,'Fire Punch',75,100,5),(27,'Fire Spin',35,85,5),(28,'Flamethrower',90,100,5),(29,'Fury Attack',15,85,10),(30,'Fury Swipes',18,80,10),(31,'Gust',40,100,10),(32,'Headbutt',70,100,10),(33,'High Jump Kick',130,90,4),(34,'Horn Attack',65,100,10),(35,'Hydro Pump',110,80,14),(36,'Hyper Beam',150,90,10),(37,'Hyper Fang',80,90,10),(38,'Ice Beam',90,100,9),(39,'Ice Punch',75,100,9),(40,'Jump Kick',100,95,4),(41,'Karate Chop',50,100,4),(42,'Leech Life',80,100,1),(43,'Lick',30,100,6),(44,'Mega Punch',80,85,10),(45,'Pay Day',40,100,10),(46,'Peck',35,100,10),(47,'Petal Dance',120,100,7),(48,'Pin Missile',25,95,1),(49,'Poison Sting',15,100,11),(50,'Pound',40,100,10),(51,'Psybeam',65,10,12),(52,'Psychic',90,100,12),(53,'Quick Attack',40,100,10),(54,'Rage',20,100,10),(55,'Razor Leaf',55,95,7),(56,'Rock Throw',50,90,13),(57,'Rolling Kick',60,85,4),(58,'Scratch',40,100,10),(59,'Self-Destruct',200,100,10),(60,'Skull Bash',130,100,10),(61,'Slam',80,75,10),(62,'Slash',70,100,10),(63,'Sludge',65,100,11),(64,'Smog',30,70,11),(65,'Solar Beam',120,100,7),(66,'Spike Cannon',20,100,10),(67,'Stomp',65,100,10),(68,'Submission',80,80,4),(69,'Tackle',40,100,10),(70,'Take Down',90,85,10),(71,'Thrash',120,100,10),(72,'Thunder',110,70,3),(73,'Thunder Punch',75,100,3),(74,'Tri Attack',80,100,10),(75,'Twineedle',25,100,1),(76,'Vice Grip',55,100,10),(77,'Vine Whip',45,100,7),(78,'Water Gun',40,100,14),(79,'Waterfall',80,100,14),(80,'Wing Attack',60,100,10),(81,'Wrap',15,90,10),(82,'Thunder Shock',40,100,3);
/*!40000 ALTER TABLE `movelist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-29 20:11:53
