package com.aa.purchasingservice.service.eventservice.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.purchasingservice.dto.event.ShipmentFinalizedEventDto;
import com.aa.purchasingservice.dto.request.ShipmentRequestDto;

import reactor.core.publisher.Sinks;

@Service
public class ShipmentFinalizedEventPublisher {

	@Autowired
	private Sinks.Many<ShipmentFinalizedEventDto> sinks;
	
	public void publishEvent(ShipmentRequestDto requestDto) {
		ShipmentFinalizedEventDto eventDto = new ShipmentFinalizedEventDto(requestDto);
		sinks.tryEmitNext(eventDto);
	}
}
