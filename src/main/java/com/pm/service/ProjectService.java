package com.pm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.dao.ProjectRepository;
import com.pm.entities.Project;

@Service
public class ProjectService {

	
	
	@Autowired
	ProjectRepository proRepo;
	
	
	public Project save(Project project) {
		return proRepo.save(project);
	}


	public List<Project> getAll() {
		return proRepo.findAll();
	}
	
	
	
	
	
}

