package com.example.userservice.web.requests;

import com.example.userservice.domain.AppUser;

public record CreateUserRequest(
        String name,
        String surname,
        Integer age
) {
    public AppUser toDomain(){
        return new AppUser(
            name,
            surname,
            age
        );
    }
}
