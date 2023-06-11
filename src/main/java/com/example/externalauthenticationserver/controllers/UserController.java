package com.example.externalauthenticationserver.controllers;

import com.example.externalauthenticationserver.dto.requests.UserCredentialRequest;
import com.example.externalauthenticationserver.dto.response.RegistrationResponse;
import com.example.externalauthenticationserver.exceptions.InvalidEmailOrPasswordException;
import com.example.externalauthenticationserver.exceptions.UserAlreadyRegisterException;
import com.example.externalauthenticationserver.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(origins = "https://votingsystem.herokuapp.com")
public class UserController {

    private UserService userService;

    @PostMapping("/user/register-info")
    public RegistrationResponse register(@RequestBody UserCredentialRequest credentialReq) throws InvalidEmailOrPasswordException {
        return this.userService.register(credentialReq);
    }

    @PostMapping("/log-in")
    public ResponseEntity<Object> logIn(@RequestBody UserCredentialRequest credentialReq){
        return this.userService.logIn(credentialReq);
    }

}
