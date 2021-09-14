package com.sputniktechnology.SchoolRegistrationAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import com.sputniktechnology.SchoolRegistrationAPI.exception.ResourceNotFoundException;
import com.sputniktechnology.SchoolRegistrationAPI.model.Student;
import com.sputniktechnology.SchoolRegistrationAPI.repository.StudentRepository;

//import javax.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type User controller / REST Base
 *
 * @author Eli Koyuncu
 */
@RestController
@RequestMapping("/students/api/v1")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	/**
	 * Get list of students
	 * 
	 * @return ist<Student>
	 */

	@GetMapping("")
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	/**
	 * Creates new student
	 * 
	 * @param student
	 * @return
	 */
	  @PostMapping("/add")
	  public Student createStudent(@Valid @RequestBody Student student) {
	    return studentRepository.save(student);
	  }
	  
	  /**
	   * Update Student Information
	   * 
	   * @param studentId
	   * @param userDetails
	   * @return
	   * @throws ResourceNotFoundException
	   */
	  
	  @PutMapping("/update/{id}")
	  public ResponseEntity<Student> updateStudent(
	      @PathVariable(value = "id") Long studentId, @Valid @RequestBody Student userDetails)
	      throws ResourceNotFoundException {

	    Student user =
	        studentRepository
	            .findById(studentId)
	            .orElseThrow(() -> new ResourceNotFoundException("Student not found on :: " + studentId));


	    user.setStudentName(userDetails.getStudentName());
	    user.setStudentSurname(userDetails.getStudentSurname());
	    user.setStudentBirthday(userDetails.getStudentBirthday());
	    user.setClassYear(userDetails.getClassYear());
	    user.setStudentEmail(userDetails.getStudentEmail());
	    
	    final Student updatedUser = studentRepository.save(user);
	    return ResponseEntity.ok(updatedUser);
	  }
	  
	  /**
	   * Deletes the specified Student
	   * 
	   * @param Student Id
	   * @return
	   * @throws Exception
	   */
	  @DeleteMapping("/delete/{id}")
	  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
	    Student user =
	        studentRepository
	            .findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("Student not found on :: " + userId));

	    studentRepository.delete(user);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }

}
