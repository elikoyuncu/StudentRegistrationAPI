package com.sputniktechnology.SchoolRegistrationAPI.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "courses_student_rel", schema = "schooldb")
@EntityListeners(AuditingEntityListener.class)
// @IdClass(CompositeKey.class)
public class CoursesStudentRel {

	
	@Id
	private long StudentId;
	@Column(name = "course_id")
	private String courseId;

	public long getStudentId() {
		return StudentId;
	}

	public void setStudentId(long studentId) {
		StudentId = studentId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
    
    
}

