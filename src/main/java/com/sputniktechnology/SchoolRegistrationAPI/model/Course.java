package com.sputniktechnology.SchoolRegistrationAPI.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "courses", schema = "schooldb")
@EntityListeners(AuditingEntityListener.class)
public class Course {

	
    @Id
    @Column(name = "courseid")
    private String courseId;
    
    @Column(name = "coursename")
    private String courseName;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "coursecredit")
    private int courseCredit;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCourseCredit() {
		return courseCredit;
	}

	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}
    
    
    
}
