package com.naver.joongonara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @ResponseBody
    User signUp(@RequestBody User newUser) {
        return userService.signUp(newUser);
    }
}
