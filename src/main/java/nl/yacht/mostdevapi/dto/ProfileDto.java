package nl.yacht.mostdevapi.dto;

import java.util.List;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


import nl.yacht.mostdevapi.model.Profile;
import nl.yacht.mostdevapi.model.SocialMedia;

public class ProfileDto {

    private String id;
    private String name;
    private String role;
    private String description;
    private List<SocialMedia> socialMediaList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SocialMedia> getSocialMediaList() {
        return socialMediaList;
    }

    public void setSocialMediaList(List<SocialMedia> socialMediaList) {
        this.socialMediaList = socialMediaList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        ProfileDto that = (ProfileDto) o;

        return new EqualsBuilder()
            .append(id, that.id)
            .append(name, that.name)
            .append(role, that.role)
            .append(description, that.description)
            .append(socialMediaList, that.socialMediaList)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(id)
            .append(name)
            .append(role)
            .append(description)
            .append(socialMediaList)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("name", name)
            .append("role", role)
            .append("description", description)
            .append("socialMediaList", socialMediaList)
            .toString();
    }

    public static ProfileDto convertProfileToDto(Profile profile) {
        final ProfileDto profileDto = new ProfileDto();
        profileDto.setId(profile.getId());
        profileDto.setName(profile.getName());
        profileDto.setRole(profile.getRole());
        profileDto.setDescription(profileDto.getDescription());
        profileDto.setSocialMediaList(profile.getSocialMediaList());

        return profileDto;
    }
}
