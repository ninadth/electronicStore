package com.electronic.store.service.serviceImpl;

import com.electronic.store.dto.UserDto;
import com.electronic.store.entities.User;
import com.electronic.store.repository.UserRepository;
import com.electronic.store.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    //create user
    @Override
    public UserDto createUser(UserDto userDto) {
        User map = modelMapper.map(userDto, User.class);
        User save = userRepository.save(map);
        UserDto map1 = modelMapper.map(save, UserDto.class);
        return map1;
    }

    //update user
    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("USER ID NOT FOUND"));
//        String name = user.getName();
//        String gender = user.getGender();
//        String imageName = user.getImageName();
//        String password = user.getPassword();
//        String about = user.getAbout();
//        String email = user.getEmail();

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setGender(userDto.getGender());
        user.setPassword(userDto.getPassword());
        user.setImageName(userDto.getImageName());

        User updateUser = this.userRepository.save(user);
        UserDto map = this.modelMapper.map(updateUser, UserDto.class);
        return map;
    }

    //get single user
    @Override
    public UserDto getSingleUser(String userId) {

        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("USER ID NOT FOUND"));
        UserDto map = modelMapper.map(user, UserDto.class);

        return map;
    }

    //get all user
    @Override
    public List<UserDto> getAllUser() {
        List<User> alluser = this.userRepository.findAll();
        List<UserDto> collect = alluser.stream().map((a) -> this.modelMapper.map(a, UserDto.class)).collect(Collectors.toList());

        return collect;
    }

    //delete user
    @Override
    public void deleteUser(String userId) {

        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("USER ID NOT FOUND"));
        this.userRepository.delete(user);
    }

    @Override
    public UserDto getSingleUserByEmail(String email) {

        User user = userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("USER EMAIL NOT FOUND"));
        UserDto map = this.modelMapper.map(user, UserDto.class);
        return map;
    }

    @Override
    public List<UserDto> getSingleUserByName(String keywords) {

        List<User> users = this.userRepository.findByNameContaining(keywords);
        List<UserDto> collect = users.stream().map(a -> this.modelMapper.map(a, UserDto.class)).collect(Collectors.toList());
        return collect;
    }


}
