package nl.yacht.mostdevapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import nl.yacht.mostdevapi.model.Project;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
}
