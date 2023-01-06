package com.javedrpi.springsecurityjwt.controller;

import com.javedrpi.springsecurityjwt.dto.AuthenticationRequest;
import com.javedrpi.springsecurityjwt.dto.TokenResponse;
import com.javedrpi.springsecurityjwt.repo.UserDao;
import com.javedrpi.springsecurityjwt.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * @author Javed Ameen Shaikh
 * @website https://www.javedrpi.com
 */

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<TokenResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        final Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        final UserDetails userDetails = userDao.findUserByEmail(authenticationRequest.getEmail());

        if(userDetails != null){
            return new ResponseEntity<>(new TokenResponse(jwtUtil.generateToken(userDetails)), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
