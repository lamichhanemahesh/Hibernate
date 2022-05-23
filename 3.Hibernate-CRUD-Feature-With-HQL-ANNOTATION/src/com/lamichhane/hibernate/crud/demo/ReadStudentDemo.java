package com.lamichhane.hibernate.crud.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try {
					
//					// creeate a student object
//					System.out.println("Creating new student object..");
//					Student tempStudent = new Student("Mahesh","Lamichhane","mahesh@luv2code.com");
//					System.out.println(tempStudent);
//					
//					// start a transaction
//					session.beginTransaction();
//					
//					// save the student object
//					System.out.println("Saving the student...");
//					session.save(tempStudent);
					
//					//commit transaction
//					session.getTransaction().commit();
					
					// MY NEW CODE
					
					
					
					
					// now get a new session and start transaction
					session = factory.getCurrentSession();
					session.beginTransaction();
					
					// retrieve student based on the id: primary key
					System.out.println("Getting student with id 35");
					Student myStudent = session.get(Student.class, 35);
					System.out.println("Get complete:"+myStudent);
					
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					
					// retrieve all student
					System.out.println("Getting all  the student...");
					List<Student> theStudents = session.createQuery("from Student").getResultList();
					for(Student s : theStudents) {
						System.out.println(s);
					}
					
					
					
					
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					
					// retrieve all students whoose email like gmail.com
					System.out.println("Getting all  the student with email gmail.com  ...");
					List<Student> theStudents2 = session.createQuery("from Student s where"+" s.email like '%gmail.com'").getResultList();
					for(Student s : theStudents2) {
						System.out.println(s);
					}
					
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					
					// retrieve all students with first name Mahesh or last name Sharma
					System.out.println("Getting all  the student with first  name Mahesh or last name Sharma ...");
					List<Student> theStudents3 = session.createQuery("from Student s where s.firstName='Mahesh' OR s.lastName='Sharma'").getResultList();
					for(Student s : theStudents3) {
						System.out.println(s);
					}
					
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					
					
					//retrieve all student with name Mahesh
					System.out.println("Getting all  the student with name Mahesh ...");
					List<Student> theStudent4 = session.createQuery("from Student s where s.firstName='Mahesh'").getResultList();
					for(Student s : theStudent4) {
						System.out.println(s);
					}
					
					
					// commit the transaction
					session.getTransaction().commit();
					System.out.println("Done");
					
					
				}
				finally {
					factory.close();
				}

	}

}
