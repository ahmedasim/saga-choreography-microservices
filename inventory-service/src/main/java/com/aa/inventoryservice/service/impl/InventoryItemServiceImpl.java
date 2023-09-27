package com.aa.inventoryservice.service.impl;

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
		InventoryItemEntity entity = objectMapper.convertValue(requestDto, InventoryItemEntity.class);
		repo.save(entity);
		return objectMapper.convertValue(entity, InventoryItemResponseDto.class);
	}

	@Override
	public InventoryItemResponseDto update(InventoryItemRequestDto requestDto, Long itemId) {
		return null;
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
	public InventoryItemResponseDto findById(Long itemId) {
		Optional<InventoryItemEntity> opt = repo.findById(itemId);
		if(opt.isPresent()) {
			return objectMapper.convertValue(opt.get(), InventoryItemResponseDto.class);
		}else {
			throw new ResourceNotFoundException("Resounce Not Found");
		}
	}

}
