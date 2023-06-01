package com.example.externalauthenticationserver.controllers;

import com.example.externalauthenticationserver.dto.requests.UserCredentialReq;
import com.example.externalauthenticationserver.dto.response.GetRequiredInfoResponse;
import com.example.externalauthenticationserver.exceptions.UserAlreadyRegisterException;
import com.example.externalauthenticationserver.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;
    public GetRequiredInfoResponse register(@RequestBody UserCredentialReq credentialReq) throws UserAlreadyRegisterException {
        return this.userService.register(credentialReq);
    }
}
