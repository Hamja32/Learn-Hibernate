# 🚀 Mastering Deletion Operations in Hibernate 6

This repository documents my deep dive into **Hibernate Deletion Strategies** and **Performance Optimizations**.

Today, I explored different ways to delete data from a database using Hibernate, encountered migration challenges with Hibernate 6, and discovered optimization annotations.

## 📝 What I Learned Today

### 1. The 4 Ways to Delete Data

I experimented with four different approaches to remove an entity, analyzing their pros and cons:

| Method       | Approach                              | Verdict                                                                                           |
| :----------- | :------------------------------------ | :------------------------------------------------------------------------------------------------ |
| **Method 1** | `session.find()` + `session.remove()` | ✅ **Safest:** Checks if data exists first. Handles cascading correctly.                          |
| **Method 2** | `session.getReference()` + `remove()` | ⚠️ **Risky:** Uses proxies/lazy loading. Can throw exceptions if the ID doesn't exist.            |
| **Method 3** | New Transient Object + `remove()`     | ❌ **Not Recommended:** Manually creating an object just to delete it is not a standard practice. |
| **Method 4** | HQL (Hibernate Query Language)        | ⚡ **Fastest:** Direct DB hit. Best for bulk deletions or performance-critical tasks.             |

---

### 2. 💡 The "Aha!" Moment: Hibernate 6 Migration

The biggest challenge was implementing **Method 4 (HQL)** using Hibernate 6+.

**The Problem:**
I initially tried:

- `session.createQuery(hql)` → _Deprecated._
- `session.createQuery(hql, User.class)` → _Error: "Result type given for a non-SELECT Query"._

**The Solution:**
After digging into the documentation and StackOverflow, I learned that Hibernate 6 separates read and write operations more strictly.

- For **SELECT** queries: Use `createQuery()`
- For **UPDATE/DELETE** queries: Use **`createMutationQuery()`**

#### ✅ Working Code Snippet:

```java
// The correct way to perform DELETE/UPDATE in Hibernate 6+
String hql = "DELETE FROM User WHERE id = :id";
int rowCount = session.createMutationQuery(hql)
                      .setParameter("id", 3)
                      .executeUpdate();

System.out.println("Rows affected: " + rowCount);

```

---

### 3. Performance Annotations

Apart from deletion logic, I learned about two powerful annotations to optimize SQL generation:

- **`@DynamicInsert`**: Hibernate generates the INSERT SQL dynamically, including _only_ the non-null columns.
- **`@DynamicUpdate`**: Hibernate generates the UPDATE SQL dynamically, including _only_ the columns that have actually changed.

**Why use them?**
Instead of updating all 50 columns in a table when only 1 has changed, these annotations ensure the query is lightweight and faster.

---

### 🛠️ Tech Stack

- **Language:** Java
- **ORM:** Hibernate 6+
- **Database:** MySQL

---
