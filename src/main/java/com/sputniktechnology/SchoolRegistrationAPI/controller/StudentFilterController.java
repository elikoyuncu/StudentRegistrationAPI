package com.sputniktechnology.SchoolRegistrationAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sputniktechnology.SchoolRegistrationAPI.model.Student;
import com.sputniktechnology.SchoolRegistrationAPI.repository.StudentFilterRepository;

/**
 * Student Reports
 * 
 * @author Ali Koyuncu
 *
 */
@RestController
@RequestMapping("/students/filter/api/v1")
public class StudentFilterController {
	
	@Autowired
	private StudentFilterRepository filterRepository;
	
	/**
	 * Returns the list of students of hasn't registered to any course yet.
	 * @return
	 */
	@GetMapping("/NotRegistered")
	public List<Student> getStudentsNotRegistered()
	{
		return filterRepository.getStudentsByCourseId(null);
	}
	
	/**
	 * Returns the list of students registered to the specified course
	 * 
	 * @param course_id
	 * @return
	 */
	@GetMapping("/registered/{course_id}")
	public List<Student> getStudentsRegistered(@PathVariable(value = "course_id") String course_id)
	{
		return filterRepository.getStudentsByCourseId(course_id);
	}

}