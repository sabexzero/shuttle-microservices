package com.example.userservice.web.requests;

import com.example.userservice.domain.User;

public record CreateUserRequest(
        String name,
        String surname,
        Integer age
) {
    public User toDomain(){
        return new User(
            name,
            surname,
            age
        );
    }
}
