package com.training.services;
import java.util.*;

import com.training.entity.Student;

public class StudentServiceImpl {
	private HashMap<Integer,Student> studentList = null;

	public StudentServiceImpl() {
		super();
		this.studentList = new HashMap<>();
	}
	
	public void init() {
		
		this.studentList.put(1, new Student(1,"Ramesh"));
		this.studentList.put(2, new Student(2,"Sumesh"));
		this.studentList.put(3, new Student(3,"Magesh"));
	}
	public Student findById(int key) {
		studentList.clear();
		init();
		
		if(this.studentList.get(key)!=null) {
			System.out.println(this.studentList.get(key));
			return  this.studentList.get(key);
		}else {
			throw new NoSuchElementException("Student Not Found");
		}
	}
	
	public HashMap<Integer,Student> findAll() {
		
		return this.studentList;
		
	}
}
