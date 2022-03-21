package com.anfinogenov.jwtappdemo.repository;

import com.anfinogenov.jwtappdemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Stepan Anfinogenov
 */

public interface RoleRepository extends JpaRepository<Role, Long> {
  Role findByName(String name);
}
