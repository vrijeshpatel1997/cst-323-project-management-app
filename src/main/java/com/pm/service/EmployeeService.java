package com.pm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.dao.EmployeeRepository;
import com.pm.dto.EmployeeProject;
import com.pm.entities.Employee;

@Service
public class EmployeeService {

	

	@Autowired
EmployeeRepository empRepo;




public Employee save (Employee employee) {
	
	return empRepo.save(employee);
}


public Iterable<Employee> getall(){
	return empRepo.findAll();
}


public List<EmployeeProject> employeeProjects() {
	return empRepo.employeeProjects();
}

public Employee findByEmployeeId(long theId) {
	// TODO Auto-generated method stub
	return empRepo.findByEmployeeId(theId);
}






public void delete(Employee employee) {
	empRepo.delete(employee);
	
}

}





