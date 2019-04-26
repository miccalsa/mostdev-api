package nl.yacht.mostdevapi.dto;

import java.util.Objects;

public class ErrorDto {

    private String message;

    public ErrorDto() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ErrorDto errorDto = (ErrorDto) o;
        return Objects.equals(message, errorDto.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    @Override
    public String toString() {
        return "ErrorDto{" +
            "message='" + message + '\'' +
            '}';
    }
}
