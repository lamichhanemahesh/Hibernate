package com.lamichhane.relation.hold.by.instructor.example.read.delete.insert.from.instructor_detail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lamichhane.one.to.one.entity.Instructor;
import com.lamichhane.one.to.one.entity.InstructorDetail;

public class DeleteFromInstructorDetail {

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
					
					int id = 9;
					
					
					// start a transaction
				    session.beginTransaction();
								
								
					//save the instructor
				    InstructorDetail i = session.get(InstructorDetail.class, id);
				    session.delete(i);
					
					
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done");
					
					
				}
				finally {
					factory.close();
				}

	}

}
