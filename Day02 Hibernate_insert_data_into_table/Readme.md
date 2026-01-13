# Day 2: Practical Implementation of Hibernate

## 📝 Overview

On Day 2, I implemented the core concepts of Hibernate. The goal was to configure a Maven project and save a Java Object into a MySQL database table directly, without writing manual SQL queries.

## 🛠️ Tech Stack

- **Language:** Java
- **Framework:** Hibernate Core 7.2
- **Build Tool:** Maven
- **Database:** MySQL

## 🗝️ Key Implementation Steps

### 1. Dependency Management

Updated `pom.xml` to include Hibernate Core and MySQL Connector.

- **Note:** Used `com.mysql.cj.jdbc.Driver` instead of the deprecated `com.mysql.jdbc.Driver`.

### 2. Entity Creation (POJO)

Created a `Student` class acting as the Entity.

- Variables: `id`, `full_name`, `marks` (all private).
- Methods: Public Getters and Setters.

### 3. Hibernate Configuration

Configured `hibernate.cfg.xml` with:

- Connection URL, Username, and Password.
- Dialect (MySQL).
- Mapping resource (`Student` class).

### 4. Transaction Logic (App.java)

The main logic to save data followed this flow:

1.  **Load Configuration:** `new Configuration().configure()`
2.  **Build Factory:** `config.buildSessionFactory()`
3.  **Open Session:** `factory.openSession()`
4.  **Begin Transaction:** `session.beginTransaction()`
5.  **Save Object:** `session.persist(studentObj)`
6.  **Commit:** `transaction.commit()`

## ✅ Outcome

The application successfully connected to the database, created the table (if not waiting), and inserted the student record.
