package com.cdac.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdac.beans.StudentDetails;
import com.cdac.repo.StudentRepository;

@Service
public class UserServiceImp implements StudentServiceI{

	@Autowired
	private StudentRepository repo;
	
	@Override
	public StudentDetails createStudent(StudentDetails student) {
	
		return repo.save(student);
	}

	@Override
	public StudentDetails updateStudentByID(Integer studentID) {
	
		StudentDetails existedStudent = null;
		
		//get user based on ID
		Optional<StudentDetails> findById = repo.findById(studentID);
		
		//check whether we get object from DB or not
		if(findById.isPresent()) {
			existedStudent = findById.get();
			
		//update each property except userID
			existedStudent.setStudentName("Mike");
			existedStudent.setStudentEmail("mike@gmail.com");
			existedStudent.setStudentMob("8888877777");
			repo.save(existedStudent);
			
		}else
			existedStudent = null;
		
		return existedStudent;
	}

	@Override
	public StudentDetails updateStudentWithDynamicValues(StudentDetails newStudent) {
		//get existed student from DB
		StudentDetails existedStudent = null;
		
		//get user based on ID
		Optional<StudentDetails> findById = repo.findById(newStudent.getStudentID());
		
		//check whether we get object from DB or not
		if(findById.isPresent()) {
			existedStudent = findById.get();
			
		//update each property except userID
			existedStudent.setStudentName(newStudent.getStudentName());
			existedStudent.setStudentEmail(newStudent.getStudentEmail());
			existedStudent.setStudentMob(newStudent.getStudentMob());
			repo.save(existedStudent);
			
		}
		
		return existedStudent;
	}
	
	@Override
	public String deleteStudentByID(Integer studentID) {
	
		String message=null;	
		boolean flag = false;
		
		//check whether it is present or not
		StudentDetails existedStudent = null;
		
		//get student based on ID
		Optional<StudentDetails> findById = repo.findById(studentID);
		
		//check whether we get object from DB or not
		if(findById.isPresent()) {
			flag = true; //if student is present
			//based on flag, send success or error message
			message = "Student is deleted Successfully";
			//Delete Student
			repo.deleteById(studentID);
			
		}else
			flag = false; //if student is not present;
			message = "Student not Found";
		
		return message;
	}

	@Override
	public StudentDetails getStudentByID(Integer studentID) {
	
		//check whether it is present or not
		StudentDetails existedStudent = null;
				
		//get user based on ID
		Optional<StudentDetails> findById = repo.findById(studentID);
				
		//check whether we get object from DB or not
		if(findById.isPresent()) {
			existedStudent = findById.get();
					
		}else
			existedStudent = null;
				
		return existedStudent;
	}

	@Override
	public List<StudentDetails> getAllStudent() {
		List<StudentDetails> allStudent = repo.findAll();
		
		//check whether database has any record to display
		if(allStudent.size()>0)
		return allStudent;
		else
			return null;
	}	

}
