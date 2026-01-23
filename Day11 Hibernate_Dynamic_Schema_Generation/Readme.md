````markdown
# 🚀 Hibernate Dynamic Schema Generation

## 📖 Overview

This project/module demonstrates **Dynamic Schema Generation** in Hibernate. It explores how Hibernate can automatically manage database tables (DDL) using the `hbm2ddl.auto` property in the configuration file.

Understanding these properties is crucial for managing the database lifecycle efficiently during development, testing, and production.

---

## ⚙️ Configuration

The property is configured in `hibernate.cfg.xml` or `application.properties`:

**XML Configuration:**

```xml
<property name="hbm2ddl.auto">update</property>
```
````

**Spring Boot Properties:**

```properties
spring.jpa.hibernate.ddl-auto=update

```

---

## 🛠️ The 4 Key Strategies (`hbm2ddl.auto`)

Here is a detailed breakdown of the available options and their behaviors:

### 1️⃣ Create (`create`)

> `<property name="hbm2ddl.auto">create</property>`

- **Behavior:**
- It always creates a new database table based on the Hibernate mapping file info.
- **⚠️ Warning:** If the table already exists, it will **delete (drop)** the existing table first and then create a fresh one. Data will be lost!
- Internally uses the Schema Export tool.

- **When to use:**
- Initial development phase.
- Long-running applications that rarely restart.
- Applications where data persistence across restarts is not required (e.g., specific ticketing queues).

### 2️⃣ Update (`update`) - _Most Commonly Used_

> `<property name="hbm2ddl.auto">update</property>`

- **Behavior:**
- Internally uses the `SchemaUpdate` tool.
- If the table does not exist, it creates it.
- If the table exists (matching the `<class>` mapping), it **alters** the table to add missing columns/constraints without deleting existing data.

- **When to use:**
- **Development & Local Testing.** This is the preferred mode for developers as it keeps data intact while evolving the schema.

### 3️⃣ Validate (`validate`) - _Production Safe_

> `<property name="hbm2ddl.auto">validate</property>`

- **Behavior:**
- Verifies whether the database table exists and matches the mapping configuration.
- **Does NOT** create or alter tables.
- **Exception:** Throws `SchemaManagementException` if tables/columns are missing or data types don't match.

- **When to use:**
- **Production Environment.** Strictly recommended for production to prevent accidental schema modification or data loss.

### 4️⃣ Create-Drop (`create-drop`)

> `<property name="hbm2ddl.auto">create-drop</property>`

- **Behavior:**
- Creates the database schema when the `SessionFactory` is created.
- **Drops (Deletes)** the schema when the `SessionFactory` is closed (application shutdown).

- **When to use:**
- **Unit Testing & Demos.**
- User Acceptance Testing (UAT) where data is only needed temporarily for the session.

---

## 📊 Quick Comparison

| Mode            | On Startup         | On Shutdown  | Data Safe? | Use Case            |
| --------------- | ------------------ | ------------ | ---------- | ------------------- |
| **create**      | Drops & Re-creates | Nothing      | ❌ No      | Initial Dev / Reset |
| **update**      | Updates Schema     | Nothing      | ✅ Yes     | Daily Dev           |
| **validate**    | Checks Schema      | Nothing      | ✅ Yes     | **Production**      |
| **create-drop** | Creates            | Drops Schema | ❌ No      | Testing / CI-CD     |

---

## 💻 Tech Stack

- **Language:** Java
- **ORM:** Hibernate
- **Database:** MySQL

---

```

```
