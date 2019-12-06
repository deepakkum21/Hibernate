package com.deepak.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.deepak.dto.FourWheeler;
import com.deepak.dto.TwoWheeler;
import com.deepak.dto.UserDetails;
import com.deepak.dto.Vehicle;

public class HibernateTest {

	public static void main(String... args) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Jaguar");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("BIKE");
		bike.setSteeringHandle("Bike Handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("CAR");
		car.setSteeringWheel("CAR STEERING");

		SessionFactory sessionFactory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		transaction.commit(); // session.getTransaction().commit();
		session.close();  // generally mentioned in finally block
		
		
	}

}
