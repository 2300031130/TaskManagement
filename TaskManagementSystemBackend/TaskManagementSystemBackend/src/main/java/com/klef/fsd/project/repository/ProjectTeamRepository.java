package com.klef.fsd.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.fsd.project.model.Developer;
import com.klef.fsd.project.model.Project;
import com.klef.fsd.project.model.ProjectTeam;

@Repository
public interface ProjectTeamRepository extends JpaRepository<ProjectTeam, Long>
{
    @Query("SELECT d FROM Developer d WHERE d.id NOT IN " +
           "(SELECT pt.developer.id FROM ProjectTeam pt WHERE pt.project.id = ?1)")
    List<Developer> getAvailableDevelopers(long projectId);
    
    @Query("SELECT pt.developer FROM ProjectTeam pt WHERE pt.project.id = ?1")
    List<Developer> getProjectDevelopers(long projectId);
    
    @Query("SELECT pt.project FROM ProjectTeam pt WHERE pt.developer.username = ?1")
    List<Project> getDevelopersProjects(String username);
}
