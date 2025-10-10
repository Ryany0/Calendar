package com.calendar.calendar.Services;

import com.calendar.calendar.Entities.Users;
import com.calendar.calendar.UserMapper;
import com.calendar.calendar.dto.UsersCreateDto;
import com.calendar.calendar.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsersServiceImpl implements UsersService{

    private final UsersRepository usersRepository;

    @Autowired
    private UserMapper userMapper;

    public UsersServiceImpl(UsersRepository usersRepository, UserMapper userMapper) {
        this.usersRepository = usersRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Users createUser(UsersCreateDto userDto) {
        return usersRepository.save(userMapper.toEntity(userDto));
    }

    @Override
    public Optional<Users> getUser(Long id) {
        return usersRepository.findById(id);
    }
}
