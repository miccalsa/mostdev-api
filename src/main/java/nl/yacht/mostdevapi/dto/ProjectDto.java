package nl.yacht.mostdevapi.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


import nl.yacht.mostdevapi.model.Project;

public class ProjectDto {

    private String id;
    private String name;
    private String internalName;
    private String description;
    private int port;
    private String codeLink;
    private String wikiLink;
    private String demoLink;

    public ProjectDto() {}

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

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getCodeLink() {
        return codeLink;
    }

    public void setCodeLink(String codeLink) {
        this.codeLink = codeLink;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }

    public String getDemoLink() {
        return demoLink;
    }

    public void setDemoLink(String demoLink) {
        this.demoLink = demoLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        ProjectDto that = (ProjectDto) o;

        return new EqualsBuilder()
            .append(getPort(), that.getPort())
            .append(getId(), that.getId())
            .append(getName(), that.getName())
            .append(getInternalName(), that.getInternalName())
            .append(getDescription(), that.getDescription())
            .append(getCodeLink(), that.getCodeLink())
            .append(getWikiLink(), that.getWikiLink())
            .append(getDemoLink(), that.getDemoLink())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(getId())
            .append(getName())
            .append(getInternalName())
            .append(getDescription())
            .append(getPort())
            .append(getCodeLink())
            .append(getWikiLink())
            .append(getDemoLink())
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("name", name)
            .append("internalName", internalName)
            .append("description", description)
            .append("port", port)
            .append("codeLink", codeLink)
            .append("wikiLink", wikiLink)
            .append("demoLink", demoLink)
            .toString();
    }

    public static ProjectDto convertProjectToDto(Project project) {
        ProjectDto dto = new ProjectDto();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setInternalName(project.getInternalName());
        dto.setDescription(project.getDescription());
        dto.setPort(project.getPort());
        dto.setCodeLink(String.format("https://gitlab.com/mostdev/%s", project.getInternalName()));
        dto.setWikiLink(String.format("https://gitlab.com/mostdev/%s/wikis/home", project.getInternalName()));
        dto.setDemoLink(String.format("https://vps.mostdev.io/%s", project.getInternalName()));
        return dto;
    }
}
