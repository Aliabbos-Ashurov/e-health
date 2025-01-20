package com.abbos.hospitalmanagementsystem.mapper;

import com.abbos.hospitalmanagementsystem.config.CustomUserDetails;
import com.abbos.hospitalmanagementsystem.dto.UserCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.UserResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.UserUpdateDTO;
import com.abbos.hospitalmanagementsystem.entity.User;
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
