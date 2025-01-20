package com.abbos.hospitalmanagementsystem.service;

import com.abbos.brainwave_matrix_intern.dto.Response;
import com.abbos.brainwave_matrix_intern.dto.UserCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.UserResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.UserUpdateDTO;
import com.abbos.brainwave_matrix_intern.entity.User;
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
