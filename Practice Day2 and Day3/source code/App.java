package com.learnHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {
	public static void main(String[] args) {

//		For insertion data into table

//		User user = new User();
//		user.setId(1);
//		user.setName("Hamza");
//		user.setEmail("Hamza@gmail.com");
//		user.setPassword("1234");
//		user.setAbout("This is hamza");

		Configuration config = new Configuration();
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		try {
			config.addAnnotatedClass(com.learnHibernate.User.class);
			config.configure();

			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			// For showing tables data
			List<User> list = session.createQuery("FROM User", User.class).getResultList();
			for (User u : list) {
				System.out.println(u);
			}

			// For saving data into table
//			session.persist(user);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
}
