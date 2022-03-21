package com.anfinogenov.jwtappdemo.service.impl;

import com.anfinogenov.jwtappdemo.model.Role;
import com.anfinogenov.jwtappdemo.model.Status;
import com.anfinogenov.jwtappdemo.model.User;
import com.anfinogenov.jwtappdemo.repository.RoleRepository;
import com.anfinogenov.jwtappdemo.repository.UserRepository;
import com.anfinogenov.jwtappdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stepan Anfinogenov
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User register(User user) {
    Role roleUser = roleRepository.findByName("ROLE_USER");
    List<Role> userRoles = new ArrayList<>();
    userRoles.add(roleUser);

    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setRoles(userRoles);
    user.setStatus(Status.ACTIVE);

    User registeredUser = userRepository.save(user);

    log.info("IN registered - user: {} successfully registered", registeredUser);

    return registeredUser;
  }

  @Override
  public List<User> getAll() {
    List<User> result = userRepository.findAll();

    log.info("IN getAll - {} users found", result.size());

    return null;
  }

  @Override
  public User findByUsername(String username) {
    User result = userRepository.findByUsername(username);

    log.info("IN findByUsername - user: {} found by username:{}", result, username);

    return result;
  }

  @Override
  public User findById(Long id) {
    User result = userRepository.findById(id).orElse(null);

    if (result == null) {
      log.info("IN findById - no user by id: {}", id);
      return null;
    }

    log.info("IN findById - user: {} found by id:{}", result, id);

    return result;
  }

  @Override
  public void delete(Long id) {
    userRepository.deleteById(id);

    log.info("IN delete - user with id: {} was deleted", id);
  }
}
