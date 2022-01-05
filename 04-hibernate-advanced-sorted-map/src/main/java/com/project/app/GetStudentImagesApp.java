package com.project.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Student;

public class GetStudentImagesApp {
	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Get the student id
			int id = 101;
			Student student = session.get(Student.class, id);
			
			// Print the student detail
			System.out.println("Student details: " + student);
			
			// Print the associated images
			student.getImages()
					.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
			
			// Commit the transaction
			session.getTransaction().commit();
			
			// Done
			System.out.println("Done!");
			
		}finally {
			
			// Close the transaction
			session.close();
			factory.close();
			
		}
		
	}
}
