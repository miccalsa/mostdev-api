package nl.yacht.mostdevapi.service;

import java.util.List;

import nl.yacht.mostdevapi.dto.ProjectDto;

public interface ProjectService {

    void addNewProject(ProjectDto projectDto);

    void removeProject(String id);

    ProjectDto findProjectById(String id);

    List<ProjectDto> listAllProjects();
}
