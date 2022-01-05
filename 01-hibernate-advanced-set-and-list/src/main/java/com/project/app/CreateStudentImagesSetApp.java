package com.project.app;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Student;

public class CreateStudentImagesSetApp {
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
			Student student = new Student("Paul", "Wall", "paul@mail.com");
			Set<String> images = student.getImages();
			
			images.add("photo1.jpg");
			images.add("photo2.jpg");
			images.add("photo3.jpg");
			images.add("photo4.jpg");
			images.add("photo5.jpg");
			
			// Start the transaction
			session.beginTransaction();
			
			// Save the object
			System.out.println("Saving the student and images");
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
