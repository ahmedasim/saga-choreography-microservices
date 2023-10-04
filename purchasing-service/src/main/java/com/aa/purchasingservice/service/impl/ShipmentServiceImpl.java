package com.aa.purchasingservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aa.purchasingservice.dto.enums.ShipmentStatus;
import com.aa.purchasingservice.dto.request.ShipmentRequestDto;
import com.aa.purchasingservice.dto.response.ShipmentResponseDto;
import com.aa.purchasingservice.entity.ShipmentEntity;
import com.aa.purchasingservice.entity.ShipmentItem;
import com.aa.purchasingservice.repo.ShipmentRepo;
import com.aa.purchasingservice.service.ShipmentService;
import com.aa.purchasingservice.service.eventservice.publisher.ShipmentFinalizedEventPublisher;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	ShipmentRepo repo;
	@Autowired
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	ShipmentFinalizedEventPublisher eventPublisher;
	
	public ShipmentResponseDto mapToResponse(ShipmentEntity entity) {
		ShipmentResponseDto toReturn = objectMapper.convertValue(entity, ShipmentResponseDto.class);
		toReturn.getShipmentItems().forEach(si -> si.setShipmentId(entity.getShipmentId()));
		return toReturn;
	}
	
	@Override
	public ShipmentResponseDto save(ShipmentRequestDto requestDto) {
		if(requestDto.getShipmentId() != null && requestDto.getShipmentId() > 0) {
			return update(requestDto, requestDto.getShipmentId());
		}else {
			ShipmentEntity entity = objectMapper.convertValue(requestDto, ShipmentEntity.class);
			entity.getShipmentItems().forEach(si -> si.setShipment(entity));
			repo.save(entity);
			return mapToResponse(entity);
		}
	}

	@Transactional
	@Override
	public ShipmentResponseDto update(ShipmentRequestDto requestDto, Long shipmentId) {
		ShipmentEntity entity = findById(shipmentId);
		if(entity.getStatusId().equals(ShipmentStatus.FINALIZED)) {
			throw new RuntimeException("Shipment is already finalized!");
		}else {
			entity = objectMapper.convertValue(requestDto, ShipmentEntity.class);
			entity.setShipmentId(shipmentId);
			for(ShipmentItem si : entity.getShipmentItems()) {
				si.setShipment(entity);
			}
			repo.save(entity);
			if(entity.getStatusId().equals(ShipmentStatus.FINALIZED)) {
				//TODO: produce kafka shipment finalized event 
				//eventPublisher.publishEvent(requestDto);
			}
			return mapToResponse(entity);
		}
	}

	@Override
	public void delete(Long shipmentId) {
		Optional<ShipmentEntity> opt = repo.findById(shipmentId);
		if(opt.isPresent()) {
			if(opt.get().getStatusId().equals(ShipmentStatus.FINALIZED)) {
				throw new RuntimeException("Cannot delete finalized shipment!");
			}
			repo.delete(opt.get());
		}else {
			throw new ResourceNotFoundException("Resounce Not Found");
		}
	}

	@Override
	public ShipmentResponseDto findResponseDtoById(Long shipmentId) {
		ShipmentEntity entity = repo.findById(shipmentId).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found!"));
		return mapToResponse(entity);
	}
	
	@Override
	public ShipmentEntity findById(Long shipmentId) {
		return repo.findById(shipmentId).orElseThrow(() -> new ResourceNotFoundException("Resounce Not Found!"));
	}
	
	@Override
	public List<ShipmentResponseDto> findAll(){
		return repo.findAll().stream().map(e -> mapToResponse(e)).toList();
	}

	@Override
	public ShipmentResponseDto finalizedShipment(ShipmentRequestDto requestDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
