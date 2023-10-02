package com.aa.inventoryservice.service;

import java.util.List;

import com.aa.inventoryservice.dto.request.InventoryItemRequestDto;
import com.aa.inventoryservice.dto.response.InventoryItemResponseDto;
import com.aa.inventoryservice.entity.InventoryItemEntity;

public interface InventoryItemService {

	InventoryItemResponseDto save(InventoryItemRequestDto requestDto);

	InventoryItemResponseDto update(InventoryItemRequestDto requestDto, Long itemId);
	
	void delete(Long itemId);

	InventoryItemResponseDto findResponseDtoById(Long itemId);
	
	InventoryItemEntity findById(Long itemId);

	List<InventoryItemResponseDto> findAll();

	


}
