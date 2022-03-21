package com.anfinogenov.jwtappdemo.repository;

import com.anfinogenov.jwtappdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Stepan Anfinogenov
 */

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String name);
}
