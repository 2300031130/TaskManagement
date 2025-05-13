package com.klef.fsd.project.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectId;
	private String projectName;
	private String projectDescription;
	private LocalDate startDate;
	private LocalDate endDate;
	@ManyToOne
	@JoinColumn(name = "created_by")
	private Manager createdBy;
	
	public long getProjectId() {
		return projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public Manager getCreatedBy() {
		return createdBy;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public void setCreatedBy(Manager createdBy) {
		this.createdBy = createdBy;
	}
}
