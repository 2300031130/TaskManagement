package com.klef.fsd.project.service;

import java.util.List;

import com.klef.fsd.project.dto.AssignDeveloperDTO;
import com.klef.fsd.project.model.Developer;
import com.klef.fsd.project.model.Manager;
import com.klef.fsd.project.model.Project;

public interface ManagerService {
	public boolean register(Manager manager);
	public Manager login(Manager manager);
	public boolean createProject(Project project);
	public List<Project> myProjects(String username);
	public List<Developer> getAvailableDevelopers(long projectId);
	public boolean assignDeveloper(AssignDeveloperDTO developerDTO);
	public List<Developer> getTeamDevelopers(long projectId);
}
