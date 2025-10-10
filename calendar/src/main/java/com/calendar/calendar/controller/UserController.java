package com.calendar.calendar.controller;

import com.calendar.calendar.Entities.Users;
import com.calendar.calendar.Services.UsersService;
import com.calendar.calendar.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UsersService usersService;
    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping()
    public ResponseEntity<Users> createUser(@RequestBody UsersDto userDto) {
        Users user = usersService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Long id) {
        return usersService.getUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
