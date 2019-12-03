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
		// by default hibernate uses lazy loading i.e. it loads 1st level of variable oncall and loads other level depending on the usage of the member
		// it loads on userDetails with userId =1
		userDetails = (UserDetails)session.get(UserDetails.class, 1);
		
		
		// hibernate loads list of addresses from the address table
		// for lazy loading => hibernate uses a proxy class which has all the methods that a mapped class is having, all the 1st level variable getters call the parent class method
		// and the list variable calls the db to get data and then call the parent class getter.
		
		// if the session is closed before getting the list of the Address, then error will come like session is closed or no session
		System.out.println(userDetails.getListOfAddress().size());
		
		
		
	}

}
