package com.cdac.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cdac.beans.StudentDetails;

@Repository
public interface StudentRepository extends JpaRepository<StudentDetails, Integer>{

}

 