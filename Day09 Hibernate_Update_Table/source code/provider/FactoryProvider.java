public package com.UpdateUsingHibernate.provider;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.UpdateUsingHibernate.beans.User;

public class FactoryProvider {
	private static SessionFactory factory;

	static {
		Configuration cfg;
		try {
			cfg = new Configuration();
			cfg.configure().addAnnotatedClass(User.class);

			factory = cfg.buildSessionFactory();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession() {
		return factory.openSession();
	}
	
	public static void closeSession(Session s) {
		if(s != null) {
			s.close();
		}
	}
	public static void closeSessionFactory() {
		if(factory != null) {
			factory.close();
		}
	}
}
 FactoryProvider {
    
}
