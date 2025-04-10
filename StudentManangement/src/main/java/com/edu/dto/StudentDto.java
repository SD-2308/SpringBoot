package com.edu.dto;

public class StudentDto {

	private String studentName;
	private String studentEmailid;
	private String courseName;
	
	
	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StudentDto(String studentName, String studentEmailid, String courseName) {
		super();
		this.studentName = studentName;
		this.studentEmailid = studentEmailid;
		this.courseName = courseName;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getStudentEmailid() {
		return studentEmailid;
	}


	public void setStudentEmailid(String studentEmailid) {
		this.studentEmailid = studentEmailid;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	@Override
	public String toString() {
		return "StudentDto [studentName=" + studentName + ", studentEmailid=" + studentEmailid + ", courseName="
				+ courseName + "]";
	}



	


	
	
	
}
