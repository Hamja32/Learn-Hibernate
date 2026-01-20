
```markdown
## Hibernate Utility Pattern Demo

A simple Java application demonstrating the **Hibernate Utility (Helper) Pattern** to manage SessionFactory and Session objects efficiently.



## 📋 About The Project

When working with Hibernate, creating the `SessionFactory` is an expensive process that should only happen once during application startup. This project demonstrates how to create a `HibernateUtils` class to adhere to the **DRY (Don't Repeat Yourself)** principle.

### Key Features
* **Singleton Pattern:** Ensures only one `SessionFactory` instance is created per database configuration.
* **Static Initialization:** Uses a static block to load configuration and build the factory when the class loads.
* **Resource Management:** Centralized methods to open and close Sessions safely.
* **Boilerplate Reduction:** Keeps the `App.java` (Client) code clean and focused on business logic.

## 🛠️ Technologies Used
* **Language:** Java
* **Framework:** Hibernate ORM
* **Database:** MySQL
* **Build Tool:** Maven

## 📂 Project Structure

```text
com.HibernateUtility
├── entity
│   └── Customer.java       // POJO class mapped to database table
├── utilities
│   └── HibernateUtils.java // Helper class for Session management
└── App.java                // Main class to test the implementation

```

## 💻 Code Overview

### 1. The Utility Class (`HibernateUtils.java`)

Instead of repeating configuration logic, we wrap it here:

```java
// Simplified logic
static {
    // Loads configuration and builds SessionFactory once
    factory = new Configuration().configure().buildSessionFactory();
}

public static Session getSession() {
    return factory.openSession(); // Returns a new session for operations
}

```

### 2. The Client App (`App.java`)

Notice how clean the main method becomes:

```java
public static void main(String[] args) {
    // 1. Get Session
    Session session = HibernateUtils.getSession();
    
    // 2. Perform Operation
    Transaction tx = session.beginTransaction();
    session.persist(customerObj);
    tx.commit();
    
    // 3. Close Resources
    HibernateUtils.closeSession(session);
}

```

## 🚀 How to Run

1. Clone the repository.
2. Ensure your `hibernate.cfg.xml` is configured with your MySQL credentials.
3. Run `App.java`.
4. Check your database; the `Customer` data should be inserted successfully!

---

*Learning Hibernate one step at a time!* 👨‍💻

```

### Tips for your Post:
* **Screenshot:** Take a screenshot of your Eclipse/IntelliJ code (specifically the `HibernateUtils` class) and attach it to the LinkedIn post. Visuals get more engagement!
* **Tagging:** If you are following a specific tutorial or roadmap, you can tag the creator/channel.

```
