package com.pm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.pm.dao.EmployeeRepository;
import com.pm.dao.ProjectRepository;
import com.pm.entities.Employee;
import com.pm.entities.Project;
import com.pm.service.EmployeeService;
import com.pm.service.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectService proRep;	
	
	
	@GetMapping
	public String displayProjects(Model model) {
		
		List<Project> projects = proRep.getAll();
		model.addAttribute("projects", projects);
		
		return "listproject";
		
		
		
	}
	
	
	@RequestMapping("/new")
	public String displayProjectForm(Model model) {
		// use moodel to bind obj to views
		Project aproject = new Project();
	//Iterable<Employee> employees = 	pro.getall();
	
		model.addAttribute("project", aproject);

		//model.addAttribute("allEmployees", employees);
		
		
		return "newproject";
		
	}
	
	@RequestMapping("/save")
	public String createProjectForm(Project project, Model model) {
		// method to save data
		
	proRep.save(project);
	List<Project> getall = (List<Project>) proRep.getAll();
	model.addAttribute("projects", getall);
	
	return "listproject";
		
	}
	}

