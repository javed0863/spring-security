package com.javedrpi.springsecurityjwt.dto;

import lombok.*;

/**
 * @author Javed Ameen Shaikh
 * @website https://www.javedrpi.com
 */

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
public class TokenResponse {
    private String accessToken;
}
