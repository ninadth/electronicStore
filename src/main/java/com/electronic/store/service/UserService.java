package com.electronic.store.service;

import com.electronic.store.dto.UserDto;

import java.util.List;

public interface UserService {

    //create user
    public UserDto createUser(UserDto userDto);

    //update user
    public UserDto updateUser(UserDto userDto,String userId);

    //get single user by id
    public UserDto getSingleUser(String userId);

    //get all user
    public List<UserDto> getAllUser();

    //delete user
    public void deleteUser(String userId);

    //get single user by email
    public UserDto getSingleUserByEmail(String email);

    //get user by name
    public List<UserDto> getSingleUserByName(String keywords);

}
