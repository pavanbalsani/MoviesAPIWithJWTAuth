package com.javapavan.service;

import com.javapavan.dto.SignUpRequest;
import com.javapavan.exception.UserAlreadyExistAuthenticationException;
import com.javapavan.model.User;

/**
 * Service interface for user operations
 *
 * @author Pavan
 * @since 06/11/22
 */
public interface UserService {

    User findUserByEmail(String email);

    User registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException;
}
