package com.example.externalauthenticationserver.dto.requests;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class UserCredentialReq {

    @NonNull
    private String email;
    @NonNull
    private String password;

    public UserCredentialReq() {
    }
}
