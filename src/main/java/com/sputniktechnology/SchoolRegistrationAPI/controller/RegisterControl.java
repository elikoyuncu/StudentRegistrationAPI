package com.sputniktechnology.SchoolRegistrationAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sputniktechnology.SchoolRegistrationAPI.base.Result;
import com.sputniktechnology.SchoolRegistrationAPI.repository.RegisterRepository;


//import javax.validation.Valid;



/**
 * The Register controller / REST Base
 * 
 * Registering student to a lecture
 *
 * @author Eli Koyuncu
 */
@RestController
@RequestMapping("/register/api/v1")
public class RegisterControl {
	
	@Autowired
	private RegisterRepository registerRepository;

	/**
	 * Registers student to the specified course
	 * 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	@GetMapping(path = "register")
	public Result registerToCourse(@RequestParam("StudentId") long studentId, @RequestParam("CourseId") String courseId)
	{
		String result = registerRepository.invokeSPRegister(1, studentId, courseId);
		
		Result res = null;
		
		if(result.equals("OK") || result.equals("Registered"))
			res = new Result(0, result, null, null);
		else
			res = new Result(-1, "", "ERR-1", result);
		
		return res;
		
	}
	
	/**
	 * Unregisters any course against the given StudentId
	 * 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	@GetMapping(path = "unregister")
	public Result unregisterToCourse(@RequestParam("StudentId") long studentId, @RequestParam("CourseId") String courseId)
	{
		String result = registerRepository.invokeSPRegister(0, studentId, courseId);
		
		Result res = null;
		
		if(result.equals("OK") || result.equals("Unregistered"))
			res = new Result(0, result, null, null);
		else
			res = new Result(-1, "", "ERR-1", result);
		
		return res;
	}

}
