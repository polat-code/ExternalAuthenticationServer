package com.example.externalauthenticationserver.services;

import com.example.externalauthenticationserver.dto.requests.UserCredentialRequest;
import com.example.externalauthenticationserver.dto.response.RegistrationResponse;
import com.example.externalauthenticationserver.exceptions.UserAlreadyRegisterException;
import com.example.externalauthenticationserver.models.User;
import com.example.externalauthenticationserver.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public RegistrationResponse register(UserCredentialRequest credentialReq) throws UserAlreadyRegisterException {
        User user = userRepository.findByEmail(credentialReq.getEmail());
        if(user != null) {
            throw new UserAlreadyRegisterException("This user already was registered!");
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
