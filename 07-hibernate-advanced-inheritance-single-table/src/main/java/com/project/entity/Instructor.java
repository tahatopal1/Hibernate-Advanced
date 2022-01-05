package com.project.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "instructor")
// If we don't specify the discriminator value, it'll be the name of entity starts with uppercase (like Instructor)
public class Instructor extends User {
	
	private Double salary;

	public Instructor() {}

	public Instructor(String firstName, String lastName, String email, Double salary) {
		super(firstName, lastName, email);
		this.salary = salary;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	
}
