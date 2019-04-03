package com.example.demo;

import org.springframework.stereotype.Repository;

import com.example.entity.Student;

@Repository
public class StudentDAOImpl extends GenericDAOImpl<Student,Long> implements StudentDAO{

}
