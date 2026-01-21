package com.UpdateUsingHibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.UpdateUsingHibernate.beans.User;
import com.UpdateUsingHibernate.provider.FactoryProvider;

public class UpdateTest {
//Update : Using Approach 1 : where total or complete object will be update

//	public static void main(String[] args) {
//		User user = new User();
//		user.setId(1);
//		user.setName("HK");
//		user.setEmail("DevHamza@gmai.com");
//		user.setPassword("0000");
//		user.setAbout("Hii my name is hamza khan");
//
//		Session session = FactoryProvider.getSession();
//		Transaction tx = session.beginTransaction();
//		session.merge(user);
//		tx.commit();
//
//	}

	
	

	
// Update : Using Approach 2 : Partial Object / record modification : Here we don't need to pass the values old values for the properties that we do not want to update

//Benefit : If we modify the loaded object in transaction then its modification with db table record is synched automatically
	
// so there is no need to call session.merge() method we simply just need to call tx.commit()

	public static void main(String[] args) {
		Session session = FactoryProvider.getSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.find(User.class, 3);
		if(user != null) {
			user.setName("Shaan");
		}else {
			System.out.println("Object not found");
		}
		
		tx.commit();
	}
}







