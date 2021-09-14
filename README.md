# School Registration API

By Ali (Eli) Koyuncu, ali.koyuncu@gmail.com

## About the Project / Requirements

Project 1: School registration system

Design and implement simple school registration system
- Assuming you already have a list of students
- Assuming you already have a list of courses
- A student can register to multiple courses
- A course can have multiple students enrolled in it. 
- A course has 50 students maximum
- A student can register to 5 course maximum

Provide the following API:
- Create students CRUD
- Create courses CRUD
- Create API for students to register to courses
- Create Report API for admin user to view all relationships between students and courses
  + Filter all students with a specific course
  + Filter all courses for a specific student
  + Filter all courses without any students
  + Filter all students without any courses 
  
## Data Model
 
 Schema name is SchoolDb, that consists of three tables:
 
 <li>Students - Student information</li>
 <li>Courses - Course information</li>
 <li>Courses_Student_rel - a reference table that relates students with courses</li>
 
 Plus to these tables, stored procedures are as follows:
 
 <table border=1 cellpadding="0" cellspacing="0" >
 <tr>
 <td><b>SP</b></td><td><b>Params</b></td><td><b>Description</b></td></tr>
  <tr>
 <td>SP_Register </td>
 <td>long StudentId, String CourseId </td>
 <td>Register student to the specified course.</td>
 </tr>
 <tr>
 <td>SP_Filter_Course </td>
 <td>long StudentId </td>
 <td>Returns all courses. 
 <br>If student id = 0 or NULL, returns all courses without any registration.
 <br>Else returns all courses for the given student.
 </td>
 </tr>
 <td>SP_Filter_Student </td>
 <td>String CourseId </td>
 <td>Returns all students 
 <br>If Course Id is NULL, returns all courses without any students.
 <br>Else returns all courses who registered to the specified student.
 </td>
 </tr>
 </table>
 
## Configuration

### Environment

In <i>src/main/resources/application.properties</i>, 

spring.datasource.url=jdbc:mysql://localhost:3306/schooldb
spring.datasource.username=schooladmin
spring.datasource.password=******

where the user schooladmin must be granted for ALTER, CREATE, SELECT, UPDATE and DELETE.

### Versions

<li>JRE version is 11.0.11</li>
<li>MySql Version is 8.0.25</li>
<li>Spring Boot Version 2.5.4</li>
<li>Apache Maven 3.3.9</li>

### Build

```
mvn package
<br>java -jar target/SchoolRegistrationAPI-0.0.1-SNAPSHOT.jar
```

# API Guide

## Get All Students

- Method: GET
- Path: /students/api/v1
- Response: Student

```
[{"studentId":301121,"studentName":"Test","studentSurname":"Kullanici","studentBirthday":"1990-02-07T22:00:00.000+00:00","classYear":1,"studentEmail":"test1@school.edu"},{"studentId":302122,"studentName":"Test2","studentSurname":"Kullanici","studentBirthday":"1971-10-16T22:00:00.000+00:00","classYear":1,"studentEmail":"Test2.Kullanici@someschool.edu"},{"studentId":890199,"studentName":"Siki","studentSurname":"Sok","studentBirthday":null,"classYear":0,"studentEmail":"siki.sok@student.edu"},{"studentId":890278,"studentName":"Daria","studentSurname":"Koyuncu","studentBirthday":"2011-11-09T22:00:00.000+00:00","classYear":1,"studentEmail":"daria.koyuncu@school.edu"},{"studentId":890378,"studentName":"Margarita","studentSurname":"Rakhimova","studentBirthday":"2000-02-07T22:00:00.000+00:00","classYear":1,"studentEmail":"margo.rakhimova@school.edu"},{"studentId":890778,"studentName":"Natalia","studentSurname":"Koyuncu","studentBirthday":"1978-01-28T22:00:00.000+00:00","classYear":1,"studentEmail":"natalia.koyuncu@school.edu"},{"studentId":2302122,"studentName":"Test2","studentSurname":"Kullanici","studentBirthday":"1971-10-16T22:00:00.000+00:00","classYear":1,"studentEmail":"@student_name.@student_surname@someschool.edu"},{"studentId":3302122,"studentName":"Test3","studentSurname":"Kullanici","studentBirthday":"1971-10-16T22:00:00.000+00:00","classYear":1,"studentEmail":"Test2.Kullanici@someschool.edu"}]
```
## Get All Courses

