package com.abbos.hospitalmanagementsystem.service.impl;

import com.abbos.hospitalmanagementsystem.dto.InventoryItemCreateDTO;
import com.abbos.hospitalmanagementsystem.dto.InventoryItemResponseDTO;
import com.abbos.hospitalmanagementsystem.dto.InventoryItemUpdateDTO;
import com.abbos.hospitalmanagementsystem.dto.Response;
import com.abbos.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.abbos.hospitalmanagementsystem.mapper.InventoryItemMapper;
import com.abbos.hospitalmanagementsystem.repository.InventoryItemRepository;
import com.abbos.hospitalmanagementsystem.service.AbstractService;
import com.abbos.hospitalmanagementsystem.service.InventoryItemService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 14/January/2025  15:57
 **/
@Service
public class InventoryItemServiceImpl
        extends AbstractService<InventoryItemRepository, InventoryItemMapper> implements InventoryItemService {

    public InventoryItemServiceImpl(InventoryItemRepository repository, InventoryItemMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Response<List<InventoryItemResponseDTO>> findAllByName(String name) {
        return Response.ok(
                repository.findAllByName(name).stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }

    @Override
    public Response<InventoryItemResponseDTO> create(InventoryItemCreateDTO dto) {
        final var entity = mapper.fromCreate(dto);
        final var newEntity = repository.save(entity);
        return Response.ok(mapper.toDTO(newEntity));
    }

    @Override
    public Response<InventoryItemResponseDTO> update(InventoryItemUpdateDTO dto) {
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
    public Response<InventoryItemResponseDTO> find(Long id) {
        return Response.ok(
                mapper.toDTO(repository
                        .findByIdCustom(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Inventory item not found with id: {0}", id))
                ));
    }

    @Override
    public Response<List<InventoryItemResponseDTO>> findAll() {
        return Response.ok(
                repository.findAllCustom().stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }
}
