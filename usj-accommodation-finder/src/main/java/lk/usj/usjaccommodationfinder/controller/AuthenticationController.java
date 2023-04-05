package lk.usj.usjaccommodationfinder.controller;

import jakarta.validation.Valid;
import lk.usj.usjaccommodationfinder.beans.authentication.LoginRequest;
import lk.usj.usjaccommodationfinder.beans.enums.UserType;
import lk.usj.usjaccommodationfinder.manager.AuthenticationManager;
import lk.usj.usjaccommodationfinder.repository.ProprietorRepository;
import lk.usj.usjaccommodationfinder.repository.RoleRepository;
import lk.usj.usjaccommodationfinder.repository.TenantRepository;
import lk.usj.usjaccommodationfinder.security.jwt.JwtProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TenantRepository tenantRepository;

    @Autowired
    ProprietorRepository proprietorRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    @Qualifier("passwordEncoder")
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping(value = "/user/{userType}/signin", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest,
                                              @PathVariable UserType userType) {
        LOGGER.info("Request received to authenticate user [{}]", userType);
        return null;
    }
}
