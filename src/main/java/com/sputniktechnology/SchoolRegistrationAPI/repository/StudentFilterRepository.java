package com.sputniktechnology.SchoolRegistrationAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sputniktechnology.SchoolRegistrationAPI.model.Student;

/**
 * Reporting
 * 
 * @author Ali Koyuncu
 *
 */
@Repository
public interface StudentFilterRepository extends JpaRepository<Student, Long>{
	
	/**
	 * Returns all students registered the specified course
	 * 
	 * If course_id is NULL, returns students who hasn't been assigned to any courses.
	 * 
	 * @param course_id
	 * @return
	 */
	@Query(value = "CALL SP_Filter_Student (:course_id);", nativeQuery = true)
    List<Student> getStudentsByCourseId(@Param("course_id") String course_id);

}
