````markdown
# 📘 Hibernate 7.2 Practice: Modern CRUD Operations

### 🚀 Overview

This repository documents my progression in learning **Hibernate 7.2 (ORM)**.
The focus of this project is to implement database operations using the **latest JPA-compliant methods**, moving away from deprecated Hibernate-native methods (like `save`) towards modern standards (like `persist`).

### 🛠️ Tech Stack

- **Language:** Java (JDK 17+)
- **Framework:** Hibernate 7.2
- **Database:** MySQL
- **Build Tool:** Maven

---

### 📝 Key Concepts & Modern Implementations

#### 1. Modern Persistence (`session.persist`)

In Hibernate 7, the focus is on JPA compliance. Instead of using the deprecated `save()` method, I implemented `session.persist()`.

- **Why?** `persist` is part of the JPA specification, making the code more portable and strictly defined within the persistence context.

#### 2. Querying with HQL (Hibernate Query Language)

Instead of fetching objects one by one, I utilized **HQL** to retrieve lists of data efficiently.

- Used `session.createQuery()` with type-safety.
- Used `.getResultList()` instead of the old `.list()` method.

#### 3. Transaction & Session Management

Implemented robust resource management using `try-catch-finally` blocks to ensure `Session` and `Transaction` objects are handled correctly to prevent memory leaks.

---

### 💻 Code Snippets

#### A. Configuration & Session Factory

Setting up the connection and mapping the annotated class programmatically.

```java
Configuration config = new Configuration();
config.addAnnotatedClass(com.learnHibernate.User.class);
config.configure();

SessionFactory sessionFactory = config.buildSessionFactory();
Session session = sessionFactory.openSession();
```
````

#### B. Saving Data (The Modern Way)

Using `persist()` to insert data into the database within a transaction.

```java
Transaction transaction = session.beginTransaction();

User user = new User();
user.setName("Hamza");
user.setEmail("hamza@example.com");
user.setId(1);
user.setPassword("1234");
user.setAbout("This is hamza khan");

// Using persist() instead of save()
session.persist(user);

transaction.commit();

```

#### C. Fetching Data using HQL

Retrieving a list of all users using Type-Safe HQL.

```java
// "FROM User" refers to the Class Name, not the table name
List<User> list = session.createQuery("FROM User", User.class).getResultList();

for (User u : list) {
    System.out.println(u);
}

```

---

### ⚙️ Setup Instructions

1. **Clone the repository.**
2. **Configure Database:** Update the `hibernate.cfg.xml` file with your MySQL username and password.
3. **Run the App:** Execute `App.java`. Hibernate will automatically generate the tables (if `hbm2ddl.auto` is set to `update` or `create`).

---
