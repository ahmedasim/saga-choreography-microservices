package com.aa.inventoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aa.commonservice.dto.inventoryservice.request.InventoryItemRequestDto;
import com.aa.inventoryservice.service.InventoryItemService;

@RestController("item")
public class InventoryItemController {

	@Autowired
	InventoryItemService service;
	
	@PostMapping
	public void save(@RequestBody InventoryItemRequestDto requestDto) {
		
	}
	
	@PutMapping("{itemId}")
	public void update(@RequestBody InventoryItemRequestDto requestDto, @PathVariable Long itemId) {
		
	}
	
	@DeleteMapping("{itemId}")
	public void delete(@PathVariable Long itemId) {
		
	}
	
	@GetMapping("{itemId}")
	public void findById(@PathVariable Long itemId) {
		
	}
}
