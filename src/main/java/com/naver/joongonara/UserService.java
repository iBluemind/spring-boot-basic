package com.naver.joongonara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User signUp(User newUser) {
        User createdUser = new User();

        createdUser.setName(newUser.getName());
        createdUser.setAddress(newUser.getAddress());
        createdUser.setAge(newUser.getAge());
        createdUser.setEmail(newUser.getEmail());
        createdUser.setGender(newUser.getGender());
        createdUser.setCreatedAt(LocalDateTime.now());

        return userRepository.save(createdUser);
    }
}
