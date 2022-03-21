package com.anfinogenov.jwtappdemo.security.jwt;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Stepan Anfinogenov
 */

public class JwtAuthenticationException extends AuthenticationException {
  public JwtAuthenticationException(String msg, Throwable t) {
    super(msg, t);
  }

  public JwtAuthenticationException(String msg) {
    super(msg);
  }
}
