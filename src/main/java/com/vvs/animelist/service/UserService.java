package com.vvs.animelist.service;

import com.vvs.animelist.dto.UserDto;
import com.vvs.animelist.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
