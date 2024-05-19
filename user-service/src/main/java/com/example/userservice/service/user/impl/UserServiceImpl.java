package com.example.userservice.service.user.impl;

import com.example.userservice.validation.defects.UserDefects;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.user.UserService;
import com.example.userservice.validation.Validator;
import com.example.userservice.web.dto.UserDto;
import com.example.userservice.web.requests.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    
    @Override
    public UserDto createUser(CreateUserRequest request) {
        return userRepository.save(
                request.toDomain()
        ).toDto();
    }
    
    @Override
    public UserDto getUserById(Long userId) {
        var validator = new Validator<>(userId);
        
        var user = userRepository.findById(userId);
        
        validator.item(userId, "userId")
                .check(
                        user.isPresent(),
                        UserDefects.USER_NOT_EXIST
                );
        
        validator.validate();
        
        return user.get().toDto();
    }
}
