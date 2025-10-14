package com.calendar.calendar.Services.users;

import com.calendar.calendar.Entities.Users;
import com.calendar.calendar.exception.ResourceNotFound;
import com.calendar.calendar.mappers.UserMapper;
import com.calendar.calendar.dto.users.UsersPatchDto;
import com.calendar.calendar.dto.users.UsersSaveDto;
import com.calendar.calendar.dto.users.UsersResponseDto;
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
    public UsersResponseDto saveUser(UsersSaveDto userDto) {
        Users user = usersRepository.save(userMapper.userCreateDtpToEntity(userDto));
        return userMapper.userEntityToResponseDto(user);
    }

    @Override
    public Optional<Users> doesExist(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public UsersResponseDto partialUpdate(Long id, UsersPatchDto usersDto) {
        return usersRepository.findById(id).map(
                existingUser -> {
                    if (usersDto.getName() != null) existingUser.setName(usersDto.getName());
                    if (usersDto.getEmail() != null) existingUser.setEmail(usersDto.getEmail());
                    if (usersDto.getPassword() != null) existingUser.setPassword(usersDto.getPassword());

                    Users updatedUser = usersRepository.save(existingUser);

                    return userMapper.userEntityToResponseDto(updatedUser);
                }
        ).orElseThrow(() -> new ResourceNotFound("Could not find user of id: " + id));
    }

    @Override
    public Optional<UsersResponseDto> getUser(Long id) {
        return usersRepository.findById(id)
                .map(user -> userMapper.userEntityToResponseDto(user));
    }
}
