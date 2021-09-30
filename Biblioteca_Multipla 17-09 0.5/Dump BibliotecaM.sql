CREATE DATABASE  IF NOT EXISTS `biblioteca_multipla` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `biblioteca_multipla`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: biblioteca_multipla
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `animacao`
--

DROP TABLE IF EXISTS `animacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animacao` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(100) NOT NULL,
  `ANO_DE_LANCAMENTO` int DEFAULT NULL,
  `GENERO` varchar(300) DEFAULT NULL,
  `NUMERO_EPISODIOS` int unsigned DEFAULT NULL,
  `CATEGORIA_ID` int DEFAULT NULL,
  `DATA_DE_REGISTRO` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ASSISTIDO` bit(1) DEFAULT b'0',
  PRIMARY KEY (`ID`),
  KEY `CATEGORIA_FK` (`CATEGORIA_ID`),
  CONSTRAINT `CATEGORIA_FK` FOREIGN KEY (`CATEGORIA_ID`) REFERENCES `categoria` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animacao`
--

LOCK TABLES `animacao` WRITE;
/*!40000 ALTER TABLE `animacao` DISABLE KEYS */;
INSERT INTO `animacao` VALUES (1,'He-Man and the Masters of the Universe',1983,'Ação/aventura, fantasia científica',130,2,'2021-09-30 14:03:45',_binary ''),(2,'Digimon Adventure',1999,'Action, Adventure, Comedy, Fantasy',54,1,'2021-09-30 14:03:46',_binary ''),(3,'SpongeBob SquarePants',1999,'aventura, comédia',387,2,'2021-09-30 14:03:46',_binary '\0'),(4,'Naruto',2002,'Action, Adventure, Comedy',220,1,'2021-09-30 14:03:47',_binary '\0'),(5,'Dragon Ball Z',1989,'Action, Adventure, Comedy, Fantasy',291,1,'2021-09-30 14:05:05',_binary '');
/*!40000 ALTER TABLE `animacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animacao_assistido`
--

DROP TABLE IF EXISTS `animacao_assistido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animacao_assistido` (
  `ANIMACAO_ID` int NOT NULL,
  `DATA_DE_FINALIZACAO` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `NOTA` decimal(5,3) DEFAULT NULL,
  PRIMARY KEY (`ANIMACAO_ID`),
  CONSTRAINT `FK_ANIMACAO_A` FOREIGN KEY (`ANIMACAO_ID`) REFERENCES `animacao` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animacao_assistido`
--

LOCK TABLES `animacao_assistido` WRITE;
/*!40000 ALTER TABLE `animacao_assistido` DISABLE KEYS */;
INSERT INTO `animacao_assistido` VALUES (1,'2021-09-30 14:03:46',8.500),(2,'2021-09-30 14:03:46',7.500),(5,'2021-09-30 14:05:05',8.500);
/*!40000 ALTER TABLE `animacao_assistido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animacao_n_assistido`
--

DROP TABLE IF EXISTS `animacao_n_assistido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animacao_n_assistido` (
  `ANIMACAO_ID` int NOT NULL,
  `RELEVANCIA` enum('S','A','B','C','D') DEFAULT NULL,
  `PRIORIDADE` enum('--','-','=','+','++') DEFAULT NULL,
  PRIMARY KEY (`ANIMACAO_ID`),
  CONSTRAINT `FK_ANIMACAO_N_A` FOREIGN KEY (`ANIMACAO_ID`) REFERENCES `animacao` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animacao_n_assistido`
--

LOCK TABLES `animacao_n_assistido` WRITE;
/*!40000 ALTER TABLE `animacao_n_assistido` DISABLE KEYS */;
INSERT INTO `animacao_n_assistido` VALUES (3,'S','++'),(4,'C','+');
/*!40000 ALTER TABLE `animacao_n_assistido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'ANIMACAO ORIENTAL'),(2,'ANIMACAO_OCIDENTAL'),(3,'SERIADO'),(4,'FILME'),(5,'JOGO_ELETRONICO');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dublador`
--

DROP TABLE IF EXISTS `dublador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dublador` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) DEFAULT NULL,
  `NASCIMENTO` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dublador`
--

LOCK TABLES `dublador` WRITE;
/*!40000 ALTER TABLE `dublador` DISABLE KEYS */;
INSERT INTO `dublador` VALUES (1,'Junko Takeuchi','1972-04-05'),(2,'John Erwin','1936-12-05'),(3,'Tom Kenny','1962-07-13');
/*!40000 ALTER TABLE `dublador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personagem`
--

DROP TABLE IF EXISTS `personagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personagem` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) DEFAULT NULL,
  `ANIMACAO_ID` int NOT NULL,
  `DUBLADOR_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ANIMACAO_PERSONAGEM` (`ANIMACAO_ID`),
  KEY `FK_DUBLADOR` (`DUBLADOR_ID`),
  CONSTRAINT `FK_ANIMACAO_PERSONAGEM` FOREIGN KEY (`ANIMACAO_ID`) REFERENCES `animacao` (`ID`),
  CONSTRAINT `FK_DUBLADOR` FOREIGN KEY (`DUBLADOR_ID`) REFERENCES `dublador` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personagem`
--

LOCK TABLES `personagem` WRITE;
/*!40000 ALTER TABLE `personagem` DISABLE KEYS */;
INSERT INTO `personagem` VALUES (1,'Naruto Uzumaki',4,1),(2,'Gomamon',2,1),(3,'He-Man',1,2),(4,'Bob Esponja',3,3);
/*!40000 ALTER TABLE `personagem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-30 11:35:04

DELIMITER //

CREATE PROCEDURE ANIME_N_ASSISTIDO_INSERCAO (cNOME VARCHAR (100), cANO_DE_LANCAMENTO INT, cGENERO VARCHAR(250), cNUMERO_EPISODIOS INT, cCATEGORIA_ID INT, cRELEVANCIA ENUM('S', 'A', 'B', 'C', 'D'), cPRIORIDADE ENUM('--', '-', '=', '+', '++'))
BEGIN
	INSERT INTO ANIMACAO (ID, NOME, ANO_DE_LANCAMENTO, GENERO, NUMERO_EPISODIOS, CATEGORIA_ID, DATA_DE_REGISTRO, ASSISTIDO) VALUES (DEFAULT, cNOME, cANO_DE_LANCAMENTO, cGENERO, cNUMERO_EPISODIOS, cCATEGORIA_ID, default, default);
	INSERT INTO ANIMACAO_N_ASSISTIDO (ANIMACAO_ID, RELEVANCIA, PRIORIDADE) VALUES ((SELECT MAX(ID) FROM ANIMACAO), cRELEVANCIA, cPRIORIDADE);
END//

CREATE PROCEDURE ANIMACAO_ASSISTIDO_INSERCAO (cNOME VARCHAR (100), cANO_DE_LANCAMENTO INT, cGENERO VARCHAR(250), cNUMERO_EPISODIOS INT, cCATEGORIA_ID INT, cNOTA DECIMAL (5,3))
BEGIN
	INSERT INTO ANIMACAO (ID, NOME, ANO_DE_LANCAMENTO, GENERO, NUMERO_EPISODIOS, CATEGORIA_ID, DATA_DE_REGISTRO, ASSISTIDO) VALUES (DEFAULT, cNOME, cANO_DE_LANCAMENTO, cGENERO, cNUMERO_EPISODIOS, cCATEGORIA_ID, default, 1);
    INSERT INTO ANIMACAO_ASSISTIDO (ANIMACAO_ID, DATA_DE_FINALIZACAO, NOTA) VALUES ((SELECT MAX(ID) FROM ANIMACAO), DEFAULT, cNOTA);
END//

CREATE PROCEDURE TERMINA_ANIMACAO (cID INT, cNOTA DECIMAL (5,3))
BEGIN
	DELETE FROM ANIMACAO_N_ASSISTIDO WHERE ANIMACAO_ID = cID;
    INSERT INTO ANIMACAO_ASSISTIDO (ANIMACAO_ID, DATA_DE_FINALIZACAO, NOTA) VALUES (cID, DEFAULT, cNOTA);
    UPDATE ANIMACAO SET ASSISTIDO = 1 WHERE ID = cID;
END//

DELIMITER ;
