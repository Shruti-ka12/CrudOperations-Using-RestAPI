package com.cdac.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student_details_tbl")
public class StudentDetails {

	@Id
	private Integer studentID;
	private String studentName;
	private String studentEmail;
	private String studentMob;


	//Default Constructor
	public StudentDetails() {
		super();
	}

	//Parameterized Constructor
	public StudentDetails(Integer studentID, String studentName, String studentEmail, String studentMob) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentMob = studentMob;
	}

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentMob() {
		return studentMob;
	}

	public void setStudentMob(String studentMob) {
		this.studentMob = studentMob;
	}

	@Override
	public String toString() {
		return "StudentDetails [studentID=" + studentID + ", studentName=" + studentName + ", studentEmail="
				+ studentEmail + ", studentMob=" + studentMob + "]";
	}

}
