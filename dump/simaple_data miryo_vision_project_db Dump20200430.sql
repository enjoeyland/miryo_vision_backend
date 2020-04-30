CREATE DATABASE  IF NOT EXISTS `miryo_vision_project_db` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `miryo_vision_project_db`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: miryo_vision_project_db
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `as`
--

DROP TABLE IF EXISTS `as`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `as` (
  `id` bigint(20) NOT NULL,
  `as_kind` varchar(255) DEFAULT NULL,
  `call_date` varchar(255) DEFAULT NULL,
  `call_details` varchar(255) DEFAULT NULL,
  `caller_name` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `estimated_delivery_date` varchar(255) DEFAULT NULL,
  `invoice_date` varchar(255) DEFAULT NULL,
  `invoice_num` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `quantity` varchar(255) DEFAULT NULL,
  `retrieved_date` varchar(255) DEFAULT NULL,
  `retrieved_status` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `교환message` varchar(255) DEFAULT NULL,
  `입력employee` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `as`
--

LOCK TABLES `as` WRITE;
/*!40000 ALTER TABLE `as` DISABLE KEYS */;
/*!40000 ALTER TABLE `as` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_classification_code`
--

DROP TABLE IF EXISTS `customer_classification_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_classification_code` (
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sort` varchar(255) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_classification_code`
--

LOCK TABLES `customer_classification_code` WRITE;
/*!40000 ALTER TABLE `customer_classification_code` DISABLE KEYS */;
INSERT INTO `customer_classification_code` VALUES ('K','공기업','1','korea'),('B','금융권','2','bank'),('G','일반사','3','general');
/*!40000 ALTER TABLE `customer_classification_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_company`
--

DROP TABLE IF EXISTS `customer_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_company` (
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `계좌번호` varchar(255) DEFAULT NULL,
  `고객사구분` varchar(255) DEFAULT NULL,
  `대표자명` varchar(255) DEFAULT NULL,
  `대표전화` varchar(255) DEFAULT NULL,
  `사업자등록번호` varchar(255) DEFAULT NULL,
  `업태` varchar(255) DEFAULT NULL,
  `은행명` varchar(255) DEFAULT NULL,
  `이름` varchar(255) DEFAULT NULL,
  `이메일` varchar(255) DEFAULT NULL,
  `종목` varchar(255) DEFAULT NULL,
  `주소` varchar(255) DEFAULT NULL,
  `특이사항` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5x76fbm0a8yniljunrvghqi5u` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_company`
--

LOCK TABLES `customer_company` WRITE;
/*!40000 ALTER TABLE `customer_company` DISABLE KEYS */;
INSERT INTO `customer_company` VALUES ('01','하나은행',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('02','한국가스공사',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('03','경찰청',NULL,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `customer_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_company_branch`
--

DROP TABLE IF EXISTS `customer_company_branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_company_branch` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `branch_name` varchar(255) DEFAULT NULL,
  `general_directory_number` varchar(255) DEFAULT NULL,
  `zip_num` varchar(255) DEFAULT NULL,
  `발송순서` int(11) DEFAULT NULL,
  `소속명` varchar(255) DEFAULT NULL,
  `소속부서` varchar(255) DEFAULT NULL,
  `점num` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_company_branch`
--

LOCK TABLES `customer_company_branch` WRITE;
/*!40000 ALTER TABLE `customer_company_branch` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_company_branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_company_employee`
--

DROP TABLE IF EXISTS `customer_company_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_company_employee` (
  `id` bigint(20) NOT NULL,
  `employee_num` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `personal_phone_num` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `customer_company_branch_id` bigint(20) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1gpstq277ajb15pja28l2b32v` (`customer_company_branch_id`),
  KEY `FKlyblrwwuiao18jdh2qkhs2lix` (`item_id`),
  KEY `FKcdvjdbf7j3hyadcuj1f3bfs5p` (`project_id`),
  CONSTRAINT `FK1gpstq277ajb15pja28l2b32v` FOREIGN KEY (`customer_company_branch_id`) REFERENCES `customer_company_branch` (`id`),
  CONSTRAINT `FKcdvjdbf7j3hyadcuj1f3bfs5p` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `FKlyblrwwuiao18jdh2qkhs2lix` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_company_employee`
--

LOCK TABLES `customer_company_employee` WRITE;
/*!40000 ALTER TABLE `customer_company_employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_company_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `address` varchar(13) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login_id` varchar(255) DEFAULT NULL,
  `login_pw` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone_num` varchar(255) DEFAULT NULL,
  `resident_registration_num` varchar(13) DEFAULT NULL,
  `등급` varchar(255) DEFAULT NULL,
  `부서명` varchar(255) DEFAULT NULL,
  `입사일` date DEFAULT NULL,
  `자격증` varchar(255) DEFAULT NULL,
  `직급` varchar(255) DEFAULT NULL,
  `퇴사일` date DEFAULT NULL,
  `특이사항` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `job_duty` varchar(255) DEFAULT NULL,
  `job_title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,NULL,NULL,NULL,NULL,'영업팀장1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'SALES','TEAM_MANAGER',NULL),(2,NULL,NULL,NULL,NULL,'영업팀장2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'SALES','TEAM_MANAGER',NULL),(3,NULL,NULL,NULL,NULL,'영업팀장3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'SALES','TEAM_MANAGER',NULL),(4,NULL,NULL,NULL,NULL,'물류팀장1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'LOGISTICS','TEAM_MANAGER',NULL),(5,NULL,NULL,NULL,NULL,'물류팀장2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'LOGISTICS','TEAM_MANAGER',NULL),(6,NULL,NULL,NULL,NULL,'물류팀장3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'LOGISTICS','TEAM_MANAGER',NULL),(7,NULL,NULL,NULL,NULL,'생산팀장1','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'PRODUCTION','TEAM_MANAGER',NULL),(8,NULL,NULL,NULL,NULL,'생산팀장2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'PRODUCTION','TEAM_MANAGER',NULL),(9,NULL,NULL,NULL,NULL,'생산팀장3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'PRODUCTION','TEAM_MANAGER',NULL),(10,NULL,NULL,NULL,NULL,'디자인팀장1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'DESIGN','TEAM_MANAGER',NULL),(11,NULL,NULL,NULL,NULL,'디자인팀장2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'DESIGN','TEAM_MANAGER',NULL),(12,NULL,NULL,NULL,NULL,'디자인팀장3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'DESIGN','TEAM_MANAGER',NULL),(13,NULL,NULL,NULL,NULL,'경리팀장1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'ACCOUNTING','TEAM_MANAGER',NULL),(14,NULL,NULL,NULL,NULL,'경리팀장2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'ACCOUNTING','TEAM_MANAGER',NULL),(15,NULL,NULL,NULL,NULL,'경리팀장3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'ACCOUNTING','TEAM_MANAGER',NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender_code`
--

DROP TABLE IF EXISTS `gender_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender_code` (
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sort` varchar(255) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender_code`
--

LOCK TABLES `gender_code` WRITE;
/*!40000 ALTER TABLE `gender_code` DISABLE KEYS */;
INSERT INTO `gender_code` VALUES ('U','공용','3','Unisex'),('M','남성','1','Male'),('F','여성','2','Female');
/*!40000 ALTER TABLE `gender_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (73);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id` bigint(20) NOT NULL,
  `item_code` varchar(255) DEFAULT NULL,
  `item_large_category` varchar(255) DEFAULT NULL,
  `item_small_category` varchar(255) DEFAULT NULL,
  `register_date` date DEFAULT NULL,
  `unit_cost` varchar(255) DEFAULT NULL,
  `지급수량` varchar(255) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  `large_category` int(11) DEFAULT NULL,
  `small_category` tinyblob,
  PRIMARY KEY (`id`),
  KEY `FKf60hnjyqgladtp0jw5o0n4e9u` (`project_id`),
  CONSTRAINT `FKf60hnjyqgladtp0jw5o0n4e9u` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL,
  `order_num` bigint(20) DEFAULT NULL,
  `estimated_delivery_date` date DEFAULT NULL,
  `is_first_order` bit(1) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `request_date` date DEFAULT NULL,
  `total_price` int(11) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKniu2ipu319mfoyua4rct0ba8e` (`item_id`),
  KEY `FKmidbs4vhu1wh6rllgte7vuy8s` (`project_id`),
  CONSTRAINT `FKmidbs4vhu1wh6rllgte7vuy8s` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `FKniu2ipu319mfoyua4rct0ba8e` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id` bigint(20) NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `교환수량` varchar(255) DEFAULT NULL,
  `구매방법` varchar(255) DEFAULT NULL,
  `날짜` varchar(255) DEFAULT NULL,
  `비고` varchar(255) DEFAULT NULL,
  `송장번호` varchar(255) DEFAULT NULL,
  `송장일` varchar(255) DEFAULT NULL,
  `신규메세지` varchar(255) DEFAULT NULL,
  `입력직원` varchar(255) DEFAULT NULL,
  `정산되야되는_날짜` varchar(255) DEFAULT NULL,
  `포장예정일` varchar(255) DEFAULT NULL,
  `품목구매단위` varchar(255) DEFAULT NULL,
  `회수수량` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_type_code`
--

DROP TABLE IF EXISTS `product_type_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_type_code` (
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sort` varchar(255) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `UK_r5m8sbtuomjscmr32nduqgj6c` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_type_code`
--

LOCK TABLES `product_type_code` WRITE;
/*!40000 ALTER TABLE `product_type_code` DISABLE KEYS */;
INSERT INTO `product_type_code` VALUES ('B','복지품','6','Well being'),('H','방한복','4','Heavy'),('O','근무복','1','Office'),('P','기획','5','Plan'),('S','성하복','3','Summer'),('W','작업복','2','Work');
/*!40000 ALTER TABLE `product_type_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `id` bigint(20) NOT NULL,
  `barcode` varchar(10) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `plant_code` varchar(255) DEFAULT NULL,
  `customer_company_id` bigint(20) DEFAULT NULL,
  `season` varchar(255) DEFAULT NULL,
  `customer_classification` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `product_type` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `fair_status` varchar(10) DEFAULT NULL,
  `accounting_depart_employee_incharge_id` bigint(20) DEFAULT NULL,
  `design_depart_employee_incharge_id` bigint(20) DEFAULT NULL,
  `logistics_depart_employee_incharge_id` bigint(20) DEFAULT NULL,
  `production_depart_employee_incharge_id` bigint(20) DEFAULT NULL,
  `sales_depart_employee_incharge_id` bigint(20) DEFAULT NULL,
  `fair_result_datetime` datetime(6) DEFAULT NULL,
  `start_datetime` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdat310fgrwuxyicaypaf5klhb` (`customer_company_id`),
  KEY `FK3l2waf2s6jwax7u5uo4od54tk` (`accounting_depart_employee_incharge_id`),
  KEY `FKqryhlxqwbg9yrtvmwa30tixej` (`design_depart_employee_incharge_id`),
  KEY `FK8k2fkvvwvexchcm98dqjux8tu` (`logistics_depart_employee_incharge_id`),
  KEY `FKhmq3it6jlj0nkgykiqeyl7fsf` (`production_depart_employee_incharge_id`),
  KEY `FK2agjkahjpkcrjh5kphm74gjui` (`sales_depart_employee_incharge_id`),
  CONSTRAINT `FK2agjkahjpkcrjh5kphm74gjui` FOREIGN KEY (`sales_depart_employee_incharge_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK3l2waf2s6jwax7u5uo4od54tk` FOREIGN KEY (`accounting_depart_employee_incharge_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK8k2fkvvwvexchcm98dqjux8tu` FOREIGN KEY (`logistics_depart_employee_incharge_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FKdat310fgrwuxyicaypaf5klhb` FOREIGN KEY (`customer_company_id`) REFERENCES `customer_company` (`id`),
  CONSTRAINT `FKhmq3it6jlj0nkgykiqeyl7fsf` FOREIGN KEY (`production_depart_employee_incharge_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FKqryhlxqwbg9yrtvmwa30tixej` FOREIGN KEY (`design_depart_employee_incharge_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (27,'sdfsdfsd',NULL,NULL,3,'WINTER','BANK','UNISEX','WELL_BEING','Y2019','LOSE',13,10,5,9,2,NULL,NULL),(28,'adfasdf',NULL,NULL,3,'WINTER','GENERAL','FEMALE','WELL_BEING','Y2019','LOSE',13,12,6,7,2,NULL,NULL),(29,'sdaf',NULL,NULL,2,'WINTER','GENERAL','FEMALE','WELL_BEING','Y2019','WIN',14,10,5,9,3,NULL,NULL),(30,'dfdf',NULL,NULL,2,'FOUR_SEASON','GENERAL','FEMALE','WELL_BEING','Y2019','WAITING',14,12,4,7,1,NULL,NULL),(31,'GE02U4B031',NULL,NULL,2,'FOUR_SEASON','GENERAL','UNISEX','WELL_BEING','Y2019','LOSE',15,10,6,9,1,NULL,NULL),(32,'GE02M2B032','2019년도 한국가스공사 동계 남성복 ','E-032',2,'WINTER','GENERAL','MALE','WELL_BEING','Y2019','WAITING',15,11,6,9,3,NULL,NULL),(33,'GE02M1B033','2019년도 한국가스공사 하계 남성복 ','E-033',2,'SUMMER','GENERAL','MALE','WELL_BEING','Y2019','WAITING',15,12,5,8,2,NULL,NULL),(37,'GE01F1O037','2019년도 하나은행 하계 여성복 ','E-037',1,'SUMMER','GENERAL','FEMALE','OFFICE','Y2019','WAITING',15,10,6,7,2,NULL,'2020-03-02 23:16:40.039000'),(39,'EG01F4O039','2019년도 하나은행 사계절 여성복 ','E-039',1,'FOUR_SEASON','GENERAL','FEMALE','OFFICE','Y2019','WAITING',15,10,6,7,2,NULL,'2020-03-08 01:15:09.013000'),(40,'EG01F3O040','2019년도 하나은행 춘추 여성복 ','E-040',1,'SPRING_AUTUMN','GENERAL','FEMALE','OFFICE','Y2019','WAITING',15,10,6,7,2,NULL,'2020-03-08 01:19:21.846000'),(41,'FG01F3O041','2020년도 하나은행 춘추 여성복 ','F-041',1,'SPRING_AUTUMN','GENERAL','FEMALE','OFFICE','Y2020','WIN',15,10,6,7,3,'2020-03-09 19:28:52.636000','2020-03-08 18:01:41.015000'),(42,NULL,NULL,NULL,1,'SPRING_AUTUMN','GENERAL','MALE','OFFICE','Y2019',NULL,15,10,6,7,2,NULL,NULL),(43,NULL,NULL,NULL,1,'SPRING_AUTUMN','GENERAL','MALE','WORK','Y2019',NULL,15,10,6,7,2,NULL,NULL),(44,NULL,NULL,NULL,1,'FOUR_SEASON','GENERAL','MALE','WORK','Y2019',NULL,15,10,6,7,2,NULL,NULL),(45,NULL,NULL,NULL,1,'WINTER','GENERAL','MALE','WORK','Y2019',NULL,15,10,6,7,2,NULL,NULL),(46,NULL,NULL,NULL,1,'SUMMER','GENERAL','MALE','WORK','Y2019',NULL,15,10,6,7,2,NULL,NULL),(47,NULL,NULL,NULL,1,'SUMMER','GENERAL','MALE','SUMMER','Y2019',NULL,15,10,6,7,2,NULL,NULL),(49,'EG01M2S049','2019년도 하나은행 동계 남성복 ','E-049',1,'WINTER','GENERAL','MALE','SUMMER','Y2019','WIN',15,10,6,7,2,NULL,NULL),(50,'EG01M4S050','2019년도 하나은행 사계절 남성복 ','E-050',1,'FOUR_SEASON','GENERAL','MALE','SUMMER','Y2019','WIN',15,10,6,7,3,NULL,NULL),(51,'EG01F4S051','2019년도 하나은행 사계절 여성복 ','E-051',1,'FOUR_SEASON','GENERAL','FEMALE','SUMMER','Y2019','LOSE',15,10,6,7,3,NULL,NULL),(52,'EG01F2S052','2019년도 하나은행 동계 여성복 ','E-052',1,'WINTER','GENERAL','FEMALE','SUMMER','Y2019','WIN',15,10,6,7,3,NULL,NULL),(53,'EG01F1S053','2019년도 하나은행 하계 여성복 ','E-053',1,'SUMMER','GENERAL','FEMALE','SUMMER','Y2019','LOSE',15,10,6,7,3,NULL,NULL),(54,'EG01F1H054','2019년도 하나은행 하계 여성복 ','E-054',1,'SUMMER','GENERAL','FEMALE','HEAVY','Y2019','LOSE',15,10,6,7,3,NULL,'2020-03-09 18:08:54.820000'),(55,'EG01F2H055','2019년도 하나은행 동계 여성복 ','E-055',1,'WINTER','GENERAL','FEMALE','HEAVY','Y2019','WIN',15,10,6,7,3,NULL,'2020-03-09 18:09:54.585000'),(57,'FB01F1W057','2020년도 하나은행 하계 여성복 ','F-057',1,'SUMMER','BANK','FEMALE','WORK','Y2020','LOSE',13,11,5,8,1,'2020-03-10 22:26:26.205000','2020-03-10 18:50:10.239000'),(58,'EG01F2H058','2019년도 하나은행 동계 여성복 ','E-058',1,'WINTER','GENERAL','FEMALE','HEAVY','Y2019','WAITING',15,10,6,7,2,NULL,'2020-03-10 18:58:34.461000'),(60,'HK03F1O060','2022년도 경찰청 하계 여성복 ','H-060',3,'SUMMER','KOREA','FEMALE','OFFICE','Y2022','WAITING',14,10,4,7,1,NULL,'2020-03-10 21:06:24.943000'),(61,'FG02U1W061','2020년도 한국가스공사 하계 공용복 ','F-061',2,'SUMMER','GENERAL','UNISEX','WORK','Y2020','WAITING',14,11,5,8,2,NULL,'2020-03-10 22:30:50.204000'),(62,'FK03M1S062','2020년도 경찰청 하계 남성복 ','F-062',3,'SUMMER','KOREA','MALE','SUMMER','Y2020','WAITING',14,11,5,8,2,NULL,'2020-03-10 22:31:53.970000'),(63,'EB03F3B063','2019년도 경찰청 춘추 여성복 ','E-063',3,'SPRING_AUTUMN','BANK','FEMALE','WELL_BEING','Y2019','WAITING',14,12,5,8,3,NULL,'2020-03-11 00:30:11.074000'),(64,'EG03U5B064','2019년도 경찰청 기타 공용복 ','E-064',3,'ETC','GENERAL','UNISEX','WELL_BEING','Y2019','WIN',13,10,4,7,1,'2020-03-11 00:35:29.276000','2020-03-11 00:34:35.906000'),(65,'EG03U5P065','2019년도 경찰청 기타 공용복 ','E-065',3,'ETC','GENERAL','UNISEX','PLAN','Y2019','WAITING',14,10,4,7,1,NULL,'2020-03-11 00:39:43.252000'),(66,'GB01U4H066','2021년도 하나은행 사계절 공용복 ','G-066',1,'FOUR_SEASON','BANK','UNISEX','HEAVY','Y2021','WAITING',13,10,4,7,1,NULL,'2020-03-11 18:13:09.191000'),(67,'FG02U5P067','2020년도 한국가스공사 기타 공용복 ','F-067',2,'ETC','GENERAL','UNISEX','PLAN','Y2020','WAITING',13,10,4,7,1,NULL,'2020-03-11 18:15:31.162000'),(68,'HB01F2W068','2022년도 하나은행 동계 여성복 ','H-068',1,'WINTER','BANK','FEMALE','WORK','Y2022','WAITING',14,11,5,8,2,NULL,'2020-03-11 18:18:43.917000'),(69,'HB03F3W069','2022년도 경찰청 춘추 여성복 ','H-069',3,'SPRING_AUTUMN','BANK','FEMALE','WORK','Y2022','WAITING',14,11,5,8,2,NULL,'2020-03-11 18:20:57.875000'),(70,'GG02M2W070','2021년도 한국가스공사 동계 남성복 ','G-070',2,'WINTER','GENERAL','MALE','WORK','Y2021','WAITING',14,11,5,8,2,NULL,'2020-03-11 18:51:46.968000'),(71,'HB01F4P071','2022년도 하나은행 사계절 여성복 ','H-071',1,'FOUR_SEASON','BANK','FEMALE','PLAN','Y2022','WAITING',13,10,4,7,1,NULL,'2020-03-11 19:00:37.884000'),(72,'IB01F1O072','2023년도 하나은행 하계 여성복 ','I-072',1,'SUMMER','BANK','FEMALE','OFFICE','Y2023','WAITING',14,10,4,7,1,NULL,'2020-03-11 19:12:17.883000');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_item_list`
--

DROP TABLE IF EXISTS `project_item_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_item_list` (
  `project_id` bigint(20) NOT NULL,
  `item_list_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_a8x2ieah4svipxgifiodn6ibb` (`item_list_id`),
  KEY `FK2qagirh96plm6kn7oal9nlk3a` (`project_id`),
  CONSTRAINT `FK2qagirh96plm6kn7oal9nlk3a` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `FKg3siiwoj4m8tvcc419vasye52` FOREIGN KEY (`item_list_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_item_list`
--

LOCK TABLES `project_item_list` WRITE;
/*!40000 ALTER TABLE `project_item_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_item_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `season_code`
--

DROP TABLE IF EXISTS `season_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `season_code` (
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sort` varchar(255) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `season_code`
--

LOCK TABLES `season_code` WRITE;
/*!40000 ALTER TABLE `season_code` DISABLE KEYS */;
INSERT INTO `season_code` VALUES ('5','기타','5',NULL),('2','동계','2',NULL),('4','사계절','4',NULL),('3','춘추','3',NULL),('1','하계','1',NULL);
/*!40000 ALTER TABLE `season_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `year_code`
--

DROP TABLE IF EXISTS `year_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `year_code` (
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sort` varchar(255) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `year_code`
--

LOCK TABLES `year_code` WRITE;
/*!40000 ALTER TABLE `year_code` DISABLE KEYS */;
INSERT INTO `year_code` VALUES ('A','2015','1',NULL),('B','2016','2',NULL),('C','2017','3',NULL),('D','2018','4',NULL),('E','2019','5',NULL),('F','2020','6',NULL),('G','2021','7',NULL),('H','2022','8',NULL),('I','2023','9',NULL),('J','2024','10',NULL),('K','2025','11',NULL),('L','2026','12',NULL),('M','2027','13',NULL),('N','2028','14',NULL),('O','2029','15',NULL),('P','2030','16',NULL),('Q','2031','17',NULL),('R','2032','18',NULL),('S','2033','19',NULL),('T','2034','20',NULL),('U','2035','21',NULL),('V','2036','22',NULL),('W','2037','23',NULL),('X','2038','24',NULL),('Y','2039','25',NULL),('Z','Full Year','26',NULL);
/*!40000 ALTER TABLE `year_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'miryo_vision_project_db'
--

--
-- Dumping routines for database 'miryo_vision_project_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-30 20:13:32
