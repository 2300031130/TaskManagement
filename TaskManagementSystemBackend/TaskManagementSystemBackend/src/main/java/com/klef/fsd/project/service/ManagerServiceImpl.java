package com.klef.fsd.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsd.project.dto.AssignDeveloperDTO;
import com.klef.fsd.project.model.Developer;
import com.klef.fsd.project.model.Manager;
import com.klef.fsd.project.model.Project;
import com.klef.fsd.project.model.ProjectTeam;
import com.klef.fsd.project.repository.DeveloperRepository;
import com.klef.fsd.project.repository.ManagerRepository;
import com.klef.fsd.project.repository.ProjectRepository;
import com.klef.fsd.project.repository.ProjectTeamRepository;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ProjectTeamRepository ptRepository;
	@Autowired
	private DeveloperRepository developerRepository;

	@Override
	public boolean register(Manager manager) {
		if(manager == null) {
			return false;
		}
		Optional<Manager> object = managerRepository.findById(manager.getUsername());
		if(object.isPresent()) return false;
		managerRepository.save(manager);
		return true;
	}

	@Override
	public Manager login(Manager manager) {
		Optional<Manager> object = managerRepository.findById(manager.getUsername());
		if(object.isEmpty()) return null;
		Manager loginManager  = object.get();
		if(loginManager.getPassword().equals(manager.getPassword())) {
			return loginManager;
		}
		return null;
	}

	@Override
	public boolean createProject(Project project) {
	    if (project == null || project.getCreatedBy() == null) {
	        return false;
	    }
	    Optional<Manager> object = managerRepository.findById(project.getCreatedBy().getUsername());
	    if (object.isEmpty()) {
	        return false; 
	    }
	    project.setCreatedBy(object.get());
	    projectRepository.save(project);
	    return true;
	}

	@Override
	public List<Project> myProjects(String username) {
		Optional<Manager> object = managerRepository.findById(username);
		if(object.isEmpty()) return null;
		List<Project> projectList =  projectRepository.findManagerProjectsById(username);
		if(projectList.isEmpty()) return new ArrayList<>();
		else return projectList;
	}

	@Override
	public List<Developer> getAvailableDevelopers(long projectId) {
		List<Developer> availableDevelopers = ptRepository.getAvailableDevelopers(projectId);
		return availableDevelopers;
	}

	@Override
	public boolean assignDeveloper(AssignDeveloperDTO developerDTO) {
		Optional<Developer> devObject = developerRepository.findById(developerDTO.getUsername());
		Optional<Project> proObject = projectRepository.findById(developerDTO.getProjectId());
		if(devObject.isEmpty() || proObject.isEmpty()) return false;
		Developer developer = devObject.get();
		Project project = proObject.get();
		if(developer == null || project == null) return false;
		ProjectTeam projectTeam = new ProjectTeam(project, developer);
		ptRepository.save(projectTeam);
		return true;
	}

	@Override
	public List<Developer> getTeamDevelopers(long projectId) {
		List<Developer> projectTeam =  ptRepository.getProjectDevelopers(projectId);
		if(projectTeam == null) return null;
		else return projectTeam;
	}


}
