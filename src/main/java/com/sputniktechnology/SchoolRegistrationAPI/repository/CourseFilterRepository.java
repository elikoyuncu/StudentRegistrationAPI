package com.sputniktechnology.SchoolRegistrationAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sputniktechnology.SchoolRegistrationAPI.model.Course;


/**
 * Reporting for Courses
 * 
 * @author Ali Koyuncu
 *
 */
@Repository
public interface CourseFilterRepository extends JpaRepository<Course, String>{
	
	/**
	 * Returns all courses by the specific student
	 * 
	 * If course_id is NULL, returns students who hasn't been assigned to any courses.
	 * 
	 * @param student_id
	 * @return
	 */
	@Query(value = "CALL SP_Filter_Course (:student_id);", nativeQuery = true)
    List<Course> getCoursesByStudentId(@Param("student_id") long student_id);

}
