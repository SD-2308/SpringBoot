package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

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


import com.edu.dao.Student;
import com.edu.dto.StudentDto;
import com.edu.error.GlobalException;
import com.edu.repository.StudentRepository;
import com.edu.serive.StudentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentRepository studentRepository;
	
	// http://localhost:8080/saveStudent
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
		Student sobj = studentRepository.findByStudentEmailOrStudentPhone(student.getStudentEmail(),student.getStudentPhone());
		if(sobj != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(sobj);
		}
		else {
		Student sobj1 = studentService.saveStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(sobj1);
		}
	}

	//http://localhost:8080/getAllStudents
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents() throws GlobalException{
		return studentService.getAllStudents();
	}
	
	//http://localhost:8080/getStudentById/1
	@GetMapping("/getStudentById/{sid}")
	public Student getStudentById(@PathVariable("sid") Integer studentId) throws GlobalException {
		return studentService.getStudentById(studentId);
	}
	
	//http://localhost:8080/getStudentById/1
	@DeleteMapping("/deleteStudentById/{sid}")
	public String deleteStudentById(@PathVariable("sid") Integer studentId) {
		return studentService.deleteStudentById(studentId);
	}
	
	//http://localhost:8080/getStudent/1
	@DeleteMapping("/deleteStudent/{sid}")
	public List<Student> deleteStudent(@PathVariable("sid") Integer studentId) {
		return studentService.deleteStudent(studentId);
	}
	
	
	// http://localhost:8080/updateStudentById/1
	@PutMapping("/updateStudentById/{sid}")
	 public Student updateStudentById(@PathVariable("sid") Integer studentId, @RequestBody Student student ) throws GlobalException {
		 return studentService.updateStudentById(studentId,student);
	 }
	
	// http://localhost:8080/getStudentByEmailId/deepakkjc088@gmail.com
	@GetMapping("findByStudentEmailId/{semail}")
	public Student findByStudentEmailId(@PathVariable("semail") String studentEmailId) throws GlobalException {
		
		return studentService.findByStudentEmailId(studentEmailId);
	}
	
	// http://localhost:8080/findByStudentName/Deepak K 
	@GetMapping("/findByStudentName/{sname}")
	public List<Student> findByStudentName(@PathVariable("sname") String studentName) {
		return studentService.findByStudentName(studentName);
	}
	
	// http://localhost:8080//getStudentByEmailId/deepakkjc088@gmail.com
	@GetMapping("/getStudentByEmailId/{semail}")
	public Student getStudentByEmailId(@PathVariable("semail") String studentEmailId) {
		return studentService.getStudentByEmailId(studentEmailId);
	}
	
	@GetMapping("/findByStudentDob/{sdob}")
	public List<Student> findByStudentDob(@PathVariable("sdob") String studentDob){
		return studentService.findByStudentDob(studentDob);
	}
	
	// http://localhost:8080/getStudentDetailsDto/1
	@GetMapping("/getStudentDetailsDto/{sid}")
	public StudentDto getStudentDetailsDto(@PathVariable("sid") Integer studentId) {
		return studentService.getStudentDetailsDto(studentId);
		
	}
}





