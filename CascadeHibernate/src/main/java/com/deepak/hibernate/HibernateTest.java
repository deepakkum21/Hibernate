package com.deepak.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.deepak.dto.UserDetails;
import com.deepak.dto.Vehicle;

public class HibernateTest {

	public static void main(String... args) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(3);  // won't work if using @GeneratedValue over the attribute
		userDetails.setUserName("Deepak");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Jaguar");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jaguar"); 
		
		userDetails.getVehicle().add(vehicle1);
		userDetails.getVehicle().add(vehicle2);
		

		SessionFactory sessionFactory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		// session.save(userDetails);
		session.persist(userDetails);
		// session.save(vehicle1);
		// session.save(vehicle2);
		transaction.commit(); // session.getTransaction().commit();
		session.close();  // generally mentioned in finally block
		
		
	}

}
