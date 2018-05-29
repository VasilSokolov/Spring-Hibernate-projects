package org.java.code_first_exercise.university_db;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends Person {

	private Double averageGrade;
	private Integer attendance;
	private Set<Course> enrolledCourses;
	
	@Column(name = "average_grade")	
	public Double getAverageGrade() {
		return averageGrade;
	}
	public void setAverageGrade(Double averageGrade) {
		this.averageGrade = averageGrade;
	}
	
	@Column(name = "attendance")
	public Integer getAttendance() {
		return attendance;
	}
	public void setAttendance(Integer attendance) {
		this.attendance = attendance;
	}
	
	@ManyToMany
	@JoinTable(name = "student_courses",
			joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name ="course_id", referencedColumnName = "id"))
	public Set<Course> getEnrolledCourses() {
		return enrolledCourses;
	}
	public void setEnrolledCourses(Set<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}	
}
