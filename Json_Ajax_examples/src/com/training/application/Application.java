package com.training.application;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.training.entity.Employee;

public class Application {

	public static void main(String[] args) throws JsonIOException, IOException {
		Gson gson = new Gson();
		//Employee obj = new Employee();
		Employee [] obj = gson.fromJson(new FileReader("F:\\New folder (2)\\List.json"), Employee[].class);
		for (Employee employee : obj) {
			System.out.println(employee);
		}
	}

}
