package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.dao.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

public Course findByCourseName(String courseName);




@Query(value = "select * from course where course_name=?", nativeQuery = true)
public Course findByCourseNamequerymethod(String courseName);


public Course findByCourseFees(float courseFees);



}
