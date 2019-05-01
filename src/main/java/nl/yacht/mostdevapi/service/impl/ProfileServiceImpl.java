package nl.yacht.mostdevapi.service.impl;

import java.util.List;

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
    public ProfileDto getProfileByEmail(String email) {
        List<Profile> result = this.profileRepository.findByEmail(email);
        if (result.isEmpty()) {
            throw new NotFoundException("No profile found with email: " + email);
        } else {
            return ProfileDto.convertProfileToDto(result.get(0));
        }
    }
}
