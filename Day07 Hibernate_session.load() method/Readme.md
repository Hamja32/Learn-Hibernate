


```markdown

#Link of the project : https://github.com/Hamja32/HIbernateSimpleLoadProject

# Hibernate Deep Dive: session.get() vs session.load()

This repository explores the internal working of object retrieval in Hibernate, focusing on Eager vs. Lazy loading, Proxy patterns, and Query Generation strategies.

## 🚀 Key Differences

### 1. session.get(Class, Serializable id) [Deprecated]
* **Loading:** Performs **Eager Loading**.
* **Behavior:** The database is queried immediately when the method is called, regardless of whether the object is used or not.
* **Result:** Returns the actual object or `null` if not found.

### 2. session.load(Class, Serializable id)
* **Loading:** Performs **Lazy Loading** (default behavior).
* **Internal Working:** It uses the **Proxy Design Pattern**.
    * It returns a **Proxy Object** (a placeholder) instead of the database row.
    * The actual database call happens only when a method/property of the object is accessed.
* **Configuration:**
    * If `lazy='true'` (attribute) is used -> **Lazy Loading**.
    * Else -> **Eager Loading**.
* **Exception:** Throws `ObjectNotFoundException` if the data is missing when accessed.

---

## 🧠 Internal Concepts & Query Generation

### Dynamic vs. Pre-generated Queries
A common misconception is that Hibernate always generates queries dynamically.
* **Single Row Operations (`get`, `load`):** Select and Delete queries are **NOT** generated dynamically. They are **Pre-generated** queries (created at session factory startup) to improve speed.
* **Bulk Operations:** Dynamic query generation happens when using **HQL, NativeSQL, or Criteria API**.

### Criteria for Operations
* **Single Row Operations:** Always take the **Identity Value** (Primary Key) as the criteria value.
* **Bulk Operations:** If you want to retrieve or modify data based on non-primary key columns or in bulk, you strictly need to use HQL, Native SQL, or Criteria API.

---

## 💻 Usage Examples



### 1. Lazy Loading with session.load()
```java
// Returns a Proxy. No DB hit yet.
Student s = session.load(Student.class, 101);

// DB Hit occurs here (Lazy Initialization)
System.out.println(s.getName()); 

```

### 2. Eager Loading with session.get()

```java
// Hit DB immediately. 
Student s = session.get(Student.class, 101); 

```

## 📝 Summary

| Feature | session.get() | session.load() |
| --- | --- | --- |
| **State** | Deprecated / Eager | Active / Lazy |
| **DB Access** | Immediate | On-demand (when accessed) |
| **Return Type** | Real Object | Proxy Object |
| **If ID Missing** | Returns `null` | Throws `ObjectNotFoundException` |

```