- Method: GET
- Path: /courses/api/v1
- Response: Course

```
[{"courseId":"ART-101","courseName":"Art History","description":"Some course","courseCredit":2},{"courseId":"ECON-101","courseName":"Macro Economics","description":"Some course","courseCredit":10},{"courseId":"ENG-101","courseName":"English: Communication Skills","description":"Some course","courseCredit":4},{"courseId":"FAKE-745","courseName":"Test Course","description":"Created for test.","courseCredit":7},{"courseId":"GYM-101","courseName":"Gym","description":"Some course","courseCredit":5},{"courseId":"MATH-101","courseName":"Calculus 1","description":"Some course","courseCredit":12},{"courseId":"MATH-102","courseName":"Probility Theory 1","description":"Some course","courseCredit":10},{"courseId":"PHYS-101","courseName":"Physics","description":"Some course","courseCredit":12}]
```

## Add Student

- Method: POST
- Path: /students/api/v1/add
- Content Type: application/json

Request:

```
{
	"studentId":401121,
	"studentName":"Test",
	"studentSurname":"Kullanici",
	"studentBirthday":"1990-02-07T22:00:00.000+00:00",
	"classYear":1,
	"studentEmail":"test1@school.edu"
}
```
 
 Response:
 
 ```
 {
   "studentId": 401121,
   "studentName": "Test",
   "studentSurname": "Kullanici",
   "studentBirthday": "1990-02-07T22:00:00.000+00:00",
   "classYear": 1,
   "studentEmail": "test1@school.edu"
}
```
 
## Update Student

- Method: PUT
- Path: /students/api/v1/update/{student_id}
- Content Type: application/json

Request:

```
{
	"studentId":401121,
	"studentName":"Test2",
	"studentSurname":"Kullanici2",
	"studentBirthday":"1990-02-07T22:00:00.000+00:00",
	"classYear":1,
	"studentEmail":"test1@school.edu"
}
```
 
 Response:
 
 ```
 {
   "studentId": 401121,
   "studentName": "Test2",
   "studentSurname": "Kullanici2",
   "studentBirthday": "1990-02-07T22:00:00.000+00:00",
   "classYear": 1,
   "studentEmail": "test1@school.edu"
}
```
 
## Delete Student

- Method: DELETE
- Path: /students/api/v1/delete/{student_id}
- Content Type: application/json

Request:

```
{
	"studentId":401121,
	"studentName":"Test2",
	"studentSurname":"Kullanici2",
	"studentBirthday":"1990-02-07T22:00:00.000+00:00",
	"classYear":1,
	"studentEmail":"test1@school.edu"
}
```


Response:

```
{"deleted": true}
```

## Add Course

- Method: POST
- Path: /courses/api/v1/add
- Content Type: application/json

Request:

```
{
	"courseId":"FOE-666",
	"courseName":"FOE",
	"description":"Some course",
	"courseCredit":3
}
```
 
 Response:
 
 ```
{
	"courseId":"FOE-666",
	"courseName":"FOE",
	"description":"Some course",
	"courseCredit":3
}
```


## Update Course

- Method: PUT
- Path: /courses/api/v1/update/{course_id}
- Content Type: application/json

Request:

```
{
	"courseId":"FOE-666",
	"courseName":"FOE",
	"description":"Some course 1",
	"courseCredit":4
}
```
 
 Response:
 
 ```
{
	"courseId":"FOE-666",
	"courseName":"FOE",
	"description":"Some course 2",
	"courseCredit":4
}
```

## Delete Course

- Method: DELETE
- Path: /courses/api/v1/delete/{course_id}
- Content Type: application/json

Request:

```
{
	"studentId":401121,
	"studentName":"Test2",
	"studentSurname":"Kullanici2",
	"studentBirthday":"1990-02-07T22:00:00.000+00:00",
	"classYear":1,
	"studentEmail":"test1@school.edu"
}
```


Response:

```
{"deleted": true}
```

## Register Student to the Given Course

Used to register a student to the specified course.

- Method: GET
- Path: /register/api/v1/register

Query String Params:

- StudentId (long)
- CourseId (String)

Request:

