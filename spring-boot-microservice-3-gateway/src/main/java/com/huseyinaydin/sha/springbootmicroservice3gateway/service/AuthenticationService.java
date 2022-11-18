package com.huseyinaydin.sha.springbootmicroservice3gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.huseyinaydin.sha.springbootmicroservice3gateway.model.User;
import com.huseyinaydin.sha.springbootmicroservice3gateway.security.UserPrincipal;
import com.huseyinaydin.sha.springbootmicroservice3gateway.security.jwt.IJwtProvider;

/**
 * @author Hüseyin Aydın
 * @date 18.04.2021
 * @time 13:21
 */
@Service
public class AuthenticationService implements IAuthenticationService
{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IJwtProvider jwtProvider;

    @Override
    public String signInAndReturnJWT(User signInRequest)
    {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        return jwtProvider.generateToken(userPrincipal);
    }
}
