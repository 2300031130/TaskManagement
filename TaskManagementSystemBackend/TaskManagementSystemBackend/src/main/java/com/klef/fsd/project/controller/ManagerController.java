package com.klef.fsd.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.fsd.project.dto.AssignDeveloperDTO;
import com.klef.fsd.project.model.Developer;
import com.klef.fsd.project.model.Manager;
import com.klef.fsd.project.model.Project;
import com.klef.fsd.project.service.ManagerService;

@RequestMapping("manager")
@RestController
@CrossOrigin
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("register")
    public ResponseEntity<String> registerManager(@RequestBody Manager manager) {
        if (managerService.register(manager)) {
            return ResponseEntity.ok().body("Manager Registered Successfully");
        }
        return ResponseEntity.badRequest().body("User with Username or Email already Exist");
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody Manager manager) {
        Manager loggedInManager = managerService.login(manager);
        if (loggedInManager == null) {
            return ResponseEntity.badRequest().body("Invalid Credentials");
        }
        return ResponseEntity.ok(loggedInManager);
    }

    @PostMapping("createproject")
    public ResponseEntity<String> createProject(@RequestBody Project project) {
        if (managerService.createProject(project)) {
            return ResponseEntity.ok("Project Created Successfully");
        } else {
        	System.out.println(project.toString());
        	return ResponseEntity.badRequest().body("Failed to Create Project");
        }
    }
    
    @GetMapping("myprojects/{username}")
    public ResponseEntity<?> myProjects(@PathVariable String username) {
    	List<Project> projectList = managerService.myProjects(username);
    	if(projectList == null) return ResponseEntity.badRequest().body("Manager Not Found");
    	return ResponseEntity.ok(projectList);
    }
    
    @GetMapping("project/{projectId}/getdevelopers")
    public ResponseEntity<?> getAvailableDevelopers(@PathVariable long projectId){ 
    	List<Developer> availableDevelopers = managerService.getAvailableDevelopers(projectId);
    	if(availableDevelopers == null) {
    		return ResponseEntity.badRequest().build();
    	}
    	return ResponseEntity.ok(availableDevelopers);
    }
    
    @PostMapping("project/assigndeveloper")
    public ResponseEntity<?> assignDeveloper(@RequestBody AssignDeveloperDTO assignDeveloper){
    	boolean isDeveloperAssigned =  managerService.assignDeveloper(assignDeveloper);
    	if(isDeveloperAssigned) {
    		return ResponseEntity.ok("Developer Assigned Successfully");
    	}
    	else {
    		return ResponseEntity.badRequest().body("Failed to Assign Developer");
    	}
    }
    
    @GetMapping("project/{projectId}/viewallmembers")
    public ResponseEntity<?> getProjectMembers(@PathVariable long projectId) {
    	List<Developer> developersTeam =  managerService.getTeamDevelopers(projectId);
    	if(developersTeam == null) {
    		return ResponseEntity.badRequest().build();
    	}
    	else {
    		return ResponseEntity.ok(developersTeam);
    	}
    } 
    
}
