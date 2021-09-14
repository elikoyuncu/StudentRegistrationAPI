package com.sputniktechnology.SchoolRegistrationAPI.repository;

import com.sputniktechnology.SchoolRegistrationAPI.model.CoursesStudentRel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.query.Procedure;

/**
 * The interface Register repository.
 *
 * @author Ali Koyuncu
 */
@Repository
public interface RegisterRepository extends JpaRepository<CoursesStudentRel, Long> {
	
	@Procedure("SP_Register")
	String invokeSPRegister(int opMode, long studentId, String courseId);
	
	
}