package com.abbos.hospitalmanagementsystem.config;

import com.abbos.hospitalmanagementsystem.mapper.UserMapper;
import com.abbos.hospitalmanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Aliabbos Ashurov
 * @since 16/January/2025  10:34
 **/
@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.toCustomUserDetails(userService.findByUsername(username));
    }
}
