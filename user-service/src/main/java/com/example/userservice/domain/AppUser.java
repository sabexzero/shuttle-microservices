package com.example.userservice.domain;

import com.example.userservice.web.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String surname;
    private Integer age;
    
    public UserDto toDto(){
        return new UserDto(
                id,
                name,
                surname,
                age
        );
    }
    
    public AppUser(
            String name,
            String surname,
            Integer age
    ) {
        this.id = null;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
