package com.calendar.calendar.Services;

import com.calendar.calendar.Entities.Users;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {
    Users createUser(Users user);
}
