package com.aa.purchasingservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShipmentFinalizedEventResponseConsumerConfig {
	 
	
	@Bean
    public void shipmentFinalizedResponse(){
        System.out.print("shipmentFinalizedResponse");
    }
}
