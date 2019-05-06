package nl.yacht.mostdevapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import nl.yacht.mostdevapi.dto.ProjectDto;
import nl.yacht.mostdevapi.service.ProjectService;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<Object> addProject(@RequestBody final ProjectDto projectDto) {
        this.projectService.addNewProject(projectDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> removeProject(@PathVariable(value = "id") String id) {
        this.projectService.removeProject(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> listProjects() {
        return new ResponseEntity<>(this.projectService.listAllProjects(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> getProject(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(this.projectService.findProjectById(id), HttpStatus.OK);
    }
}
