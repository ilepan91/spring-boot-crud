# Basic Spring Boot CRUD Application

This repository contains a simple Spring Boot applications that demonstrate CRUD (Create, Read, Update, Delete) operations on a `Student` entity in a relational database.

## Applications
   1. **Hibernate/JPA CRUD**
      - Basic CRUD operations using Hibernate.
   
   2. **REST CRUD**
      - RESTful API for CRUD operations.
   
   3. **REST CRUD with Spring Data JPA**
      - RESTful API for CRUD operations using Spring Data JPA.
   
   4. **MVC CRUD**
      - Model-View-Controller (MVC) based CRUD operations.

## Table of Contents
- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Usage](#usage)

## Introduction

 1. **Hibernate/JPA CRUD**
The project is a Spring Boot application that provides the implementation of basic CRUD operations using Hibernate as the JPA provider for database interaction. The application includes a `Student` entity with fields like `id`, `firstName`, `lastName`, and `email`.

2. **REST CRUD**
This Spring Boot application provides CRUD operations for managing student entities. It follows a RESTful architecture, and contains StudentDAO implementation that uses the JPA EntityManager for interacting with the underlying database.

3. **REST CRUD with Spring Data JPA**
This Spring Boot application also provides CRUD operations for managing student entities. It follows a RESTful architecture, but it doesn't use StudentDAO object to manage Student entities, instead it manages Student entities by interacting with the data layer through the StudentRepository, an interface that extends the Spring Data JPA JpaRepository.

 4. **MVC CRUD**
This Spring MVC application provides a simple CRUD (Create, Read, Update, Delete) functionality for managing entities. It follows the Model-View-Controller architecture and is designed to handle web requests using Spring MVC controllers.

## Technologies Used

- Java
- Spring
- Spring Boot
- Hibernate
- Thymeleaf
- HTML (Bootstrap)
- MySQL

## Getting Started

1. **Install MySQL:**

   Download and install MySQL and MySQL Woekbench if you don't have it installed already. You can download the MySQL Community Server from the official website: [MySQL Downloads](https://dev.mysql.com/downloads/mysql/)

2. **Create a MySQL Database:**

   Open MySQL Workbench, and open `create_user.sql` script.
   After executing it, create a new connection: `springstudent`, where password should be set as `springstudent` as well.

   If you're using different connecetion and credentials then:
   - Reconfigure the application's database connection properties in the `src/main/resources/application.properties` file.
   - Update the following properties with your MySQL credentials: <br/>
   `spring.datasource.url=jdbc:mysql://localhost:3306/student_directory` <br/>
   `spring.datasource.username=your-mysql-username` <br/>
   `spring.datasource.password=your-mysql-password`

4. **Execute sql script(s) and run the application**

   - Download project to your file system or clone the repository: `git clone https://github.com/ilepan91/spring-boot-crud.git`

   **Hibernate/JPA CRUD**
   - Login in created MySQL connection with correct credentials and go to `File -> Open SQL script`. Choose `student_directory.sql` and Execute it.
   - Open _spring-boot-hibernate-jpa_ project in your IDE and run the _CrudApplication.java_
     You can also run it from the command line:
        - `cd spring-boot-hibernate-jpa/crud`
        - `./mvnw spring-boot:run` (or `mvnw spring-boot:run` for MicrosoftWin)
     
   **REST CRUD** and **REST CRUD with Spring Data JPA**
   - Login in created MySQL connection with correct credentials and go to `File -> Open SQL script`. Choose `student_directory.sql` and Execute it.
   - Open _spring-boot-rest-crud/spring-boot-rest-crud-spring-data-jpa_ project in your IDE and run the _RestCrudApplication.java_
     You can also run it from the command line:
        - `cd spring-boot-rest-crud/crud` (`cd spring-boot-rest-crud-spring-data-jpa/crud`)
        - `./mvnw spring-boot:run` (or `mvnw spring-boot:run` for MicrosoftWin)
   - Use Postman (or some other application for API testing) to test the application
     <br/>
     **API Endpoints** <br/>
     - `GET /api/students:` Get a list of all students
     - `GET /api/students/{studentId}:` Get a specific student by ID
     - `POST /api/students:` Create a new student
     - `PUT /api/students:` Update an existing student
     - `DELETE /api/students/{studentId}:` Delete a student by ID
   
   **MVC CRUD**
   - Login in created MySQL connection with correct credentials and go to File -> Open SQL scripts. Open: users_authorities.sql and student_directory.sql and execute both scripts.
   - Open _spring-boot-mvc-crud_ project in your IDE and run the _StudentsApplication.java_
   - You can also run it from the command line:
        - `cd spring-boot-mvc-crud/spring-boot-mvc-crud`
        - `./mvnw spring-boot:run` (or `mvnw spring-boot:run` for MicrosoftWin)
     
     Accessing the Application
     - Open you browser and go to the `http://localhost:8080`
     - Login credentials:
        - for Admin: `username = admin`, `password = admin123`
        - for Student: `username = student`, `password = student123`
     - Try adding, updating and deleting students.    

6. **Usage**
   
**Hibernate/JPA CRUD**
The application is a command-line application that performs CRUD operations on the Student entity. Upon running the application, it will execute a set of tasks demonstrating the various CRUD operations.

**REST CRUD** and **REST CRUD with Spring Data JPA**
The application is a RESTful web service that provides endpoints for performing CRUD operations on the Student entity. After starting the application, you can interact with endpoints (listed in previous section) using tools like Postman or cURL to demonstrate various CRUD operations.

**MVC CRUD**
The application is a web-based system following the Model-View-Controller (MVC) architectural pattern for managing student information. It provides a user interface for performing CRUD operations on student records. Upon starting the application, you can access the web interface to create, read, update, and delete student records.
