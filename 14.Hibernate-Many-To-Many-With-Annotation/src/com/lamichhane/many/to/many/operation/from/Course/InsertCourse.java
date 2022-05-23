package com.lamichhane.many.to.many.operation.from.Course;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lamichhane.many.to.many.entity.Course;
import com.lamichhane.many.to.many.entity.Student;




public class InsertCourse {

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
								
								
					Student st1 = session.get(Student.class, 41);
					
					Course c1 = new Course("Spring frmework");
					Course c2 = new Course("Java");
					
					st1.addCourses(c1);
					st1.addCourses(c2);
							
					session.save(c1);
					session.save(c2);
				    
//				   session.save(c1);
//				   session.save(c2);
					
					
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done");
					
					
				}
				finally {
					factory.close();
				}

	}

}
