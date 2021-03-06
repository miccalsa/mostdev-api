package nl.yacht.mostdevapi.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("project")
public class Project {

    @Id
    private String id;
    private String name;
    private String internalName;
    private String description;
    private int port;

    public Project() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        Project project = (Project) o;

        return new EqualsBuilder()
            .append(getPort(), project.getPort())
            .append(getId(), project.getId())
            .append(getName(), project.getName())
            .append(getInternalName(), project.getInternalName())
            .append(getDescription(), project.getDescription())
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
            .toString();
    }
}
