package com.edu.serive;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Course;
import com.edu.dao.Student;
import com.edu.dto.StudentDto;
import com.edu.error.GlobalException;
import com.edu.repository.CourseRepository;
import com.edu.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() throws GlobalException {
		List<Student> s = studentRepository.findAll();
		if(s!= null) {
			return studentRepository.findAll();
		}
		else {
			throw new GlobalException("Students record are not found");
		}
	}
		


	@Override
	public Student getStudentById(Integer studentId) throws GlobalException {
		Optional<Student> sobj =studentRepository.findById(studentId);
		if(sobj.isPresent()) {
			return studentRepository.findById(studentId).get();
		}
		else {
			throw new GlobalException("Student Id="+studentId+" is not found");
		}
	}

	@Override
	public String deleteStudentById(Integer studentId) {
		studentRepository.deleteById(studentId);
		return "Student with id "+studentId+" is deleted";
	}

	@Override
	public Student updateStudentById(Integer studentId, Student student) throws GlobalException {
		
		Student existingStudent = studentRepository.findById(studentId).get();
		
		if (existingStudent != null) {
			existingStudent.setStudentName(student.getStudentName());
			existingStudent.setStudentDob(student.getStudentDob());
			existingStudent.setStudentEmail(student.getStudentEmail());
			return studentRepository.save(existingStudent);
		}
		else {
			throw new GlobalException("Student updating by id="+studentId+"is not found");
		}
		
		
	}

	@Override
	public Student findByStudentEmailId(String studentEmail) throws GlobalException {
		Student s1 = studentRepository.findByStudentEmail(studentEmail);
		if(s1 != null) {
			return studentRepository.findByStudentEmail(studentEmail);
		}
		else {
			throw new GlobalException("Student is not found by this email Id="+studentEmail);
		}
	}

	@Override
	public List<Student> findByStudentName(String studentName) {
		// TODO Auto-generated method stub
		return studentRepository.findByStudentName(studentName);
	}

	@Override
	public Student getStudentByEmailId(String studentEmail) {
		// TODO Auto-generated method stub
		return studentRepository.getStudentByEmail(studentEmail);
	}

	@Override
	public List<Student> findByStudentDob(String studentDob) {
		// TODO Auto-generated method stub
		return studentRepository.findByStudentDob(studentDob);
	}

	@Override
	public StudentDto getStudentDetailsDto(Integer studentId) {
		Student sob = studentRepository.findById(studentId).get();
		StudentDto sdto = new StudentDto();
		sdto.setStudentName(sob.getStudentName());
		sdto.setStudentEmailid(sob.getStudentEmail());
		Course c = sob.getCourse();
		sdto.setCourseName(c.getCourseName());
		
		return sdto;
	}

	@Override
	public List<Student> deleteStudent(Integer studentId) {
		studentRepository.deleteById(studentId);
		return studentRepository.findAll();
	}

	
	



	
	
	
}
