package nl.yacht.mostdevapi.model;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("profile")
public class Profile {

    @Id
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

        Profile profile = (Profile) o;

        return new EqualsBuilder()
            .append(getId(), profile.getId())
            .append(getName(), profile.getName())
            .append(getRole(), profile.getRole())
            .append(getDescription(), profile.getDescription())
            .append(getSocialMediaList(), profile.getSocialMediaList())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(getId())
            .append(getName())
            .append(getRole())
            .append(getDescription())
            .append(getSocialMediaList())
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
}
