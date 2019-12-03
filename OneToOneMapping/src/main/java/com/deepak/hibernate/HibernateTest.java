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
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Jaguar");
		userDetails.setVehicle(vehicle);
		

		SessionFactory sessionFactory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(userDetails);
		session.save(vehicle);
		transaction.commit(); // session.getTransaction().commit();
		session.close();  // generally mentioned in finally block
		
		
	}

}
