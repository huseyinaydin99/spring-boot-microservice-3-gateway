package com.huseyinaydin.sha.springbootmicroservice3gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huseyinaydin.sha.springbootmicroservice3gateway.model.User;
import com.huseyinaydin.sha.springbootmicroservice3gateway.service.IAuthenticationService;
import com.huseyinaydin.sha.springbootmicroservice3gateway.service.IUserService;

/**
 * @author Hüseyin Aydın
 * @date 18.04.2021
 * @time 13:28
 */
@RestController
@RequestMapping("api/authentication")//pre-path
public class AuthenticationController
{
    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IUserService userService;

    @PostMapping("sign-up") //api/authentication/sign-up
    public ResponseEntity<?> signUp(@RequestBody User user)
    {
        if (userService.findBUsername(user.getUsername()).isPresent())
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("sign-in")//api/authentication/sign-in
    public ResponseEntity<?> signIn(@RequestBody User user)
    {
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }
}
