package com.abbos.hospitalmanagementsystem.mapper;

import com.abbos.brainwave_matrix_intern.config.CustomUserDetails;
import com.abbos.brainwave_matrix_intern.dto.UserCreateDTO;
import com.abbos.brainwave_matrix_intern.dto.UserResponseDTO;
import com.abbos.brainwave_matrix_intern.dto.UserUpdateDTO;
import com.abbos.brainwave_matrix_intern.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  12:56
 **/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper
        extends GenericMapper<User, UserResponseDTO, UserCreateDTO, UserUpdateDTO> {

    CustomUserDetails toCustomUserDetails(User user);
}
