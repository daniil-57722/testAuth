package com.example.testAuth;

import com.example.testAuth.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User findUserByLogin(String login);
}
