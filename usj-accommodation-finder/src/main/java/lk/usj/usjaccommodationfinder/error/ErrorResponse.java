package lk.usj.usjaccommodationfinder.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * The custom error bean class
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = 8519841229465526585L;

    private String code;
    private String description;
    private String additionalInfo;

    public ErrorResponse() {

    }

    public ErrorResponse(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public ErrorResponse(String code, String description, String additionalInfo) {
        this.code = code;
        this.description = description;
        this.additionalInfo = additionalInfo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
              "code='" + code + '\'' +
              ", description='" + description + '\'' +
              ", additionalInfo='" + additionalInfo + '\'' +
              '}';
    }
}
