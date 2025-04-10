package com.edu.serive;

import java.util.List;

import com.edu.dao.Student;
import com.edu.dto.StudentDto;
import com.edu.error.GlobalException;

public interface StudentService {

	public Student saveStudent(Student student);

	public List<Student> getAllStudents() throws GlobalException;

	public Student getStudentById(Integer studentId) throws GlobalException;

	public String deleteStudentById(Integer studentId);

	
	public Student updateStudentById(Integer studentId, Student student) throws GlobalException;

	public Student findByStudentEmailId(String studentEmailId) throws GlobalException;

	public List<Student> findByStudentName(String studentName);

	public Student getStudentByEmailId(String studentEmailId);

	public List<Student> findByStudentDob(String studentDob);

	public StudentDto getStudentDetailsDto(Integer studentId);

	public List<Student> deleteStudent(Integer studentId);



	

	

	

}
