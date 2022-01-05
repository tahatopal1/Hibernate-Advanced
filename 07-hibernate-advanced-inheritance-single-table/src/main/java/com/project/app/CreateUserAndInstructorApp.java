package com.project.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Instructor;
import com.project.entity.Student;
import com.project.entity.User;

public class CreateUserAndInstructorApp {
	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.addAnnotatedClass(Instructor.class)
											.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// Create the object
			User student = new Student("John", "Doe", "john@mail.co", "Hibernate");
			Instructor instructor = new Instructor("Mary", "Public", "mary@mail.co", 20000.00);
			
			// Start a transaction
			session.beginTransaction();
			
			// Save the object
			System.out.println("Saving the student and address...");
			session.save(student);
			session.save(instructor);
			
			// Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			session.close();
			factory.close();
		}
		
	}
}
