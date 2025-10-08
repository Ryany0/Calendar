package com.calendar.calendar;

import com.calendar.calendar.Entities.Users;
import com.calendar.calendar.dto.UsersDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toEntity(UsersDto usersDto);

    UsersDto toDTO(Users user);
}
