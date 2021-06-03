package com.pm.dao;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.pm.entities.Project;

public interface ProjectRepository  extends CrudRepository<Project, Long>{

	
	
	@Override
	
	public List <Project> findAll();



	
}
