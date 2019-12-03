package com.deepak.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.deepak.dto.UserDetails;

public class HibernateTest {

	public static void main(String... args) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(3);
		userDetails.setUserName("Deepak");
		userDetails.setAddress("skhgfghisdhgudz");
		userDetails.setJoinDate(new Date());
		userDetails.setDescription("lkdfjihoh8egwu[cojjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjms lzodriwsjmvs;morgioiesnhgvio'sjgopvmsd");

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
