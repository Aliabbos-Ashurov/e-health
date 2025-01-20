package com.abbos.hospitalmanagementsystem.service;

import com.abbos.brainwave_matrix_intern.dto.marker.Response;
import com.abbos.brainwave_matrix_intern.entity.BaseDomain;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  13:07
 **/
public interface GenericQueryService<
        ID extends Serializable,
        E extends BaseDomain,
        R extends Response>
        extends GenericService {

    com.abbos.brainwave_matrix_intern.dto.Response<R> find(@NotNull ID id);

    com.abbos.brainwave_matrix_intern.dto.Response<List<R>> findAll();
}
