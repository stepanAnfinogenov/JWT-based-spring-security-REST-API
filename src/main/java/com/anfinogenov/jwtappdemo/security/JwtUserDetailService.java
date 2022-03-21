package com.anfinogenov.jwtappdemo.security;

import com.anfinogenov.jwtappdemo.model.User;
import com.anfinogenov.jwtappdemo.security.jwt.JwtUser;
import com.anfinogenov.jwtappdemo.security.jwt.JwtUserFactory;
import com.anfinogenov.jwtappdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Stepan Anfinogenov
 */

@Service
@Slf4j
public class JwtUserDetailService implements UserDetailsService {

  private final UserService userService;

  @Autowired
  public JwtUserDetailService(UserService userService) {
    this.userService = userService;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("User with username: " + username + " njt found");
    }

    JwtUser jwtUser = JwtUserFactory.create(user);

    log.info("IN loadUserByUsername - user with username: {} successfully loaded", username);

    return jwtUser;
  }
}
