package com.aa.purchasingservice.service;

import com.aa.purchasingservice.dto.request.ShipmentRequestDto;
import com.aa.purchasingservice.dto.response.ShipmentResponseDto;

public interface ShipmentService {

	ShipmentResponseDto save(ShipmentRequestDto requestDto);

	ShipmentResponseDto update(ShipmentRequestDto requestDto, Long itemId);
	
	void delete(Long itemId);

	ShipmentResponseDto findById(Long itemId);


}
