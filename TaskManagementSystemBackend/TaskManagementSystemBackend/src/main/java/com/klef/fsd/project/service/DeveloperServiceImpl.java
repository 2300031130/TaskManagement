package com.klef.fsd.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsd.project.model.Developer;
import com.klef.fsd.project.model.Project;
import com.klef.fsd.project.repository.DeveloperRepository;
import com.klef.fsd.project.repository.ProjectTeamRepository;

@Service
public class DeveloperServiceImpl implements DeveloperService{
	@Autowired
	private DeveloperRepository developerRepository;
	@Autowired
	private ProjectTeamRepository ptRepository;
	
	@Override
	public boolean register(Developer developer) {
		if(developer == null) {
			return false;
		}
		Optional<Developer> object = developerRepository.findById(developer.getUsername());
		if(object.isPresent()) return false;
		developerRepository.save(developer);
		return true;
	}

	@Override
	public Developer login(Developer developer) {
		Optional<Developer> object = developerRepository.findById(developer.getUsername());
		if(object.isEmpty()) return null;
		Developer loginDeveloper  = object.get();
		if(loginDeveloper.getPassword().equals(developer.getPassword())) {
			return loginDeveloper;
		}
		return null;
	}

	@Override
    public List<Project> getMyProjects(String username) {
        return ptRepository.getDevelopersProjects(username);
    }
}
