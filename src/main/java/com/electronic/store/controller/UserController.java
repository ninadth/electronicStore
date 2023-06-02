package com.electronic.store.controller;

import com.electronic.store.dto.UserDto;
import com.electronic.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UsersCo")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){

        UserDto user = this.userService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId") String userId){

        UserDto updateUser = this.userService.updateUser(userDto, userId);
        return new ResponseEntity<>(updateUser,HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity <List<UserDto>> getAllUser(){

        List<UserDto> allUser = this.userService.getAllUser();
        return new ResponseEntity<>(allUser,HttpStatus.OK);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable String userId){

        UserDto singleUser = this.userService.getSingleUser(userId);
        return new ResponseEntity<>(singleUser,HttpStatus.OK);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){

        this.userService.deleteUser(userId);
        return new ResponseEntity<>("delete successfully",HttpStatus.OK);
    }
    @GetMapping("/user/{email}")
    public ResponseEntity<UserDto> getSingleUserByEmail(@PathVariable String email){

        UserDto email1 = this.userService.getSingleUserByEmail(email);
        return new ResponseEntity<>(email1,HttpStatus.OK);
    }

    @GetMapping("/keywords/{keywords}")
    public ResponseEntity<List<UserDto>> getSingleUserByName(@PathVariable String keywords){

        List<UserDto> name = this.userService.getSingleUserByName(keywords);
        return new ResponseEntity<>(name,HttpStatus.OK);
    }
}
