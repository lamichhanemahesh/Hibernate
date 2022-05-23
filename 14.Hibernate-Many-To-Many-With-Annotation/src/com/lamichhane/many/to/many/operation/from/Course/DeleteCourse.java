package com.lamichhane.many.to.many.operation.from.Course;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lamichhane.many.to.many.entity.Course;
import com.lamichhane.many.to.many.entity.Student;




public class DeleteCourse {

	public static void main(String[] args) {
		
		//create session factory
				SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Course.class)
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try {
					
					
					
					
					// start a transaction
				    session.beginTransaction();
				    
				    Course st = session.get(Course.class, 43);
								
								
				    session.delete(st);
					
					
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done");
					
					
				}
				finally {
					factory.close();
				}

	}

}
