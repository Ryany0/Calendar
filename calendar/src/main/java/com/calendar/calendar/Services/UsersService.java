package com.calendar.calendar.Services;

import com.calendar.calendar.Entities.Users;
import com.calendar.calendar.dto.users.UsersPatchDto;
import com.calendar.calendar.dto.users.UsersSaveDto;
import com.calendar.calendar.dto.users.UsersResponseDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UsersService {

    Optional<UsersResponseDto> getUser(Long id);

    UsersResponseDto saveUser(UsersSaveDto userDto);

    Optional<Users> doesExist(Long id);

    Optional<UsersResponseDto> partialUpdate(Long id, UsersPatchDto usersDto);
}
