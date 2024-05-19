package com.example.userservice.web.dto;

import com.example.userservice.domain.User;

public record UserDto(
    Long id,
    String name,
    String surname,
    Integer age
) {
    public User toDomain(){
        return new User(
                id,
                name,
                surname,
                age
        );
    }
}
