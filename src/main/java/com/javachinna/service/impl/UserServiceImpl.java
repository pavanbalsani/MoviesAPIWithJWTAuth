package com.javapavan.service.impl;

import com.javapavan.dto.SignUpRequest;
import com.javapavan.exception.UserAlreadyExistAuthenticationException;
import com.javapavan.model.Role;
import com.javapavan.model.User;
import com.javapavan.repo.RoleRepository;
import com.javapavan.repo.UserRepository;
import com.javapavan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Pavan
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public User findUserByEmail(final String email) {
		return userRepository.findByEmailIgnoreCase(email);
	}

	@Override
	@Transactional(value = "transactionManager")
	public User registerNewUser(final SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException {
		if (userRepository.existsByEmailIgnoreCase(signUpRequest.getEmail())) {
			throw new UserAlreadyExistAuthenticationException("User with email id " + signUpRequest.getEmail() + " already exist");
		}
		User user = buildUser(signUpRequest);
		user = userRepository.save(user);
		userRepository.flush();
		return user;
	}

	private User buildUser(final SignUpRequest signUpRequest) {
		User user = new User();
		user.setDisplayName(signUpRequest.getDisplayName());
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		user.addRole(roleRepository.findByName(Role.ROLE_USER));
		user.setEnabled(true);
		return user;
	}
}
