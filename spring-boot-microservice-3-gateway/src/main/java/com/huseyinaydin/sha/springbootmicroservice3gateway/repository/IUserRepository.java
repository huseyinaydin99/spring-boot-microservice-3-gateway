package com.huseyinaydin.sha.springbootmicroservice3gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huseyinaydin.sha.springbootmicroservice3gateway.model.User;

import java.util.Optional;

/**
 * @author Hüseyin Aydın
 * @date 18.04.2021
 * @time 12:08
 */
public interface IUserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByUsername(String username);
}
