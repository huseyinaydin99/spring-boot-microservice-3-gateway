package com.huseyinaydin.sha.springbootmicroservice3gateway.security.jwt;

import org.springframework.security.core.Authentication;

import com.huseyinaydin.sha.springbootmicroservice3gateway.security.UserPrincipal;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Hüseyin Aydın
 * @date 18.04.2021
 * @time 12:48
 */
public interface IJwtProvider
{
    String generateToken(UserPrincipal authentication);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
