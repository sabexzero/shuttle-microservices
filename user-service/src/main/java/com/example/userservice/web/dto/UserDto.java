package com.example.userservice.web.dto;

import com.example.userservice.domain.AppUser;

public record UserDto(
    Long id,
    String name,
    String surname,
    Integer age
) {
    public AppUser toDomain(){
        return new AppUser(
                id,
                name,
                surname,
                age
        );
    }
}
