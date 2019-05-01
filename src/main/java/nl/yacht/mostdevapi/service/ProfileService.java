package nl.yacht.mostdevapi.service;

import nl.yacht.mostdevapi.dto.ProfileDto;

public interface ProfileService {

    void addNewProfile(ProfileDto profileDto);

    ProfileDto getProfileByEmail(String email);
}
