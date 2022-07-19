package com.example.mymapperdemo.controllers;

import com.example.mymapperdemo.dtos.UserDto;
import com.example.mymapperdemo.entities.User;
import com.example.mymapperdemo.mapper.UserMapperImpl;
import com.example.mymapperdemo.repositories.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {


    private final UserRepository userRepository;

    private final UserMapperImpl userMapperImpl;

    public UserController(UserRepository userRepository, UserMapperImpl userMapperImpl) {
        this.userRepository = userRepository;
        this.userMapperImpl = userMapperImpl;
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<User> users = userRepository.findAll ();
        List<UserDto> userDtos = users.stream ().map (userMapperImpl::userToUserDto).collect(Collectors.toList());
        return ResponseEntity.ok (userDtos);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<UserDto> getAllUsers(@PathVariable Long id){
        User user = userRepository.findById (id).orElseThrow (EntityNotFoundException::new);
        return ResponseEntity.ok (userMapperImpl.userToUserDto (user));
    }

    @PostMapping(value = "/user")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid @NonNull UserDto userDto){
        User user = userMapperImpl.userDtoToUser (userDto);
        return ResponseEntity.ok (userMapperImpl.userToUserDto (userRepository.save (user)));
    }
}











