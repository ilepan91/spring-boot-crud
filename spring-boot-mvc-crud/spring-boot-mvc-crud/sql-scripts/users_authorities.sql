USE `student_directory`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users` 
VALUES 
('student','{bcrypt}$2a$12$GjKsRVwDEKDjQqS.TeugwO6TazwNbHHkV3xRJcsInozP97YE9OXt.',1),
('admin','{bcrypt}$2a$12$.RuNsXuVBliwxC4K3St2se5my5Ib3MyzTuhKU7x5lYlWAY3dtqMdm',1);

--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('student','ROLE_STUDENT'),
('admin','ROLE_STUDENT'),
('admin','ROLE_ADMIN');