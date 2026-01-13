package com.hiber.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Student st1 = new Student();
		st1.setId(1);
		st1.setName("Rohit");
		st1.setMarks(90);

		Configuration config = new Configuration();
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;

		try {
			config.addAnnotatedClass(com.hiber.hibernate.Student.class);
			config.configure();

			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(st1);
			transaction.commit();
			
			System.out.print("Data stored successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}

	}
}
