package org.java.code_first_exercise.university_db;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {
	
	private String email;
	private Double salaryPerHour;
	private Set<Course> taughtCourses;
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "salary_per_hour")
	public Double getSalaryPerHour() {
		return salaryPerHour;
	}
	
	public void setSalaryPerHour(Double salaryPerHour) {
		this.salaryPerHour = salaryPerHour;
	}
	
	
	public Set<Course> getTaughtCourses() {
		return taughtCourses;
	}
	
	public void setTaughtCourses(Set<Course> taughtCourses) {
		this.taughtCourses = taughtCourses;
	}
}
