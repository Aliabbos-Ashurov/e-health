package com.abbos.hospitalmanagementsystem.service.token;

import com.abbos.hospitalmanagementsystem.dto.Response;
import com.abbos.hospitalmanagementsystem.dto.auth.TokenResponseDTO;
import com.abbos.hospitalmanagementsystem.exception.TokenExpiredException;
import com.abbos.hospitalmanagementsystem.exception.UserNotFoundException;
import com.abbos.hospitalmanagementsystem.repository.UserRepository;
import com.abbos.hospitalmanagementsystem.utils.JwtTokenUtil;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

/**
 * @author Aliabbos Ashurov
 * @since 16/January/2025  11:05
 **/
@Service
@RequiredArgsConstructor
public class TokenService {

    private final UserRepository userRepository;
    private final JwtTokenUtil jwtTokenUtils;
    private final AuthenticationManager authenticationManager;

    public Response<TokenResponseDTO> generateToken(@NotNull String username, @NotNull String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        var user = userRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException("User not found: {0}", username)
        );
        var accessToken = jwtTokenUtils.generateAccessToken(user.getId(), user.getUsername(), user.getRole());
        var refreshToken = jwtTokenUtils.generateRefreshToken(user.getUsername());
        return Response.ok(TokenResponseDTO.of(user.getId(), accessToken, refreshToken));
    }

    public Response<TokenResponseDTO> refreshToken(@NotNull String refreshToken) {
        if (!jwtTokenUtils.validateToken(refreshToken))
            throw new TokenExpiredException("Token has expired or invalid: {0}", refreshToken);
        var username = jwtTokenUtils.extractUsername(refreshToken);
        var user = userRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException("User not found: {0}", username)
        );
        if (user == null)
            throw new UserNotFoundException("User not found: {0}", username);
        var newAccessToken = jwtTokenUtils.generateAccessToken(user.getId(), user.getUsername(), user.getRole());
        var newRefreshToken = jwtTokenUtils.generateRefreshToken(user.getUsername());
        return Response.ok(TokenResponseDTO.of(user.getId(), newAccessToken, newRefreshToken));
    }
}

