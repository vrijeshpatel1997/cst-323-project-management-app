package com.pm.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


// This will create table for us in database
@Entity 
public class Project {
	
	// This will map to table in database 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long projectId;
	
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	private String name;
	private String stage;
	
	private String description;
	
	
	@ManyToMany(cascade = {CascadeType.DETACH , CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},  fetch = FetchType.LAZY) 
	@JoinTable(name="project_employee",
				joinColumns=@JoinColumn(name="project_id"),
	inverseJoinColumns = @JoinColumn(name="employee_id")
	
	)
	
	private List<Employee> employee;
	
	public void addEmployee(Employee emp) {
		if(employee==null) {
			employee = new ArrayList<>();
		}
		employee.add(emp);
	}

	
	public Project() {
		
	}
	public Project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
