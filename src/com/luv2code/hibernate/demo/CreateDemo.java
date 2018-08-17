package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("ChadToCode", "Love To Code");
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//tempInstructorDetail.setInstructor(tempInstructor);
			// start a transaction
			session.beginTransaction();
			
			System.out.println(tempInstructor);
			System.out.println(tempInstructorDetail.getInstructor());
			// save
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}





