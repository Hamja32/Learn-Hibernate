````markdown
# 📝 TechBlog - A Dynamic Blogging Platform

**TechBlog** is a full-stack web application built using **Java J2EE** technologies. It allows users to create accounts, publish blogs with image URLs, and read content dynamically fetched from the database. The project focuses on implementing **ORM (Object-Relational Mapping)** using Hibernate for efficient database management.

---

## 🚀 Features (Implemented So Far)

### 1. User Authentication

- **Registration:** Users can create an account with Name, Email, Password, Gender, and About.
- **Login:** Secure login system with session management.
- **Logout:** Proper session invalidation.

### 2. Blog Management

- **Create Post:** Logged-in users can write blogs with a Title, Content, and an Image URL.
- **Dynamic Feed:** The Home page automatically fetches and displays the latest blogs from the database.
- **Author Mapping:** Every blog is linked to its specific author (User) using Hibernate Relationships (`@ManyToOne`).

### 3. UI/UX

- **Responsive Design:** Clean card-based layout using CSS Grid.
- **Dynamic Navbar:** Menu options change based on login status (e.g., shows "Logout" only when logged in).
- **Error Handling:** Image placeholders for broken URLs to prevent UI breakage.

---

## 🛠️ Tech Stack

- **Backend:** Java (JDK 1.8+), JDBC, Servlet, JSP
- **Framework:** Hibernate (ORM) 5.x
- **Database:** MySQL 8.0
- **Frontend:** HTML5, CSS3, Bootstrap (optional/custom)
- **Server:** Apache Tomcat 9.0
- **Build Tool:** Maven

---

## ⚙️ Setup & Installation

Follow these steps to run the project locally:

### 1. Clone the Repository

```bash
git clone [https://github.com/hamja32/TechBlog.git]
```
````

### 2. Configure Database

1. Open MySQL Workbench/Command Line.
2. Create a database named `techblog`.

```sql
CREATE DATABASE techblog;

```

_(Note: You don't need to create tables manually. Hibernate `hbm2ddl.auto` will generate `user` and `posts` tables automatically)._

### 3. Update Hibernate Configuration

Navigate to `src/main/java/hibernate.cfg.xml` (or `src/main/resources`) and update your MySQL username and password:

```xml
<property name="connection.username">root</property>
<property name="connection.password">YOUR_PASSWORD</property>

```

### 4. Run on Server

1. Import the project into **Eclipse Enterprise** or **IntelliJ IDEA**.
2. Right-click on the project > **Run As** > **Run on Server**.
3. Select **Tomcat Server** and finish.
4. The app will launch at: `http://localhost:8080/TechBlog/`

---

## 📂 Project Structure

```text
TechBlog/
├── src/main/java/
│   ├── com.techblog.entities/    # POJO Classes (User.java, Blog.java)
│   ├── com.techblog.helper/      # SessionFactory Provider & String Helpers
│   └── com.techblog.servlets/    # Login, Register, AddBlog Logic
├── src/main/webapp/
│   ├── css/                      # External Styling
│   ├── includes/                 # Reusable components (navbar.jsp)
│   ├── index.jsp                 # Home Page (Blog Feed)
│   ├── login.jsp                 # User Login
│   ├── register.jsp              # User Registration
│   └── add_blog.jsp              # Blog Creation Form
└── hibernate.cfg.xml             # Database Configuration

```

---

## 🔮 Future Scope (To-Do)

- [ ] Implement **Like** functionality on blogs.
- [ ] Add **Comment System** for user interaction.
- [ ] Profile page to edit user details.
- [ ] Admin panel for managing content.
- [ ] File upload support (local storage).

---

## 👤 Author

**Hamza Khan** _Computer Science Student & Developer_ https://www.linkedin.com/in/hamja-khan/

---

```

```
