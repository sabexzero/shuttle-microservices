package com.example.userservice.service.kafka;


import com.example.userservice.service.user.UserService;
import com.example.userservice.web.requests.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final UserService userService;

    @KafkaListener(topics = "testKafka2", groupId = "myGroup")
    public void listen(String message) {
        log.info(message);
        CreateUserRequest createUserRequest =
                new CreateUserRequest(
                        "denchik",
                        message,
                        12
                );
        userService.createUser(createUserRequest);
    }
}
