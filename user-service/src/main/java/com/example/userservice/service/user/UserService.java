package com.example.userservice.service.user;

import com.example.userservice.web.dto.UserDto;
import com.example.userservice.web.requests.CreateUserRequest;

public interface UserService {
    UserDto createUser(CreateUserRequest request);
    UserDto getUserById(Long userId);
}
