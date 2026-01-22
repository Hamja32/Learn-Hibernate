package com.UpdateUsingHibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.UpdateUsingHibernate.beans.User;
import com.UpdateUsingHibernate.provider.FactoryProvider;

public class RemoveTest {
	//METHOD 1
//	public static void main(String[] args) {
//		Session session = FactoryProvider.getSession();
//		Transaction tx = session.beginTransaction();
//		//Pehle select query run hogi session.find() ki wajah se 
//		//or agr object hoga he nhi db me to java.lang.IllegalArgumentException ye 
//		//exception show hoga
//		User user = session.find(User.class, 0);
//		if(user != null) {
//			session.remove(user);
//			System.out.println("User deleted successfully. ");
//		}else {
//			System.out.println("User not found in db. ");
//			
//		}
//	
//	
//		
//		tx.commit();
//	}
//	//METHOD 2
	//public static void main(String[] args) {
//		Session session = FactoryProvider.getSession();
//		Transaction tx = session.beginTransaction();
//		//direct delte query run hogi 
//		//kyuki isme select query nhi chalti isliye ye exception throw kr dega
//		// and exception - Unexpected row count 
//		User user = session.getReference(User.class,4);
//		session.remove(user);
//		tx.commit();
//	}
	
	//METHOD 3
	
//	public static void main(String[] args) {
//		Session session = FactoryProvider.getSession();
//		Transaction tx = session.beginTransaction();
//		//Pehle select query run hogi
//		//agr koi id us id se data nhi hua to koi exception nhi milega sirf select
//		//query chalegi
//		User user = new User();
//		user.setId(2);
//		session.remove(user);
//		tx.commit();
//	}
	
	////METHOD 4
 	//EXPERIENCE:
		/* yrr bohot mushkil se ye method mila sbse pehle session.query(query) ye use kiya to error tha ki
		 * ye to depricated hai to fir mene yaha waha search kiya tb mujhe stack overflow pr is question ka ans to mila 
		 * wo ye tha ki same method me ek aur parameter add hua hai class name - session(hql,User.class) fir jb ise run kiya
		 * to fir ek exceptin aagya :  Result type given for a non-SELECT Query [DELETE FROM User WHERE id = :id] mtlb ye ki ye 
		 * sirf select query ke liye he kam krega fir mene thodi or khoj been kri fir documentation pdha to pta chala ek or bhi method
		 * hai jo sirf update ke liye hota hai that's name is session.createMutationQuery(hql) fir ja kr code run hua
		*/
	public static void main(String[] args) {
		Session session = FactoryProvider.getSession();
		Transaction tx = session.beginTransaction();
		// HQL Query likhein
		// Note: Yahan Table name nahi, Class ka name (Student) use hoga
	
		String hql = "DELETE FROM User WHERE id = :id";
		int rowcount = session.createMutationQuery(hql).setParameter("id",3).executeUpdate();
		System.out.println("Rows affected: " + rowcount);	
		
		tx.commit();
	}
}
