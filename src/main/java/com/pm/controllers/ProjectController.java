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

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectRepository proRep;
	
	

@Autowired
EmployeeService empService;
	
	
	
	@GetMapping
	public String displayProjects(Model model) {
		
		List<Project> projects = proRep.findAll();
		model.addAttribute("projects", projects);
		
		return "listproject";
		
		
		
	}
	
	
	@RequestMapping("/new")
	public String displayProjectForm(Model model) {
		// use moodel to bind obj to views
		Project aproject = new Project();
	Iterable<Employee> employees = 	empService.getall();
	
		model.addAttribute("project", aproject);

		model.addAttribute("allEmployees", employees);
		
		
		return "newproject";
		
	}
	
	@RequestMapping("/save")
	public String createProjectForm(Project project, Model model) {
		// method to save data
	proRep.save(project);
	
	
	return "redirect:/projects/new";
		
	}
	}

