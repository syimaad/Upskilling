package com.upskilling4.springboot.service;

import com.upskilling4.springboot.dto.UserDto;
import com.upskilling4.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userId);
}

