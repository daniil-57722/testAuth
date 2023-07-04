package com.example.testAuth.controller;

import com.example.testAuth.UserRepo;
import com.example.testAuth.dto.UserDto;
import com.example.testAuth.entity.User;
import com.example.testAuth.sercvice.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

    @PostMapping("/user/add")
    public ResponseEntity addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto.getFirstname(), userDto.getLogin(), userDto.getPass());
    }
    @PostMapping("/user/auth")
    public ResponseEntity authorization(@RequestParam UserDto userDto){
        System.out.println(userDto.getLogin());
        return ResponseEntity.ok(userService.loadUserByUsername(userDto.getLogin()));
    }
    @GetMapping("/user/auth")
    public ResponseEntity authWithInterceptor(@RequestParam String login, @RequestParam String password){
//        return ResponseEntity.ok(userService.loadUserByUsername(login));
        userService.loadUserByUsername(login);
        return ResponseEntity.ok("Авторизация");
    }
    @GetMapping("/user/get/{id}")
    public ResponseEntity getUser(@PathVariable long id){
        return ResponseEntity.ok(userRepo.findById(id));
    }
}
