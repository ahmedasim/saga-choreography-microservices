package com.aa.purchasingservice.service.impl;

import java.util.Optional;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.purchasingservice.dto.request.ShipmentRequestDto;
import com.aa.purchasingservice.dto.response.ShipmentResponseDto;
import com.aa.purchasingservice.entity.ShipmentEntity;
import com.aa.purchasingservice.repo.ShipmentRepo;
import com.aa.purchasingservice.service.ShipmentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	ShipmentRepo repo;
	@Autowired
	ObjectMapper objectMapper = new ObjectMapper();

	
	@Override
	public ShipmentResponseDto save(ShipmentRequestDto requestDto) {
		ShipmentEntity entity = objectMapper.convertValue(requestDto, ShipmentEntity.class);
		repo.save(entity);
		return objectMapper.convertValue(entity, ShipmentResponseDto.class);
	}

	@Override
	public ShipmentResponseDto update(ShipmentRequestDto requestDto, Long itemId) {
		return null;
	}

	@Override
	public void delete(Long itemId) {
		Optional<ShipmentEntity> opt = repo.findById(itemId);
		if(opt.isPresent()) {
			repo.delete(opt.get());
		}else {
			throw new ResourceNotFoundException("Resounce Not Found");
		}
	}

	@Override
	public ShipmentResponseDto findById(Long itemId) {
		Optional<ShipmentEntity> opt = repo.findById(itemId);
		if(opt.isPresent()) {
			return objectMapper.convertValue(opt.get(), ShipmentResponseDto.class);
		}else {
			throw new ResourceNotFoundException("Resounce Not Found");
		}
	}

}
