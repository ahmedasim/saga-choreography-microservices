package com.aa.inventoryservice.service;

import com.aa.inventoryservice.dto.request.InventoryItemRequestDto;
import com.aa.inventoryservice.dto.response.InventoryItemResponseDto;

public interface InventoryItemService {

	InventoryItemResponseDto save(InventoryItemRequestDto requestDto);

	InventoryItemResponseDto update(InventoryItemRequestDto requestDto, Long itemId);
	
	void delete(Long itemId);

	InventoryItemResponseDto findById(Long itemId);


}
