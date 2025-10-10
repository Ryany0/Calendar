package com.calendar.calendar.Services;

import com.calendar.calendar.Entities.Users;
import com.calendar.calendar.dto.UsersDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UsersService {

    Optional<Users> getUser(Long id);

    Users createUser(UsersDto userDto);
}
