package com.project.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Status;
import com.project.entity.Student;

public class CreateStudentApp {
	
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
			Student student = new Student("John", "Doe", "john@mail.co", Status.ACTIVE);
			Student student2 = new Student("Mary", "Public", "mary@mail.co", Status.INACTIVE);
			
			// Start a transaction
			session.beginTransaction();
			
			// Save the object
			System.out.println("Saving the student and address...");
			session.save(student);
			session.save(student2);
			
			// Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			session.close();
			factory.close();
		}
		
	}

}
