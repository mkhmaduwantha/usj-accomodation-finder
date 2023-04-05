package lk.usj.usjaccommodationfinder.beans.authentication;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequest {

    @NotBlank(message = "User id can not be null or empty")
    @Size(min = 3, max = 60, message = "User Id should me less than 60 characters and more than 3 characters")
    private String userId;

    @NotBlank(message = "Password can not be null or empty")
    @Size(min = 3, max = 100, message = "Password should me less than 100 characters and more than 3 characters")
    private String password;
}
