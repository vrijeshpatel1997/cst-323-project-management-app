package com.pm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pm.dao.EmployeeRepository;
import com.pm.dao.ProjectRepository;
import com.pm.dto.EmployeeProject;
import com.pm.entities.Employee;
import com.pm.entities.Project;
import com.pm.service.EmployeeService;

@Controller


public class HomeController {
	@Autowired
	ProjectRepository proRepo;
	
	
	@Autowired
	EmployeeRepository empRepo;
	
	
	@Autowired
	EmployeeService empService;
	
	
	@GetMapping("/")
	public   String displayhome(Model model) {
		
		 List<Project> projects = proRepo.findAll();
		 
		 model.addAttribute("projects", projects);
		 
		 
		 List<EmployeeProject> employeesProjectCnt = empService.employeeProjects();
		 model.addAttribute("employeeListProjectCnt", employeesProjectCnt);
		 
		 return "home";
	}
}
