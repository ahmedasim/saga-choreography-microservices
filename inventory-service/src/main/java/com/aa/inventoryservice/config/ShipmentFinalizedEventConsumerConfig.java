package com.aa.inventoryservice.config;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aa.inventoryservice.dto.enums.ShipmentStatus;
import com.aa.inventoryservice.dto.event.ShipmentFinalizedEventDto;
import com.aa.inventoryservice.dto.event.ShipmentFinalizedEventResponseDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
public class ShipmentFinalizedEventConsumerConfig {
	 
	@Bean
	public Function<Flux<ShipmentFinalizedEventDto>, Flux<ShipmentFinalizedEventResponseDto>> shipmentProcessor() {
		System.out.println("shipmentProcessor");
		return orderEventFlux -> orderEventFlux.flatMap(this::processShipment);
	}
	
	private Mono<ShipmentFinalizedEventResponseDto> processShipment(ShipmentFinalizedEventDto eventDto) {
		System.out.println("processShipment");
		return Mono.fromSupplier(() -> new ShipmentFinalizedEventResponseDto(eventDto.getEventDto(), ShipmentStatus.FINALIZED, ""));
    }
}
