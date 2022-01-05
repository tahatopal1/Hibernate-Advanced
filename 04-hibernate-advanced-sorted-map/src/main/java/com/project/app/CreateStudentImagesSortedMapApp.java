package com.project.app;

import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Student;

public class CreateStudentImagesSortedMapApp {
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
			Map<String, String> images = student.getImages();
			
			images.put("photo1.jpg", "Photo 1");
			images.put("photo2.jpg", "Photo 2");
			images.put("photo3.jpg", "Photo 3");
			images.put("photo4.jpg", "Photo 4");
			
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
