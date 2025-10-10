package com.calendar.calendar;

import com.calendar.calendar.Entities.Users;
import com.calendar.calendar.dto.UsersCreateDto;
import com.calendar.calendar.dto.UsersResponseDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    Users userCreateDtpToEntity(UsersCreateDto usersCreateDto);

    UsersResponseDto userEntityToResponseDto(Users user);
}
