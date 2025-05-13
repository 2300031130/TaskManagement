package com.klef.fsd.project.model;

import jakarta.persistence.*;

@Entity
public class ProjectTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
    @ManyToOne
    @JoinColumn(name = "developer_id", nullable = false)
    private Developer developer;
    public ProjectTeam() {}
    public ProjectTeam(Project project, Developer developer) {
        this.project = project;
        this.developer = developer;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }
    public Developer getDeveloper() {
        return developer;
    }
    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}