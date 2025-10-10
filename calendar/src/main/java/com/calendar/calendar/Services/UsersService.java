package com.calendar.calendar.Services;

import com.calendar.calendar.dto.UsersCreateDto;
import com.calendar.calendar.dto.UsersResponseDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UsersService {

    Optional<UsersResponseDto> getUser(Long id);

    UsersResponseDto createUser(UsersCreateDto userDto);
}
