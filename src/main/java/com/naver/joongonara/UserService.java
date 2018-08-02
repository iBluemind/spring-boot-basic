package com.naver.joongonara;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ObjectMapper objectMapper;

    public User profile(int id) {
        return userRepository.getOne(id);
    }

    public User signUp(UserDTO newUserDTO) {

        User createdUser = objectMapper.convertValue(newUserDTO, User.class);
        createdUser.setCreatedAt(LocalDateTime.now());

        return userRepository.save(createdUser);
    }
}
