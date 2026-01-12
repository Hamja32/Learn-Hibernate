# Day 1: Introduction to Hibernate & ORM

## What I Learned

Today I started learning Hibernate. Here are the key concepts:

### 1. ORM (Object Relational Mapping)

It maps Java Objects to Database Tables.

- **Class** -> Table
- **Object** -> Row
- **Variable** -> Column

### 2. Hibernate Framework

Hibernate is an ORM tool that implements JPA. It allows us to save objects directly using methods like `save()`.

### 3. Configuration Steps

1. **Maven:** Used for dependencies.
2. **hibernate.cfg.xml:** Created in `src/main/resources`. Contains DB URL, Driver, User, Pass.
3. **Session Factory:** Reads config and creates sessions.

### Code Snippet (How to save)

```Java
Session session = factory.openSession();
Transaction tx = session.beginTransaction();

Student st = new Student();
st.setId(101);
st.setName("Rakesh");

session.save(st); // Saves directly to DB!
tx.commit();
session.close();
```
