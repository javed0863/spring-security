package com.javedrpi.springsecurityjwt.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Javed Ameen Shaikh
 * @website https://www.javedrpi.com
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AuthenticationRequest {
    private String email;
    private String password;
}
