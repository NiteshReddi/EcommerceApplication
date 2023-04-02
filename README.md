# EcommerceApplication
# Simple Backend eCommerce Application with SpringBoot and MySQL as database.

This example app shows a simple eCommerce Application. Developed RestFul APIs using Spring Boot, JPA to interact with database, JMS, ActiveMQ to communicate between different microservices

**Tools:** For this project it was necessary to use tools such as those shown below.

- **Language:** Java
- **Framework backend:** SpringBoot with Maven
- **CRUD operations:** PostMan

**Objective:** Make an application for a product and customer data with the backend applying micro service patterns.

**Prerequisites:** [Java 11](https://download.java.net/openjdk/jdk11/ri/openjdk-11+28_windows-x64_bin.zip),[PostMan](https://dl.pstmn.io/download/latest/win64), and [Mysql Server 5.7](https://dev.mysql.com/downloads/windows/installer/5.7.html).

- [Getting Started](#getting-started)
- [Modules Description](#modules-description)
- [Links](#links)

## Getting Started

To install this application, run the following commands:

```bash
git clone https://github.com/NiteshReddi/EcommerceApplication.git spring-boot-ecommerce
cd EcommerceApplication
```

This will get a copy of the project installed locally. To configure all of its dependencies and start each app, follow the instructions below.

### Configure Database

Once MySQL is installed you must configure a username and password. By default the user and password should be `root` . If not, you must configure in the file `application.configure` located in the path `src/main/resources/`.

In the file `application.configure` you must edit the parameters `spring.datasource.username` and `spring.datasource.password` with the values you defined.

### Create Database & Tables

Now you just need to create the database where the project will store the information. To create it, just follow the steps below.

```bash
mysql -u {username} -p
```

This command will ask for your MySQL password. Once inside the MySQL monitor you can create the database with the following command.

```SQL
CREATE DATABASE ecommerce;
```

Now you can run the server which generates the database tables. To run the server, run:

```bash
./mvnw spring-boot:run
```

### Create admin user

Before continuing you must create the user `admin`, in order to perform administrator operations in the application. For this you must create a user on the MySQL monitor with the following command.

```SQL
USE ecommerce;
INSERT INTO user (username, email, is_admin, password) values ('{admin.username}', '{admin.email}', true, '{admin.password}');
```

## Module Description

1)EmailNotifications:  This module uses email services and sends emails to customers.
In the file `application.configure` you must edit the parameters `spring.mail.host`, `spring.mail.username`, `spring.mail.password`, and `spring.mail.port` with the values you defined.

2)Java-mysql-integration: This module uses the Customers, Order and Product tables in MySQL DATABASE. Using PostMan with appropriate endpoints can perform CRUD operations on respective tables.

3)SpringBoot: JMS along with ActiveMQ is configured in this module.

4)ecomm-order-config: This module is to track the payment and status of orders.

5)order-rest-api: To Validate and View different data related to the customers, payment, product and order.

6)promotions: This module is to send promotional emails to registered customers based on discounts mentioned on different products.

## Links

This example uses the following open source libraries:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [PostMan](https://www.postman.com)
