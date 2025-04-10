package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Course;
import com.edu.error.GlobalException;
import com.edu.repository.CourseRepository;
import com.edu.serive.CourseService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private CourseRepository courseRepository;
	/*
	 * @PostMapping ->insert record
	 * 
	 * @GetMapping->select
	 * 
	 * @DeleteMapping->Delete
	 * 
	 * @PutMapping->update
	 */
	// http://localhost:8080/saveCourse

	@PostMapping("/saveCourse")
	public ResponseEntity<Course> saveCourse(@Valid @RequestBody Course course) {
		
		Course cobj = courseRepository.findByCourseName(course.getCourseName());
		if(cobj != null ) {
		System.out.println("Course name="+course.getCourseName()+" is already exists");
			
		return ResponseEntity.status(HttpStatus.CONFLICT).body(cobj);
		}
		else {
			Course cobj1 = courseService.saveCourse(course);
			return ResponseEntity.status(HttpStatus.CREATED).body(cobj1);
		}
	}

	// http://localhost:9090/getAllCourses

	@GetMapping("/getAllCourses")
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();

	}

	// http://localhost:8080/getCourseById/1
	@GetMapping("/getCourseById/{cid}")
	public Course getCourseById(@PathVariable("cid") Integer courseId) throws GlobalException {
		// public Course getCourseById(@ Integer courseId){
		return courseService.getCourseById(courseId);

	}

	// http://localhost:8080/deleteCourseById/1
	@DeleteMapping("/deleteCourseById/{cid}")
	public String deleteCourseById(@PathVariable("cid") Integer courseId) throws GlobalException {
		return courseService.deleteCourseById(courseId);

	}

	// Update Record

	// http://localhost:8080/updateCourseById/1

	@PutMapping("/updateCourseById/{cid}")
	public Course updateCourseById(@PathVariable("cid") Integer courseId, @RequestBody Course course) throws GlobalException {
		return courseService.updateCourseById(courseId, course);

	}

	// getCourseByName
	// http://localhost:8080/getCourseByName/jfs
	@GetMapping("/getCourseByName/{cname}")
	public Course getCourseByName(@PathVariable("cname") String courseName) {
		return courseService.getCourseByName(courseName);

	}

	// http://localhost:8080/getCourseByfee/jfs
	@GetMapping("/getCourseByfee/{cfee}")
			public Course getCourseByfee(@PathVariable("cfee") float courseFees) {
				return courseService.getCourseByfees(courseFees);
	}
		
	//  
	@GetMapping("/getCourseByNamequerymethod/{cname}")
	public Course getCourseByNamequerymethod(@PathVariable("cname") String courseName) {
		return courseService.getCourseByNamequerymethod(courseName);

	}
	
	@PutMapping("/updateCourseIdToStudent/{cid}/{sid}")
	public Course updateCourseIdToStudent(@PathVariable("cid") Integer courseId,@PathVariable("sid") Integer studentId) {
		return courseService.updateCourseIdToStudent(courseId,studentId);
	}

}
