package com.abbos.hospitalmanagementsystem.service.impl;

import com.abbos.hospitalmanagementsystem.config.SessionUser;
import com.abbos.hospitalmanagementsystem.dto.*;
import com.abbos.hospitalmanagementsystem.entity.User;
import com.abbos.hospitalmanagementsystem.exception.UserNotFoundException;
import com.abbos.hospitalmanagementsystem.mapper.UserMapper;
import com.abbos.hospitalmanagementsystem.repository.UserRepository;
import com.abbos.hospitalmanagementsystem.service.AbstractService;
import com.abbos.hospitalmanagementsystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  15:16
 **/
@Service
public class UserServiceImpl
        extends AbstractService<UserRepository, UserMapper> implements UserService {

    private final SessionUser sessionUser;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, UserMapper mapper, SessionUser sessionUser, PasswordEncoder passwordEncoder) {
        super(repository, mapper);
        this.sessionUser = sessionUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Response<UserResponseDTO> findMe() {
        return find(sessionUser.getID());
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found with username: {0}", username));
    }

    @Override
    public Response<UserResponseDTO> create(UserCreateDTO dto) {
        final var user = mapper.fromCreate(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        final var newUser = repository.save(user);
        return Response.ok(mapper.toDTO(newUser));
    }

    @Override
    public Response<UserResponseDTO> update(UserUpdateDTO dto) {
        User user = repository.findByIdCustom(sessionUser.getID())
                .orElseThrow(() -> new UserNotFoundException("User not found with session id: {0}", sessionUser.getID()));
        if (passwordEncoder.matches(dto.oldPassword(), user.getPassword())) {
            user.setPassword(passwordEncoder.encode(dto.newPassword()));
            final var newUser = repository.save(user);
            return Response.ok(mapper.toDTO(newUser));
        }
        return Response.error(HttpStatus.BAD_REQUEST,
                ErrorResponse.of("400", "Password does not match", ""));
    }

    @Override
    public Response<Boolean> delete(Long id) {
        repository.softDelete(id);
        return Response.ok(true);
    }

    @Override
    public Response<UserResponseDTO> find(Long id) {
        return Response.ok(mapper.toDTO(repository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id: {0} not found", id))));
    }

    @Override
    public Response<List<UserResponseDTO>> findAll() {
        return Response.ok(repository.findAllCustom().stream()
                .map(mapper::toDTO)
                .toList());
    }
}
