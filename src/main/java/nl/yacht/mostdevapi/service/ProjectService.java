package nl.yacht.mostdevapi.service;


import java.util.List;


import nl.yacht.mostdevapi.dto.ProjectDto;
import nl.yacht.mostdevapi.model.Project;

public interface ProjectService {

    void addNewProject(ProjectDto projectDto);

    Project findProjectById(String id);

    List<Project> listAllProjects();
}
