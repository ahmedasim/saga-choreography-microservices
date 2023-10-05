package com.aa.purchasingservice.config;

import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aa.purchasingservice.dto.event.ShipmentFinalizedEventDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class ShipmentFinalizedEventPublisherConfig {

	@Bean
	public Sinks.Many<ShipmentFinalizedEventDto> shipmentSink(){
		return Sinks.many().multicast().onBackpressureBuffer();
	}
	
	@Bean
	public Supplier<Flux<ShipmentFinalizedEventDto>> shipmentSupplier(Sinks.Many<ShipmentFinalizedEventDto> sinks){
		return sinks::asFlux;
	}
}
