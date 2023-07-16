package com.javapavan.repo;

import com.javapavan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA Repository for user entity
 *
 * @author Pavan
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailIgnoreCase(String email);
	boolean existsByEmailIgnoreCase(String email);
}