http://localhost:8080/register/api/v1/register?StudentId=890199&CourseId=MATH-101

Response:

If the number of lectures of a student exceeds 5,

```
{"resultMapping":{"Status":"-1","Description":"A student can have max 5 courses","ErrorCode":"ERR-1","Result":""}}
```

Otherwise,

```
{"resultMapping":{"Status":"0","Description":"","ErrorCode":"","Result":"Registered"}}
```

## Unregister

Used to register a student to the specified course.

- Method: GET
- Path: /register/api/v1/unregister

Query String Params:

- StudentId (long)
- CourseId (String)

Request:

http://localhost:8080/register/api/v1/register?StudentId=890199&CourseId=MATH-101

Response:

```
{"resultMapping":{"Status":"0","Description":"","ErrorCode":"","Result":"Unregistered"}}
```

# Reports

## Get List of Students Who Have No Courses

- Method: GET
- Path: /students/filter/api/v1/NotRegistered

Response:

```
[{"studentId":0,"studentName":null,"studentSurname":null,"studentBirthday":null,"classYear":0,"studentEmail":null},{"studentId":97280,"studentName":"Fenasi","studentSurname":"Kerim","studentBirthday":null,"classYear":2,"studentEmail":"fenasi.kerim@school.edu"},{"studentId":301121,"studentName":"Test","studentSurname":"Kullanici","studentBirthday":"1990-02-07T22:00:00.000+00:00","classYear":1,"studentEmail":"test1@school.edu"},{"studentId":302122,"studentName":"Test2","studentSurname":"Kullanici","studentBirthday":"1971-10-16T22:00:00.000+00:00","classYear":1,"studentEmail":"Test2.Kullanici@someschool.edu"},{"studentId":890278,"studentName":"Daria","studentSurname":"Koyuncu","studentBirthday":"2011-11-09T22:00:00.000+00:00","classYear":1,"studentEmail":"daria.koyuncu@school.edu"},{"studentId":890378,"studentName":"Margarita","studentSurname":"Rakhimova","studentBirthday":"2000-02-07T22:00:00.000+00:00","classYear":1,"studentEmail":"margo.rakhimova@school.edu"},{"studentId":978222,"studentName":"Fenasi","studentSurname":"Kerim","studentBirthday":null,"classYear":2,"studentEmail":"fenasi.kerim@school.edu"},{"studentId":2302122,"studentName":"Test2","studentSurname":"Kullanici","studentBirthday":"1971-10-16T22:00:00.000+00:00","classYear":1,"studentEmail":"@student_name.@student_surname@someschool.edu"},{"studentId":3302122,"studentName":"Test3","studentSurname":"Kullanici","studentBirthday":"1971-10-
```

## Get List of Students Who Registered to Specific Course

- Method: GET
- Path: /students/filter/api/v1/Registered/{course_id}

Request:

```
http://localhost:8080/students/filter/api/v1/registered/ENG-101
```

Response:

```
[{"studentId":890199,"studentName":"Siki","studentSurname":"Sok","studentBirthday":null,"classYear":0,"studentEmail":"siki.sok@student.edu"}]
```

## Get List of Courses That Have No Students

- Method: GET
- Path: /courses/filter/api/v1/NotRegistered

Request

```
http://localhost:8080/courses/filter/api/v1/NotRegistered
```

Response:

```
[{"courseId":"FAKE-745","courseName":"Test Course","description":"Created for test.","courseCredit":7},{"courseId":"MATH-101","courseName":"Calculus 1","description":"Some course","courseCredit":12},{"courseId":"MATH-102","courseName":"Probility Theory 1","description":"Some course","courseCredit":10}]
```

## Get List of Courses That Have Students

- Method: GET
- Path: /courses/filter/api/v1/registered/{student_id}

Request:

```
http://localhost:8080//courses/filter/api/v1/registered/890199
```

Response:

```
[{"courseId":"ART-101","courseName":"Art History","description":"Some course","courseCredit":2},{"courseId":"ENG-101","courseName":"English: Communication Skills","description":"Some course","courseCredit":4},{"courseId":"GYM-101","courseName":"Gym","description":"Some course","courseCredit":5},{"courseId":"PHYS-101","courseName":"Physics","description":"Some course","courseCredit":12}]
```