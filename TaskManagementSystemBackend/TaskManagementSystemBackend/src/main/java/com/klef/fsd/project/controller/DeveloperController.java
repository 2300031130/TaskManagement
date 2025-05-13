package com.klef.fsd.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.fsd.project.model.Developer;
import com.klef.fsd.project.model.Project;
import com.klef.fsd.project.service.DeveloperService;

@RequestMapping("developer")
@RestController
@CrossOrigin("*")
public class DeveloperController {
	
	@Autowired
	private DeveloperService developerService;
	
	@PostMapping("register")
	public ResponseEntity<String> register(@RequestBody Developer developer) {
		if(developerService.register(developer)) {
			return ResponseEntity.ok("Account Created Successfully");
		}
		else return ResponseEntity.badRequest().body("User already exists with same Username or Email");
	}
 	
	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody Developer developer){
		Developer loggedInDeveloper = developerService.login(developer);
		if(loggedInDeveloper == null) {
			return ResponseEntity.badRequest().body("Invalid Credentials");
		}
		return ResponseEntity.ok(loggedInDeveloper);
	}
	
    @GetMapping("/projects/{username}")
    public ResponseEntity<List<Project>> getMyProjects(@PathVariable String username) {
        List<Project> projectList = developerService.getMyProjects(username);
        return ResponseEntity.ok(projectList);
    }
}
