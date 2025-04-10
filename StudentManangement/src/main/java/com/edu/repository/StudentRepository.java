package com.edu.repository;


import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.dao.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findByStudentEmail(String studentEmail);

	public List<Student> findByStudentName(String studentName);

	@Query(value = "select * from Student where student_email=?", nativeQuery = true)
	public Student getStudentByEmail(String studentEmail);

	@Query(value = "Select * from Student where student_dob=?", nativeQuery = true)
	public List<Student> findByStudentDob(String studentDob);

	public Student findByStudentEmailOrStudentPhone(String studentEmail, String studentPhone);




	
	

}
