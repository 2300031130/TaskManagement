package com.klef.fsd.project.service;

import java.util.List;

import com.klef.fsd.project.model.Developer;
import com.klef.fsd.project.model.Project;

public interface DeveloperService {
	public boolean register(Developer developer);
	public Developer login(Developer developer);
	public List<Project> getMyProjects(String username);
}
