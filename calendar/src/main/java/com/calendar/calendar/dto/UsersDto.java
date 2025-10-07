package com.calendar.calendar.dto;

import lombok.Builder;

@Builder
public class UsersDto {
    private Long id;
    private String email;
    private String name;
    private String password;
}
