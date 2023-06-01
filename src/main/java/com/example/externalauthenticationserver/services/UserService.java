package com.example.externalauthenticationserver.services;

import com.example.externalauthenticationserver.dto.requests.UserCredentialReq;
import com.example.externalauthenticationserver.dto.response.GetRequiredInfoResponse;
import com.example.externalauthenticationserver.exceptions.UserAlreadyRegisterException;
import com.example.externalauthenticationserver.models.User;
import com.example.externalauthenticationserver.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public GetRequiredInfoResponse register(UserCredentialReq credentialReq) throws UserAlreadyRegisterException {
        User user = userRepository.findByEmail(credentialReq.getEmail());
        if(user != null) {
            throw new UserAlreadyRegisterException("This user already was registered!");
        }


    }
}
