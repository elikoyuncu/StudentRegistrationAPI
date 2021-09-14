package com.sputniktechnology.SchoolRegistrationAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sputniktechnology.SchoolRegistrationAPI.exception.ResourceNotFoundException;
import com.sputniktechnology.SchoolRegistrationAPI.model.Course;
import com.sputniktechnology.SchoolRegistrationAPI.repository.CourseRepository;

import java.util.HashMap;

//import javax.validation.Valid;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;


/**
 * The type User controller / REST Base
 *
 * @author Eli Koyuncu
 */
@RestController
@RequestMapping("/courses/api/v1")
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;

	@GetMapping("")
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}
	
	/**
	 * Creates new Course
	 * 
	 * @param Course
	 * @return
	 */
	  @PostMapping("/add")
	  public Course createCourse(@Valid @RequestBody Course course) {
	    return courseRepository.save(course);
	  }
	  
	  /**
	   * Update Course Information
	   * 
	   * @param CourseId
	   * @param userDetails
	   * @return
	   * @throws ResourceNotFoundException
	   */
	  
	  @PutMapping("/update/{id}")
	  public ResponseEntity<Course> updateCourse(
	      @PathVariable(value = "id") Long CourseId, @Valid @RequestBody Course userDetails)
	      throws ResourceNotFoundException {

	    Course user =
	        courseRepository
	            .findById(CourseId)
	            .orElseThrow(() -> new ResourceNotFoundException("Course not found on :: " + CourseId));


	    user.setCourseName(userDetails.getCourseName());
	    user.setCourseCredit(userDetails.getCourseCredit());
	    user.setDescription(userDetails.getDescription());
	    
	    final Course updatedUser = courseRepository.save(user);
	    return ResponseEntity.ok(updatedUser);
	  }
	  
	  /**
	   * Deletes the specified Course
	   * 
	   * @param Course Id
	   * @return
	   * @throws Exception
	   */
	  @DeleteMapping("/delete/{id}")
	  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
	    Course user =
	        courseRepository
	            .findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("Course not found on :: " + userId));

	    courseRepository.delete(user);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }

}
