CREATE DATABASE  IF NOT EXISTS `student_directory`;
USE `student_directory`;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `study_programme` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `students`
--

INSERT INTO `student` VALUES 
	(1,'Ivana','Lepan','ilepan@math.com', 'Theoretical Mathematics'),
	(2,'Emma','Petrov','epetrov@math.com', 'Mathematical Statistics'),
	(3,'Dario','Horvat','dhorvat@math.com', 'Computer Science'),
	(4,'Vesna','Babun','vbabun@math.com', 'Mathematics Education'),
	(5,'Ana','Juric','ajuric@math.com', 'Financial Mathematics');