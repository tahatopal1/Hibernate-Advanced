package com.project.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Address;
import com.project.entity.Student;

public class CreateStudentApp {
	
	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.addAnnotatedClass(Address.class)
											.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// Create the object
			Student student = new Student("John", "Doe", "john@mail.co");
			
			// Create the address object
			Address address = new Address("Some Street", "Some City", "12345");
			
			// Create the billing address object
			Address billingAddress = new Address("Some Street", "Some City", "12345");
			
			// Start a transaction
			session.beginTransaction();
			
			// Save the object
			System.out.println("Saving the student and address...");
			student.setAddress(address);
			student.setBillingAddress(billingAddress);
			session.save(student);
			
			// Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			session.close();
			factory.close();
		}
		
	}

}
