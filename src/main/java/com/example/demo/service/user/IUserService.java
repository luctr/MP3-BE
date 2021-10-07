package com.example.demo.service.user;

import com.example.demo.model.User;
import com.example.demo.service.Generic;

import java.util.Optional;

public interface IUserService extends Generic<User> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

}
