package com.calendar.calendar.controller;

import com.calendar.calendar.Services.UsersService;
import com.calendar.calendar.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UsersService usersService;
    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping()
    public void createUser(@RequestBody UsersDto userDto) {
    }

}
