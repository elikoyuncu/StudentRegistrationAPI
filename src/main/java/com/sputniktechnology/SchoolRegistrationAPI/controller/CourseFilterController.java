package com.sputniktechnology.SchoolRegistrationAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sputniktechnology.SchoolRegistrationAPI.model.Course;
import com.sputniktechnology.SchoolRegistrationAPI.repository.CourseFilterRepository;

/**
 * Course Reports
 * 
 * @author Ali Koyuncu
 *
 */
@RestController
@RequestMapping("/courses/filter/api/v1")
public class CourseFilterController {
	
	@Autowired
	private CourseFilterRepository filterRepository;
	
	/**
	 * Returns the list of courses which have no registration
	 * @return
	 */
	@GetMapping("/NotRegistered")
	public List<Course> getCoursesNotRegistered()
	{
		return filterRepository.getCoursesByStudentId(0);
	}
	
	/**
	 * Returns the list of courses having registration
	 * 
	 * @param course_id
	 * @return
	 */
	@GetMapping("/registered/{student_id}")
	public List<Course> getCoursesRegistered(@PathVariable(value = "student_id") long student_id)
	{
		return filterRepository.getCoursesByStudentId(student_id);
	}

}