package nl.yacht.mostdevapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;


import nl.yacht.mostdevapi.dto.ProjectDto;
import nl.yacht.mostdevapi.model.NotFoundException;
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
        project.setInternalName(projectDto.getInternalName());
        project.setPort(projectDto.getPort());

        this.projectRepository.save(project);
    }

    @Override
    public void removeProject(String id) {
        this.projectRepository.deleteById(id);
    }

    @Override
    public ProjectDto findProjectById(String id) throws NotFoundException {
        Project foundProject = this.projectRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("No project found with id: " + id ));
        return ProjectDto.convertProjectToDto(foundProject);
    }

    @Override
    public List<ProjectDto> listAllProjects() {
        return this.projectRepository
            .findAll()
            .stream()
            .map(ProjectDto::convertProjectToDto)
            .collect(Collectors.toList());
    }
}
