package com.example.externalauthenticationserver.controllers;

import com.example.externalauthenticationserver.dto.requests.UserCredentialRequest;
import com.example.externalauthenticationserver.dto.response.RegistrationResponse;
import com.example.externalauthenticationserver.exceptions.InvalidEmailOrPasswordException;
import com.example.externalauthenticationserver.exceptions.UserAlreadyRegisterException;
import com.example.externalauthenticationserver.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")

public class UserController {

    private UserService userService;
    @PostMapping("")
    public RegistrationResponse register(@RequestBody UserCredentialRequest credentialReq) throws InvalidEmailOrPasswordException {
        return this.userService.register(credentialReq);
    }

}
