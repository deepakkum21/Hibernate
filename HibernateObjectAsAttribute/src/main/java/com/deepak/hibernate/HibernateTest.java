package com.deepak.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.deepak.dto.Address;
import com.deepak.dto.UserDetails;

public class HibernateTest {

	public static void main(String... args) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(3);  // won't work if using @GeneratedValue over the attribute
		userDetails.setUserName("Deepak");
		
		Address address = new Address();
		address.setCity("Chennai");
		address.setPincode("600004");
		address.setState("Tamil Nadu");
		address.setStreet("Dr. RK salai");
		
		Address homeAddress = new Address();
		homeAddress.setCity("Patna");
		homeAddress.setPincode("80004");
		homeAddress.setState("Bihar");
		homeAddress.setStreet("Borin road");
		
		userDetails.setOfficeAddress(address);
		userDetails.setHomeAddress(homeAddress);
		userDetails.getListOfAddress().add(homeAddress);
		userDetails.getListOfAddress().add(address);

		SessionFactory sessionFactory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(userDetails);
		transaction.commit(); // session.getTransaction().commit();
		session.close();  // generally mentioned in finally block
		
		userDetails = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		userDetails = (UserDetails)session.get(UserDetails.class, 3);
	}

}
