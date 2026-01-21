````markdown
# Hibernate 7.2 Data Update Strategies 🚀

This project demonstrates how to perform update operations in **Hibernate 7.2** using two different approaches: **Total Object Update** and **Partial Record Modification** (Automatic Dirty Checking).

It highlights the efficiency of Hibernate's persistence context in handling data synchronization without explicit update method calls.

## 🛠️ Tech Stack

- **Language:** Java
- **ORM Framework:** Hibernate Core 7.2
- **Database:** MySQL
- **Build Tool:** Maven

## 📂 Project Structure

```text
src/main/java
└── com.UpdateUsingHibernate
    ├── beans
    │   └── User.java           // Entity Class
    ├── provider
    │   └── FactoryProvider.java // Hibernate Configuration
    └── UpdateTest.java         // Main logic for Update Operations
```
````

## 💡 Key Concepts Learned

### 1. Approach 1: Total Object Update (`session.merge()`)

Used when we need to update the **entire object** or when the object is in a _detached_ state.

- **Process:** Create a new object instance -> Set all properties -> Call `session.merge()`.
- **Drawback:** Requires setting all fields; otherwise, null values might overwrite existing data.

### 2. Approach 2: Partial Modification (Automatic Dirty Checking) ✨

Used when we want to modify **specific columns** (e.g., only changing the Name) without touching other fields.

- **Process:** 1. Load the object using `session.find()`.

2. Modify the field using setters (e.g., `user.setName("Shaan")`).
3. Commit the transaction (`tx.commit()`).

- **Benefit:** No need to call `update()` or `merge()`. Hibernate detects the changes in the persistent object and automatically synchronizes with the database.

## 📝 Code Snippet (Partial Update)

```java
Session session = FactoryProvider.getSession();
Transaction tx = session.beginTransaction();

// 1. Fetch the object (Persistent State)
User user = session.find(User.class, 3);

if(user != null) {
    // 2. Modify only what is needed
    user.setName("Shaan");

    // Note: No explicit session.update() or merge() needed here!
} else {
    System.out.println("Object not found");
}

// 3. Commit - Hibernate fires the UPDATE query automatically
tx.commit();

```

## ⚙️ How to Run

1. Configure your `hibernate.cfg.xml` with your MySQL database credentials.
2. Create the `users` table or let Hibernate `hbm2ddl.auto` create it.
3. Run the `UpdateTest.java` file.

## 👤 Author

**Hamza Khan** _Computer Teacher & Full Stack Java Developer_

```


```
