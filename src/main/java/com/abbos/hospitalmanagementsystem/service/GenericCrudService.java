package com.abbos.hospitalmanagementsystem.service;

import com.abbos.brainwave_matrix_intern.dto.marker.Request;
import com.abbos.brainwave_matrix_intern.dto.marker.Response;
import com.abbos.brainwave_matrix_intern.entity.BaseDomain;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  13:07
 **/
public interface GenericCrudService<
        ID extends Serializable,
        E extends BaseDomain,
        R extends Response,
        CR extends Request,
        UP extends Request>
        extends GenericQueryService<ID, E, R> {

    com.abbos.brainwave_matrix_intern.dto.Response<R> create(@NotNull CR dto);

    com.abbos.brainwave_matrix_intern.dto.Response<R> update(@NotNull UP dto);

    com.abbos.brainwave_matrix_intern.dto.Response<Boolean> delete(@NotNull ID id);
}
