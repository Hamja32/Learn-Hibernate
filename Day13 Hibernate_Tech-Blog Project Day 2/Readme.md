### 1. LinkedIn Post (Copy & Paste) 🚀

**Headline:** Leveling up my Java Full Stack Project: DAO Pattern & Dynamic UI! 💻🎨

**Body:**
Day 2 of building **TechBlog** from scratch! 🚀

Today was a productive session. I moved beyond just listing blogs and implemented the **Single Post View** functionality. Now, clicking "Read More" dynamically fetches the specific blog content from the database using its ID.

**👨‍💻 Technical Updates:**

- **Implemented DAO (Data Access Object) Pattern:** Instead of cluttering the JSP pages with database code, I created a `PostDao` class to handle data fetching. This keeps the code clean and follows the **Separation of Concerns** principle.
- **Hibernate `session.get()`:** optimized the way data is retrieved by Primary Key.
- **Dynamic URL Parameters:** Handling `post_id` in the URL to render specific content.

**🎨 UI/UX Improvements:**

- Redesigned the Frontend with a **Modern Dark Aesthetic** (Cyberpunk/GitHub Dark inspired).
- Added **CSS Hover Effects**: Cards now have a zoom and glow effect for a better user experience.
- Implemented **Google Fonts** (Roboto Mono & Inter) for a professional tech-doc look.

Every day, this project feels more like a real-world application. Next up: Adding the **Like & Comment** functionality! 🔥

Check out the code on GitHub 👇
[Paste Your GitHub Link Here]

#Java #Hibernate #JSP #FullStack #WebDevelopment #Coding #Project #BCA #DarkTheme #DAOPattern

---

### 2. Updated README.md

Isme maine **Project Structure** update kiya hai (kyunki ab `dao` package aa gaya hai) aur **Features** list me aaj ka kaam add kiya hai.

````markdown
# 📝 TechBlog - A Dynamic Blogging Platform

**TechBlog** is a full-stack web application built using **Java J2EE** technologies. It uses **Hibernate ORM** for efficient database management and implements the **DAO (Data Access Object)** design pattern for clean architecture.

## 🚀 Key Features

### ✅ Backend & Logic

- **User Authentication:** Secure Login & Registration with session management.
- **DAO Pattern:** Dedicated Data Access Layer (`PostDao`, `UserDao`) to separate database logic from the UI.
- **Dynamic Content:**
  - **Home Feed:** Fetches all latest blogs from MySQL.
  - **Single Post View:** Clicking "Read More" fetches the specific blog details dynamically based on Post ID.
- **Hibernate ORM:** Uses Entity mapping (`@OneToMany`, `@ManyToOne`) to link Users and Blogs.

### 🎨 UI/UX (Frontend)

- **Modern Dark Theme:** A developer-focused "Cyberpunk/GitHub Dark" aesthetic.
- **Interactive UI:**
  - **Hover Effects:** Blog cards feature zoom and glow animations.
  - **Responsive:** Fully responsive layout using Bootstrap Grid.
- **Smart Handling:**
  - **Image Fallback:** Automatically replaces broken image URLs with placeholders.
  - **Content Trimming:** Helper class to show short descriptions on the home page.

---

## 🛠️ Tech Stack

- **Backend:** Java (JDK 1.8+), JDBC, Servlet, JSP
- **ORM:** Hibernate 5.x
- **Database:** MySQL 8.0
- **Frontend:** HTML5, CSS3, Bootstrap 4
- **Design:** Custom CSS with Google Fonts (Roboto Mono, Inter)
- **Server:** Apache Tomcat 9.0

---

## 📂 Project Structure

TechBlog/
├── src/main/java/
│ ├── com.techblog.entities/ # POJO Classes (User.java, Blog.java)
│ ├── com.techblog.dao/ # Data Access Objects (PostDao.java) - _NEW_
│ ├── com.techblog.helper/ # SessionFactory Provider & String Helpers
│ └── com.techblog.servlets/ # Controllers (Login, Register, AddBlog)
├── src/main/webapp/
│ ├── css/ # Custom Dark Mode Styles
│ ├── includes/ # Navbar & Footer
│ ├── index.jsp # Home Page (Grid View)
│ ├── blog_detail.jsp # Single Post View (Dynamic)
│ ├── login.jsp # User Login
│ ├── register.jsp # User Registration
│ └── add_blog.jsp # Blog Creation Form
└── hibernate.cfg.xml # Database Configuration

```

```
````

## ⚙️ How to Run

1. **Clone the Repo:**

```bash
git clone [https://github.com/hamja32/TechBlog.git]

```

2. **Database Setup:**

- Create a database `techblog` in MySQL.
- Update `hibernate.cfg.xml` with your username/password.
- _Note: Hibernate will automatically create the tables._

3. **Run on Server:**

- Import into Eclipse/IntelliJ.
- Run on **Apache Tomcat**.
- Access at: `http://localhost:8080/TechBlog/`

---

## 👤 Author

**[Hamza Khan]**
_Computer Science Student_

```

```
