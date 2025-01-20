package com.abbos.hospitalmanagementsystem.mapper;

import com.abbos.hospitalmanagementsystem.dto.marker.Request;
import com.abbos.hospitalmanagementsystem.dto.marker.Response;
import com.abbos.hospitalmanagementsystem.entity.BaseDomain;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  12:54
 **/
public interface GenericMapper<
        E extends BaseDomain,
        R extends Response,
        CR extends Request,
        UP extends Request
        > extends Mapper {
    R toDTO(E entity);

    E toEntity(R dto);

    E fromCreate(CR dto);

    E fromUpdate(UP dto);
}
