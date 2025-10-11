package com.calendar.calendar.mappers;

import com.calendar.calendar.Entities.Users;
import com.calendar.calendar.dto.UsersSaveDto;
import com.calendar.calendar.dto.UsersResponseDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    Users userCreateDtpToEntity(UsersSaveDto usersSaveDto);

    UsersResponseDto userEntityToResponseDto(Users user);
}
