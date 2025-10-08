package com.calendar.calendar.Services;

import com.calendar.calendar.Entities.Users;
import com.calendar.calendar.dto.UsersDto;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {

    Users createUser(UsersDto userDto);
}
