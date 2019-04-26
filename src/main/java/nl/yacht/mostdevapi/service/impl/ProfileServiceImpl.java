package nl.yacht.mostdevapi.service.impl;

import org.springframework.stereotype.Service;


import nl.yacht.mostdevapi.dto.ProfileDto;
import nl.yacht.mostdevapi.model.NotFoundException;
import nl.yacht.mostdevapi.model.Profile;
import nl.yacht.mostdevapi.repository.ProfileRepository;
import nl.yacht.mostdevapi.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    @Override
    public void addNewProfile(ProfileDto profileDto) {
        Profile profile = new Profile();

        this.profileRepository.save(profile);
    }

    @Override
    public ProfileDto getProfileById(String id) {
        Profile result = this.profileRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("No profile found with id: " + id));

        return ProfileDto.convertProfileToDto(result);
    }
}
