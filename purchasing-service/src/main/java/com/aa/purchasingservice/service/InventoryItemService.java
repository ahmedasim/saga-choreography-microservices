package com.aa.inventoryservice.service;

import com.aa.commonservice.dto.inventoryservice.request.InventoryItemRequestDto;
import com.aa.commonservice.dto.inventoryservice.response.InventoryItemResponseDto;

public interface InventoryItemService {

	InventoryItemResponseDto save(InventoryItemRequestDto requestDto);

	InventoryItemResponseDto update(InventoryItemRequestDto requestDto, Long itemId);
	
	void delete(Long itemId);

	InventoryItemResponseDto findById(Long itemId);


}
