package com.pm;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.pm.dao.EmployeeRepository;
import com.pm.dao.ProjectRepository;


@SpringBootApplication
public class ProjectmanagementApplication {

	
	@Autowired
	EmployeeRepository empRepo;
	
	
	@Autowired
	ProjectRepository projRepo;
	public static void main(String[] args) {
		SpringApplication.run(ProjectmanagementApplication.class, args);
		
	}
		
		
		
		
		
	}