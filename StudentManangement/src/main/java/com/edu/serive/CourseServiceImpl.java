package com.edu.serive;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Course;
import com.edu.dao.Student;
import com.edu.error.GlobalException;
import com.edu.repository.CourseRepository;
import com.edu.repository.StudentRepository;

@Service
public class CourseServiceImpl implements CourseService{
//inject the object repository layer
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	@Override
	public Course getCourseById(Integer courseId) throws GlobalException {
		Optional<Course> cobj = courseRepository.findById(courseId);
		if(cobj.isPresent()) {
			return courseRepository.findById(courseId).get();
	}
		else{
			throw new GlobalException("Course Id="+courseId+" is not found");
		}
	}

	@Override
	public String deleteCourseById(Integer courseId) throws GlobalException {
		Optional<Course> cobj = courseRepository.findById(courseId);
		if(cobj.isPresent()) {
			courseRepository.deleteById(courseId);
			return "Course with id="+courseId+" is deleted";
	}
		else {
			throw new GlobalException("Course with id="+courseId+" is not found");
		}
	}
				
	

	@Override
	public Course updateCourseById(Integer courseId, Course course) throws GlobalException {
		//get the course by id
		
		Optional<Course> cobj = courseRepository.findById(courseId);
		   if(cobj.isPresent()) {
			   Course cobj1 = courseRepository.findById(courseId).get();
			   cobj1.setCourseName(course.getCourseName());
			   cobj1.setCourseFees(course.getCourseFees());
			   courseRepository.save(cobj1);
			   return cobj1;
		   }
		
		   throw new GlobalException("Updating student by id="+courseId+" is not found");
	}
	

	@Override
	public Course getCourseByName(String courseName) {
		// TODO Auto-generated method stub
		return courseRepository.findByCourseName(courseName);
	}

	@Override
	public Course getCourseByfees(float courseFees) {
		return courseRepository.findByCourseFees(courseFees);
	}
	
	@Override
	public Course getCourseByNamequerymethod(String courseName) {
		// TODO Auto-generated method stub
		return courseRepository.findByCourseNamequerymethod(courseName);
	}

	@Override
	public Course updateCourseIdToStudent(Integer courseId, Integer studentId) {
		Course c = courseRepository.findById(courseId).get();
		Student s = studentRepository.findById(studentId).get();
		s.setCourse(c);
		studentRepository.save(s);
		return c;
	}



}
//findByStudentEmailId
