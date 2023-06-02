package com.example.externalauthenticationserver.services;

import com.example.externalauthenticationserver.dto.requests.UserCredentialRequest;
import com.example.externalauthenticationserver.dto.response.RegistrationResponse;
import com.example.externalauthenticationserver.exceptions.InvalidEmailOrPasswordException;
import com.example.externalauthenticationserver.exceptions.UserAlreadyRegisterException;
import com.example.externalauthenticationserver.models.User;
import com.example.externalauthenticationserver.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public RegistrationResponse register(UserCredentialRequest credentialReq) throws  InvalidEmailOrPasswordException {
        User user = userRepository.findByEmail(credentialReq.getEmail());

        // Validate email and password
        if(!user.getEmail().equals(credentialReq.getEmail()) || !user.getPassword().equals(credentialReq.getPassword())){
            throw new InvalidEmailOrPasswordException("Invalid Email or Password");
        }

        RegistrationResponse responseUser = new RegistrationResponse().builder()
                .name(user.getName())
                .surname(user.getSurname())
                .departmentName(user.getDepartmentName())
                .email(user.getEmail())
                .grade(user.getGrade())
                .studentNumber(user.getStudentNumber())
                .build();
        return  responseUser;
    }
}
