package com.pm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pm.dao.EmployeeRepository;
import com.pm.entities.Employee;
import com.pm.service.EmployeeService;

@Controller

public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	EmployeeService empservice;

	@GetMapping
	public String displayEmployee(Model model) {

		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employees", employees);

		return "listemployee";

	}

	@RequestMapping("/employees")
	public String displayEmployeeForm(Model model) {
		// use moodel to bind obj to views
		Employee aEmployee = new Employee();
		model.addAttribute("employee", aEmployee);

		return "newemployee";

	}

	@PostMapping("/save")
	public String createEmployeeForm(Employee employee, Model model, Errors errors) {

		if (errors.hasErrors())
			return "newemployee";

		// save to the database using an employee crud repository

		List<Employee> getall = (List<Employee>) empservice.getall();
		model.addAttribute("employees", getall);
		empservice.save(employee);
		return "listemployee";
	}

	@GetMapping("/listemployee")
	public String listEmployee(Model model) {
		List<Employee> getall = (List<Employee>) empservice.getall();
		model.addAttribute("employees", getall);
		return "listemployee";
	}

	@GetMapping("/update")
	public String displayEmployeeupdateform(@RequestParam("id") long theid, Model model) {

		Employee theEmp = empservice.findByEmployeeId(theid);

		model.addAttribute("employee", theEmp);
		return "newemployee";

	}

	@GetMapping("/delete")
	public String deleteproduct(@RequestParam("id") long theid, Model model) {
		Employee theEmp = empservice.findByEmployeeId(theid);

		empservice.delete(theEmp);

		return "redirect:/employees";

	}

}
