package com.edu.dao;

import java.sql.Date;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="student_id")
private Integer studentId;

@Column(name="student_name" ,length = 50, nullable = false)
@NotBlank(message = "Name should not be null or Blank")
private String studentName;

@Column(name="student_age")
@Min(value=18, message = "Min age is 18")	
@Max(value=30, message = "max age is 30")
private int studentAge;

@Column(name="student_email",length = 40,nullable = false,unique = true)
@NotBlank(message="Email should not null or Blank")
@Pattern(regexp = "[a-zA-Z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid email address")
private String studentEmail;

@Column(name="student_phone", length = 10,nullable = false, unique = true)
 @NotBlank(message="Phone should not null or Blank")
@Pattern(regexp = "^[6-9]\\d{0,9}$")
private String studentPhone;

@Column(name="student_dob")
@Past(message="Date of Birth Should be past date")
private Date studentDob;


@JsonIgnore
@ManyToOne
@JoinColumn(name="course_id")
private Course course;

public Student() {
	super();
	// TODO Auto-generated constructor stub
}

public Student(Integer studentId, @NotBlank(message = "Name should not be null or Blank") String studentName,
		@Min(value = 18, message = "Min age is 18") @Max(value = 30, message = "max age is 30") int studentAge,
		@NotBlank(message = "Email should not null or Blank") @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid email address") String studentEmail,
		@NotBlank(message = "Phone should not null or Blank") @Pattern(regexp = "^[6-9]\\d{0,9}$") String studentPhone,
		@Past(message = "Date of Birth Should be past date") Date studentDob) {
	super();
	this.studentId = studentId;
	this.studentName = studentName;
	this.studentAge = studentAge;
	this.studentEmail = studentEmail;
	this.studentPhone = studentPhone;
	this.studentDob = studentDob;
}

public Integer getStudentId() {
	return studentId;
}

public void setStudentId(Integer studentId) {
	this.studentId = studentId;
}

public String getStudentName() {
	return studentName;
}

public void setStudentName(String studentName) {
	this.studentName = studentName;
}

public int getStudentAge() {
	return studentAge;
}

public void setStudentAge(int studentAge) {
	this.studentAge = studentAge;
}

public String getStudentEmail() {
	return studentEmail;
}

public void setStudentEmail(String studentEmail) {
	this.studentEmail = studentEmail;
}

public String getStudentPhone() {
	return studentPhone;
}

public void setStudentPhone(String studentPhone) {
	this.studentPhone = studentPhone;
}

public Date getStudentDob() {
	return studentDob;
}

public void setStudentDob(Date studentDob) {
	this.studentDob = studentDob;
}

public Course getCourse() {
	return course;
}

public void setCourse(Course course) {
	this.course = course;
}


@Override
public String toString() {
	return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge
			+ ", studentEmail=" + studentEmail + ", studentPhone=" + studentPhone + ", studentDob=" + studentDob
			+ ", course=" + course + "]";
}



}
