package com.calendar.calendar.controller;

import com.calendar.calendar.Entities.Users;
import com.calendar.calendar.Services.UsersService;
import com.calendar.calendar.dto.UsersDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UsersService usersService;

    private ModelMapper modelMapper;

    @Autowired
    public UserController(UsersService usersService, ModelMapper modelMapper) {
        this.usersService = usersService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/")
    public UsersDto createUser(@RequestBody UsersDto userDto) {
        Users user = modelMapper.map(userDto, Users.class);
        Users createdUser = usersService.createUser(user);
        return modelMapper.map(createdUser, UsersDto.class);
    }

}
