package com.klef.fsd.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.fsd.project.model.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, String>
{

}
