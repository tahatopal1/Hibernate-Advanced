package com.project.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Student;

public class CreateStudentTokensListApp {
	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		
		// Create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// Create the object
			Student student = new Student("John", "Doe", "john@mail.com");
			List<String> tokens = student.getTokens();
			
			tokens.add("photo1.jpg");
			tokens.add("photo2.jpg");
			tokens.add("photo3.jpg");
			tokens.add("photo4.jpg");
			tokens.add("photo4.jpg"); // Duplicate
			
			// Start the transaction
			session.beginTransaction();
			
			// Save the object
			System.out.println("Saving the student and tokens");
			session.persist(student);
			
			// Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			// Clean up code
			session.close();
			factory.close();
			
		}
		
	}


}
