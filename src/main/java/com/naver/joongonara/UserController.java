package com.naver.joongonara;

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

    @PostMapping
    @ResponseBody
    ResponseEntity<User> signUp(@RequestBody User newUser) {

        if (!isValidAge(newUser.getAge())) {
            // Bad Request 400
            return ResponseEntity.badRequest().build();
        }

        if (!isValidEmailAddress(newUser.getEmail())) {
            // Bad Request 400
            return ResponseEntity.badRequest().build();
        }
        // Create User
        User createdUser = userService.signUp(newUser);

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
