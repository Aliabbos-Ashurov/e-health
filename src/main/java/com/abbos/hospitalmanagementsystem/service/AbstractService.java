package com.abbos.hospitalmanagementsystem.service;

import com.abbos.hospitalmanagementsystem.mapper.Mapper;
import com.abbos.hospitalmanagementsystem.repository.Repository;
import lombok.RequiredArgsConstructor;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  13:04
 **/
@RequiredArgsConstructor
public abstract class AbstractService<R extends Repository, M extends Mapper> {
    protected final R repository;
    protected final M mapper;
}
