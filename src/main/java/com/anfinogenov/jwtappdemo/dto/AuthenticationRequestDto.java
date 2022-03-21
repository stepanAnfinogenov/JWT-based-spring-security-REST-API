package com.anfinogenov.jwtappdemo.dto;

import lombok.Data;

/**
 * @author Stepan Anfinogenov
 */

@Data
public class AuthenticationRequestDto {
  private String username;
  private String password;
}
