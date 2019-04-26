package nl.yacht.mostdevapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import nl.yacht.mostdevapi.model.Profile;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {
}