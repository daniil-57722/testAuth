package com.example.testAuth.sercvice;

import com.example.testAuth.UserRepo;
import com.example.testAuth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findUserByLogin(username);
        System.out.println(user.getFirstname());
        System.out.println("Ты тут");
        return user;
    }

    public ResponseEntity addUser(String firstname, String login, String pass) {
        User user = new com.example.testAuth.entity.User(firstname, login, pass);
        userRepo.save(user);
        return ResponseEntity.ok("Пользователь добавлен");
    }
}
