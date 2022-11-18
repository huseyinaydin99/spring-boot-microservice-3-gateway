package com.huseyinaydin.sha.springbootmicroservice3gateway.service;

import java.util.List;
import java.util.Optional;

import com.huseyinaydin.sha.springbootmicroservice3gateway.model.User;

/**
 * @author Hüseyin Aydın
 * @date 18.04.2021
 * @time 12:11
 */
public interface IUserService
{
    User saveUser(User user);

    Optional<User> findBUsername(String username);

    List<User> findAllUsers();
}
