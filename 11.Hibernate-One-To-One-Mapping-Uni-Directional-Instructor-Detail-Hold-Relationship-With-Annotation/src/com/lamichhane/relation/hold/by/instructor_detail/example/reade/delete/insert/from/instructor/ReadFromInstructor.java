package com.lamichhane.relation.hold.by.instructor_detail.example.reade.delete.insert.from.instructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lamichhane.one.to.one.entity.Instructor;
import com.lamichhane.one.to.one.entity.InstructorDetail;

public class ReadFromInstructor {

	public static void main(String[] args) {
		
		
		//create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int id = 10;
			
			
			// start a transaction
		    session.beginTransaction();
						
						
			//save the instructor
		    Instructor i = session.get(Instructor.class, id);
		    System.out.println(i);
//		    System.out.println(i.getInstructorDetail());
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		}
		finally {
			factory.close();
		}

	}

}
