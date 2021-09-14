package com.sputniktechnology.SchoolRegistrationAPI.repository;

import com.sputniktechnology.SchoolRegistrationAPI.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Student repository.
 *
 * @author Ali Koyuncu
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {}