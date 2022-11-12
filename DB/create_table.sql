CREATE DATABASE `lpp-dev`;
CREATE DATABASE `lpp-uat`;
CREATE DATABASE `lpp-prod`;

CREATE TABLE `userinfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usernam` varchar(255) NOT NULL,
  `userpwd` varchar(255) NOT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `regdate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` int NOT NULL,
  `course` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;