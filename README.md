# Basic Spring Boot CRUD Application

This is a simple Spring Boot application that demonstrates CRUD (Create, Read, Update, Delete) operations on a `Student` entity in a relational database.

## Table of Contents
- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Application Structure](#application-structure)
- [Usage](#usage)

## Introduction

The project is a Spring Boot application that provides the implementation of basic CRUD operations using Hibernate as the JPA provider for database interaction. The application includes a `Student` entity with fields like `id`, `firstName`, `lastName`, and `email`.

## Technologies Used

- Java
- Spring Boot
- Hibernate
- MYSQL

## Getting Started

1. **Install MySQL:**

   Download and install MySQL if you don't have it installed already. You can download the MySQL Community Server from the official website: [MySQL Downloads](https://dev.mysql.com/downloads/mysql/)

2. **Create a MySQL Database:**

   Open your MySQL command-line tool or a GUI tool like MySQL Workbench, and open 'create_user.sql' script from sql-scripts folder.
   After executing it, create a new connection: springstudent (password should be set as: springstudent as well)

   If you're using different connecetion and credentials then:
   - Reconfigure the application's database connection properties in the src/main/resources/application.properties file.
   - Update the following properties with your MySQL credentials:
     spring.datasource.url=jdbc:mysql://localhost:3306/student_directory
     spring.datasource.username=your-mysql-username
     spring.datasource.password=your-mysql-password

4. **Open Student script**
   - Login in created MySQL connection with correct credentials and go to File -> Open SQL script. Choose student_directory.sql and Execute it.
   - Run the CrudApplication.java from your IDE
     (You can also run it from or the command line:
         cd spring-boot-hibernate-jpa/crud
         ./mvnw spring-boot:run (or 'mvnw spring-boot:run' for MicrosoftWin))
 
5. **Application Structure**
- src/main/java/com.springboot.hibernate: Contains the main application files.
- CrudApplication.java: Main class with the Spring Boot application entry point.
- dao/StudentDAO.java: Interface defining CRUD operations for the Student entity.
- dao/StudentDAOImpl.java: Implementation of the StudentDAO interface.
- entity/Student.java: Definition of the Student entity class.
- src/main/resources: Contains application properties
- application.properties: Configuration file for Spring Boot application.
- student_directory.sql: SQL script to initialize data.

6. **Usage**
The application is a command-line application that performs CRUD operations on the Student entity. Upon running the application, it will execute a set of tasks demonstrating the various CRUD operations.
