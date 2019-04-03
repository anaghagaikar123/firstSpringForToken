package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Student;

@Service 
@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentDAO studentDAO;
	
	@Override
	public void save(Student std) {
		studentDAO.save(std);
	}

}
