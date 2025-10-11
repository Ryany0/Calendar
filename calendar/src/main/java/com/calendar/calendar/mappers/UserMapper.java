package com.calendar.calendar.mappers;

import com.calendar.calendar.Entities.Users;
import com.calendar.calendar.dto.users.UsersSaveDto;
import com.calendar.calendar.dto.users.UsersResponseDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    Users userCreateDtpToEntity(UsersSaveDto usersSaveDto);

    UsersResponseDto userEntityToResponseDto(Users user);
}
