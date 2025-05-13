package com.klef.fsd.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.fsd.project.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	@Query("select p from Project p where p.createdBy.username = ?1")
	List<Project> findManagerProjectsById(String username);
}
