package nl.yacht.mostdevapi.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;


import nl.yacht.mostdevapi.dto.ProjectDto;
import nl.yacht.mostdevapi.model.Project;
import nl.yacht.mostdevapi.repository.ProjectRepository;
import nl.yacht.mostdevapi.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void addNewProject(ProjectDto projectDto) {
        final Project project = new Project();
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setPort(projectDto.getPort());

        this.projectRepository.save(project);
    }

    @Override
    public Project findProjectById(String id) {
        return this.projectRepository.findById(id).orElse(new Project());
    }

    @Override
    public List<Project> listAllProjects() {
        return this.projectRepository.findAll();
    }
}