package com.abbos.hospitalmanagementsystem.service;

import com.abbos.hospitalmanagementsystem.dto.Response;
import com.abbos.hospitalmanagementsystem.dto.marker.Request;
import com.abbos.hospitalmanagementsystem.entity.BaseDomain;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  13:07
 **/
public interface GenericCrudService<
        ID extends Serializable,
        E extends BaseDomain,
        R extends com.abbos.hospitalmanagementsystem.dto.marker.Response,
        CR extends Request,
        UP extends Request>
        extends GenericQueryService<ID, E, R> {

    Response<R> create(@NotNull CR dto);

    Response<R> update(@NotNull UP dto);

    Response<Boolean> delete(@NotNull ID id);
}
