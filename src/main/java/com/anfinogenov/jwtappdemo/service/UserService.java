package com.anfinogenov.jwtappdemo.service;

import com.anfinogenov.jwtappdemo.model.User;

import java.util.List;

/**
 * @author Stepan Anfinogenov
 */

public interface UserService {

  User register(User user);

  List<User> getAll();

  User findByUsername(String username);

  User findById(Long id);

  void delete(Long id);
}
