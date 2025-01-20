package com.abbos.hospitalmanagementsystem.service;

import com.abbos.hospitalmanagementsystem.dto.Response;
import com.abbos.hospitalmanagementsystem.dto.UserCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.UserResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.UserUpdateDTO;
import com.abbos.hospitalmanagementsystem.entity.User;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  14:05
 **/
public interface UserService
        extends GenericCrudService<Long, User, UserResponseDTO, UserCreateDTO, UserUpdateDTO> {

    User findByUsername(@NotNull String username);

    Response<UserResponseDTO> findMe();
}
