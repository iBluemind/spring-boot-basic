package com.naver.joongonara.controller;

import com.naver.joongonara.domain.entity.User;
import com.naver.joongonara.domain.dto.UserDTO;
import com.naver.joongonara.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/{id}")
    @ResponseBody
    ResponseEntity<User> profile(@PathVariable int id) {
        User me = userService.profile(id);
        return ResponseEntity.ok(me);
    }

    @PostMapping
    @ResponseBody
    ResponseEntity<User> signUp(@RequestBody UserDTO newUserDTO) {
        if (!isValidAge(newUserDTO.getAge())) {
            // Bad Request 400
            return ResponseEntity.badRequest().build();
        }

        if (!isValidEmailAddress(newUserDTO.getEmail())) {
            // Bad Request 400
            return ResponseEntity.badRequest().build();
        }

        // Create User
        User createdUser = userService.signUp(newUserDTO);

        // Return response
        return ResponseEntity.ok(createdUser);
    }

    Boolean isValidAge(int age) {
        return (age >= 12) && (age <= 70);
    }

    Boolean isValidEmailAddress(String emailAddress) {
        Pattern emailAddressRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailAddressRegex .matcher(emailAddress);

        return matcher.find();
    }
}
