package com.sputniktechnology.SchoolRegistrationAPI.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "students", schema = "schooldb")
@EntityListeners(AuditingEntityListener.class)
public class Student implements Serializable{

	
    @Id
    @Column(name = "student_id")
    private long studentId;
    
    @Column(name = "student_name")
    private String studentName;
    
    @Column(name = "student_surname")
    private String studentSurname;
    
    @Column(name = "student_birthday")
    private Date studentBirthday;
    
    @Column(name = "student_classyear")
    private int classYear;
    
    @Column(name = "student_email")
    private String studentEmail;

    /**
     * 
     * @return
     */
	public long getStudentId() {
		return studentId;
	}

	/**
	 * 
	 * @param studentId
	 */
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	/**
	 * 
	 * @return
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * 
	 * @param studentName
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * 
	 * @return
	 */
	public String getStudentSurname() {
		return studentSurname;
	}

	/**
	 * 
	 * @param studentSurname
	 */
	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}

	/**
	 * 
	 * @return
	 */
	public Date getStudentBirthday() {
		return studentBirthday;
	}

	/**
	 * 
	 * @param studentBirthday
	 */
	public void setStudentBirthday(Date studentBirthday) {
		this.studentBirthday = studentBirthday;
	}

	/**
	 * 
	 * @return
	 */
	public int getClassYear() {
		return classYear;
	}

	/**
	 * 
	 * @param classYear
	 */
	public void setClassYear(int classYear) {
		this.classYear = classYear;
	}

	/**
	 * 
	 * @return
	 */
	public String getStudentEmail() {
		return studentEmail;
	}

	/**
	 * 
	 * @param studentEmail
	 */
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
    
    
}
