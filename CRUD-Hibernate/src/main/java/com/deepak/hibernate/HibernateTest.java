package com.deepak.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.deepak.dto.UserDetails;

public class HibernateTest {

	public static void main(String... args) {
		SessionFactory sessionFactory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		for(int i=1; i<=10; i++) {
			UserDetails userDetails = new UserDetails();
			userDetails.setUserName("userDetail" + i);
			session.save(userDetails);
		}
		
		UserDetails user = new UserDetails();
		user = (UserDetails)session.get(UserDetails.class, 8);
		System.out.println(user.getUserName());
		session.delete(user);
		transaction.commit(); // session.getTransaction().commit();
		session.close();  // generally mentioned in finally block
		
		
	}

}
