package com.aa.purchasingservice.service;

import java.util.List;

import com.aa.purchasingservice.dto.request.ShipmentRequestDto;
import com.aa.purchasingservice.dto.response.ShipmentResponseDto;
import com.aa.purchasingservice.entity.ShipmentEntity;

public interface ShipmentService {

	ShipmentResponseDto save(ShipmentRequestDto requestDto);

	ShipmentResponseDto update(ShipmentRequestDto requestDto, Long shipmentId);
	
	void delete(Long shipmentId);

	ShipmentResponseDto findResponseDtoById(Long shipmentId);
	
	ShipmentEntity findById(Long shipmentId);

	List<ShipmentResponseDto> findAll();

	ShipmentResponseDto finalizedShipment(ShipmentRequestDto requestDto);

}
