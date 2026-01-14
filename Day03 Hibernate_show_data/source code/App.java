package com.hiber.hibernate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
// select operation using hibernate 
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
			List<Student> list = session.createQuery("FROM Student", Student.class).getResultList();
	        for (Student s : list) {
                System.out.println(s);
            }
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
