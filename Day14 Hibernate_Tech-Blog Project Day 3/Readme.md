# 📘 TechBlog – Java & Hibernate Logic Notes

> This file documents the **core backend logic and architectural learnings** I implemented while building the TechBlog project using Java, JSP, Servlets, and Hibernate.

---

## 1️⃣ Session-Based User Handling (Core Security Logic)

### ❌ Problem

Initially, user data was fetched using `uid` from the URL, which can be **manipulated easily**.

### ✅ Solution

Always rely on the **session-stored authenticated user**, not request parameters.

### 🔹 Code

```java
User user = (User) session.getAttribute("currentUser");

if (user == null) {
    response.sendRedirect("login.jsp");
    return;
}
```

### 🧠 Logic

- Session represents the **logged-in identity**
- Prevents unauthorized access
- Ensures correct data ownership

---

## 2️⃣ Fetching User-Specific Posts Using DAO Pattern

### ❌ Problem

Avoid writing SQL or Hibernate logic directly in JSP pages.

### ✅ Solution

Move all database logic to **DAO layer**.

### 🔹 DAO Method

```java
public static List<Blog> getPostsByUser(User user) {
    Session session = FactoryProvider.getSession();
    Query<Blog> q = session.createQuery(
        "FROM Blog b WHERE b.user = :user ORDER BY b.pid DESC",
        Blog.class
    );
    q.setParameter("user", user);

    List<Blog> list = q.list();
    session.close();
    return list;
}
```

### 🧠 Logic

- Clean separation of concerns
- JSP only handles rendering
- DAO handles database interaction

---

## 3️⃣ Hibernate Entity Relationship (Many-To-One)

### 🔹 Blog Entity

```java
@ManyToOne
@JoinColumn(name = "uid")
private User user;
```

### 🧠 Logic

- One User → Many Blogs
- Hibernate automatically manages foreign keys
- Enables queries like:

```sql
FROM Blog WHERE user = :user
```

---

## 4️⃣ Preventing Flash of Unstyled Content (FOUC)

### ❌ Problem

User profile page loaded raw HTML first, then CSS after 1–2 seconds.

### 🧠 Root Cause

- JSP include executed before CSS loaded
- CSS placed after heavy JSP logic

### ✅ Fix Strategy

- Load all CSS inside `<head>`
- Keep JSP includes inside `<body>`
- Avoid blocking inline styles

### 🔹 Correct Structure

```html
<head>
  <link rel="stylesheet" href="bootstrap.css" />
  <link rel="stylesheet" href="style.css" />
</head>
<body>
  <%@ include file="navbar.jsp" %>
</body>
```

---

## 5️⃣ Safe Content Rendering in JSP

### ❌ Problem

Long blog content breaks UI layout.

### ✅ Solution

Limit content length safely.

### 🔹 Code

```jsp
<%= b.getpContent().substring(
    0, Math.min(150, b.getpContent().length())
) %>...
```

### 🧠 Logic

- Prevents `StringIndexOutOfBoundsException`
- Maintains UI consistency

---

## 6️⃣ Hibernate Count Logic (Efficient Database Operation)

### ❌ Bad Practice

Counting likes or posts using Java loops.

### ✅ Correct Approach

Use database aggregation.

### 🔹 Code

```java
Query<Long> q = session.createQuery(
    "select count(b) from Blog b where b.user = :user",
    Long.class
);
q.setParameter("user", user);
Long count = q.uniqueResult();
```

### 🧠 Logic

- Database is optimized for counting
- Faster and scalable

---

## 7️⃣ Toggle Logic Pattern (Like / Unlike Concept)

### 🔹 Core Idea

One function handles both add & remove logic.

### 🔹 Code

```java
PostLike existing = getLikeByUserAndPost(session, user, post);

if (existing != null) {
    session.remove(existing);
} else {
    PostLike pl = new PostLike();
    pl.setUser(user);
    pl.setPost(post);
    session.persist(pl);
}
```

### 🧠 Logic

- Reduces duplicate code
- Cleaner control flow
- Industry-used pattern

---

## 8️⃣ JSP Is for View, Java Is for Logic

### ❌ What to Avoid

- Queries in JSP
- Business logic in HTML

### ✅ Correct Flow

```
JSP → Servlet → DAO → Database
DAO → Servlet → JSP
```

### 🧠 Benefit

- Easy debugging
- Clean MVC structure
- Interview-friendly architecture

---

## 🧠 Final Takeaway

This project helped me understand that:

- Bugs are **logic problems**, not just UI issues
- Session handling is critical for security
- Hibernate relationships simplify complex queries
- Clean architecture matters more than features

---

## 👤 Author

**Hamza Khan**
Java & Web Developer
🔗 LinkedIn: [https://www.linkedin.com/in/hamja-khan-982621265/]

---
