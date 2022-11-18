package com.huseyinaydin.sha.springbootmicroservice3gateway.service;

import com.huseyinaydin.sha.springbootmicroservice3gateway.model.User;

/**
 * @author Hüseyin Aydın
 * @date 18.04.2021
 * @time 13:21
 */
public interface IAuthenticationService
{
    String signInAndReturnJWT(User signInRequest);
}
