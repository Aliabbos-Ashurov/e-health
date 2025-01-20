package com.abbos.hospitalmanagementsystem.config;

import com.abbos.brainwave_matrix_intern.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Aliabbos Ashurov
 * @since 16/January/2025  10:39
 **/
public record CustomUserDetails(Long id, String username, String password, Role role) implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
