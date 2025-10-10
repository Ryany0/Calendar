package com.calendar.calendar;

import com.calendar.calendar.Entities.Users;
import com.calendar.calendar.dto.UsersCreateDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toEntity(UsersCreateDto usersCreateDto);

    UsersCreateDto toDTO(Users user);
}
