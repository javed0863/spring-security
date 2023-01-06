package com.javedrpi.springsecurityjwt.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Javed Ameen Shaikh
 * @website https://www.javedrpi.com
 */

@Repository
public class UserDao {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final static List<UserDetails> APP_USERS = Arrays.asList(
            new User("john@gmail.com", "pass", Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))),
            new User("jane@gmail.com", "pass", Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")))
    );

    public UserDetails findUserByEmail(String username) throws UsernameNotFoundException {
        return APP_USERS.parallelStream()
                .filter(u -> u.getUsername().equals(username))
                .map(u -> new User(u.getUsername(), passwordEncoder.encode(u.getPassword()), u.getAuthorities()))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
