package com.aa.inventoryservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.inventoryservice.dto.request.InventoryItemRequestDto;
import com.aa.inventoryservice.dto.response.InventoryItemResponseDto;
import com.aa.inventoryservice.entity.InventoryItemEntity;
import com.aa.inventoryservice.repo.InventoryItemRepo;
import com.aa.inventoryservice.service.InventoryItemService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class InventoryItemServiceImpl implements InventoryItemService {

	@Autowired
	InventoryItemRepo repo;
	@Autowired
	ObjectMapper objectMapper = new ObjectMapper();

	
	@Override
	public InventoryItemResponseDto save(InventoryItemRequestDto requestDto) {
		if(requestDto.getItemId() != null && requestDto.getItemId() > 0) {
			return update(requestDto, requestDto.getItemId());
		}else{
			InventoryItemEntity entity = objectMapper.convertValue(requestDto, InventoryItemEntity.class);
			repo.save(entity);
			return objectMapper.convertValue(entity, InventoryItemResponseDto.class);
		}
	}

	@Override
	public InventoryItemResponseDto update(InventoryItemRequestDto requestDto, Long itemId) {
		InventoryItemEntity entity = findById(itemId);
		entity = objectMapper.convertValue(requestDto, InventoryItemEntity.class);
		entity.setItemId(itemId);
		repo.save(entity);
		return objectMapper.convertValue(entity, InventoryItemResponseDto.class);
	}

	@Override
	public void delete(Long itemId) {
		Optional<InventoryItemEntity> opt = repo.findById(itemId);
		if(opt.isPresent()) {
			repo.delete(opt.get());
		}else {
			throw new ResourceNotFoundException("Resounce Not Found");
		}
	}

	@Override
	public InventoryItemResponseDto findResponseDtoById(Long itemId) {
		InventoryItemEntity e = repo.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found!"));
		return objectMapper.convertValue(e, InventoryItemResponseDto.class);
	}
	
	@Override
	public InventoryItemEntity findById(Long itemId) {
		return repo.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found!"));
	}

	@Override
	public List<InventoryItemResponseDto> findAll() {
		return repo.findAll().stream().map(e -> objectMapper.convertValue(e, InventoryItemResponseDto.class)).toList();
	}

}
