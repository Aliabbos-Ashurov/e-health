package com.abbos.hospitalmanagementsystem.service.impl;

import com.abbos.hospitalmanagementsystem.dto.InventoryTransactionCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.InventoryTransactionResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.InventoryTransactionUpdateDTO;
import com.abbos.hospitalmanagementsystem.dto.Response;
import com.abbos.hospitalmanagementsystem.enums.TransactionType;
import com.abbos.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.abbos.hospitalmanagementsystem.mapper.InventoryTransactionMapper;
import com.abbos.hospitalmanagementsystem.repository.InventoryTransactionRepository;
import com.abbos.hospitalmanagementsystem.service.AbstractService;
import com.abbos.hospitalmanagementsystem.service.InventoryTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  15:53
 **/
@Service
public class InventoryTransactionServiceImpl
        extends AbstractService<InventoryTransactionRepository, InventoryTransactionMapper> implements InventoryTransactionService {

    public InventoryTransactionServiceImpl(InventoryTransactionRepository repository, InventoryTransactionMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Response<List<InventoryTransactionResponseDTO>> findAllByTransactionType(TransactionType transactionType) {
        return Response.ok(
                repository.findAllByTransactionType(transactionType).stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }

    @Override
    public Response<InventoryTransactionResponseDTO> create(InventoryTransactionCreateDTO dto) {
        final var entity = mapper.fromCreate(dto);
        final var newEntity = repository.save(entity);
        return Response.ok(mapper.toDTO(newEntity));
    }

    @Override
    public Response<InventoryTransactionResponseDTO> update(InventoryTransactionUpdateDTO dto) {
        final var entity = mapper.fromUpdate(dto);
        final var newEntity = repository.save(entity);
        return Response.ok(mapper.toDTO(newEntity));
    }

    @Override
    public Response<Boolean> delete(Long id) {
        repository.softDelete(id);
        return Response.ok(true);
    }

    @Override
    public Response<InventoryTransactionResponseDTO> find(Long id) {
        return Response.ok(
                mapper.toDTO(repository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Inventory transaction with id {0} not found", id)))
        );
    }

    @Override
    public Response<List<InventoryTransactionResponseDTO>> findAll() {
        return Response.ok(
                repository.findAllCustom().stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }
}
