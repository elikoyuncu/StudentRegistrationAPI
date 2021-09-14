package com.sputniktechnology.SchoolRegistrationAPI;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.util.Assert;
import java.util.concurrent.ThreadLocalRandom;

import com.sputniktechnology.SchoolRegistrationAPI.model.Course;
import com.sputniktechnology.SchoolRegistrationAPI.model.Student;

import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchoolRegistrationApiApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	

	@Test
	void contextLoads() {
	}
	
	
	 @Test
	 public void getAllStudents() throws Exception
	 {
		 System.out.println("TEST: Get All Students\n");
		 HttpHeaders headers = new HttpHeaders();
		 HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		 ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/students/api/v1", HttpMethod.GET, entity, String.class);
		 
		 assertThat(response).isNotNull();
		 
		 System.out.println(response.getBody());
		 
		 System.out.println("Passed!");
	 }

	 @Test
	 public void getAllCourses() throws Exception
	 {
		 System.out.println("TEST: Get All Courses\n");
		 HttpHeaders headers = new HttpHeaders();
		 HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		 ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/courses/api/v1", HttpMethod.GET, entity, String.class);
		 
		 assertThat(response).isNotNull();
		 
		 System.out.println(response.getBody());
		 
		 System.out.println("Passed!");
	 }
	 
	 @Test
	 public void createStudent() throws Exception
	 {
		 System.out.println("TEST: Creating User\n");
		 
		 Student pupil = new Student();
		 int randomNum = ThreadLocalRandom.current().nextInt(100, 901);
		 pupil.setStudentId(97000+randomNum);
		 pupil.setStudentName("Fenasi");
		 pupil.setStudentSurname("Kerim");
		 pupil.setClassYear(2);
		 pupil.setStudentEmail("fenasi.kerim@school.edu");
		 
		 ResponseEntity<Student> postResponse = restTemplate.postForEntity(getRootUrl() + "/students/api/v1/add", pupil, Student.class);
		 assertThat(postResponse).isNotNull();
		 assertThat(postResponse.getBody()).isNotNull();
		 
		 System.out.println("Passed!");
		 
	 }
	 
	 @Test
	 public void updateStudent() throws Exception
	 {
		 System.out.println("TEST: Updating Student\n");
		 
		 // Prior to this test, you need to create a student with Student Id 890199.
		 Student pupil = new Student();
		 pupil.setStudentId(890199);
		 pupil.setStudentName("Siki");
		 pupil.setStudentSurname("Sok");
		 pupil.setStudentEmail("siki.sok@student.edu");
		 long id = 890199;
		 restTemplate.put(getRootUrl()+"/students/api/v1/update/"+id, pupil);
		 
		 System.out.println("Passed!");
	 }

	 @Test
	 public void createCourse() throws Exception
	 {
		 System.out.println("TEST: Creating Course\n");
		 
		 Course ders = new Course();
		 int randomNum = ThreadLocalRandom.current().nextInt(100, 901);
		 System.out.println("Random Num: "+randomNum);
		 ders.setCourseId("FAKE-"+randomNum);
		 ders.setCourseName("Test Course");
		 ders.setCourseCredit(7);
		 ders.setDescription("Created for test.");
		 
		 ResponseEntity<Course> postResponse = restTemplate.postForEntity(getRootUrl() + "/courses/api/v1/add", ders, Course.class);
		 assertThat(postResponse).isNotNull();
		 assertThat(postResponse.getBody()).isNotNull();
		 
		 System.out.println("Passed!");
	 }
	 
	 @Test
	 public void updateCourse() throws Exception
	 {
		 System.out.println("TEST: Updating Course\n");
		 
		 // Prior to this test, you need to create a student with Course Id Math 101.
		 Course ders = new Course();
		 ders.setCourseId("MATH-101");
		 ders.setCourseName("Test Course");
		 ders.setCourseCredit(7);
		 ders.setDescription("Updated for test.");

		 
		 restTemplate.put(getRootUrl()+"/courses/api/v1/update/MATH-101", ders);
		 
		 System.out.println("Passed!");
	 }
	 
	 @Test
	 public void getStudentsWithoutCourses() throws Exception
	 {
		 System.out.println("TEST: Get Students without Courses\n");
		 HttpHeaders headers = new HttpHeaders();
		 HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		 ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/students/filter/api/v1", HttpMethod.GET, entity, String.class);
		 
		 assertThat(response).isNotNull();
		 
		 System.out.println(response.getBody());
		 
		 System.out.println("Passed!");
	 }
	 
	 @Test
	 public void getStudentsWithSpecificCourses() throws Exception
	 {
		 System.out.println("TEST: Get Students with MATH-101\n");
		 HttpHeaders headers = new HttpHeaders();
		 HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		 ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/students/filter/api/v1/MATH-101", HttpMethod.GET, entity, String.class);
		 
		 assertThat(response).isNotNull();
		 
		 System.out.println(response.getBody());
		 
		 System.out.println("Passed!");
	 }
	 
	 @Test
	 public void getCoursesWithoutRegistration() throws Exception
	 {
		 System.out.println("TEST: Get Courses without Registration\n");
		 HttpHeaders headers = new HttpHeaders();
		 HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		 ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/courses/filter/api/v1", HttpMethod.GET, entity, String.class);
		 
		 assertThat(response).isNotNull();
		 
		 System.out.println(response.getBody());
		 
		 System.out.println("Passed!");
	 }
	 
	 @Test
	 public void getCoursesForSpecificStudent() throws Exception
	 {
		 System.out.println("TEST: Get Courses without Registration\n");
		 HttpHeaders headers = new HttpHeaders();
		 HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		 ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/courses/filter/api/v1/890199", HttpMethod.GET, entity, String.class);
		 
		 assertThat(response).isNotNull();
		 
		 System.out.println(response.getBody());
		 
		 System.out.println("Passed!");
	 }
	 
}
