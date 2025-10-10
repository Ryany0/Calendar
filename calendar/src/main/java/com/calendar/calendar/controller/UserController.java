package com.calendar.calendar.controller;

import com.calendar.calendar.Services.UsersService;
import com.calendar.calendar.dto.UsersSaveDto;
import com.calendar.calendar.dto.UsersResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UsersResponseDto> createUser(@RequestBody UsersSaveDto userDto) {
        UsersResponseDto user = usersService.saveUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersResponseDto> getUser(@PathVariable Long id) {
        return usersService.getUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersResponseDto> updateUser(
            @PathVariable Long id,
            @RequestBody UsersSaveDto userDto) {

        if (usersService.doesExist(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userDto.setId(id);
        UsersResponseDto user = usersService.saveUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
