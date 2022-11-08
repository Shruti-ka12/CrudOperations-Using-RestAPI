package com.cdac.service;

import java.util.List;
import com.cdac.beans.StudentDetails;

public interface StudentServiceI {

	public StudentDetails createStudent(StudentDetails student);
	public StudentDetails updateStudentByID(Integer studentID);
	public StudentDetails updateStudentWithDynamicValues(StudentDetails student);
	public String deleteStudentByID(Integer studentID);
	public StudentDetails getStudentByID(Integer studentID);
	public List<StudentDetails> getAllStudent();
}
