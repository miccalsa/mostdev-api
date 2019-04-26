package nl.yacht.mostdevapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import nl.yacht.mostdevapi.dto.ProfileDto;
import nl.yacht.mostdevapi.service.ProfileService;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<Object> addProfile(@RequestBody final ProfileDto profileDto) {
        this.profileService.addNewProfile(profileDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> getProfile(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(this.profileService.getProfileById(id), HttpStatus.OK);
    }
}
