package com.aa.purchasingservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aa.purchasingservice.dto.common.ApiError;
import com.aa.purchasingservice.dto.common.ApiResponse;
import com.aa.purchasingservice.dto.request.ShipmentRequestDto;
import com.aa.purchasingservice.dto.response.ShipmentResponseDto;
import com.aa.purchasingservice.service.ShipmentService;

@RestController
@RequestMapping("/api/v1/shipment")
public class ShipmentController {

	@Autowired
	ShipmentService service;
	
	@PostMapping
	public ApiResponse<ShipmentResponseDto> save(@RequestBody ShipmentRequestDto requestDto) {
		ApiResponse<ShipmentResponseDto> apiResponse = new ApiResponse<>();
		try {
			ShipmentResponseDto responseDto = service.save(requestDto);
			apiResponse.setSuccess(true);
			apiResponse.setResponse(responseDto);
			apiResponse.setMessage("Entity saved successfully");
			return apiResponse;
		}catch(Exception e) {
			List<ApiError> errors = new ArrayList<ApiError>();
			errors.add(new ApiError("", e.getMessage()));
			apiResponse.setApiErrors(errors );
		}
		return apiResponse;
	}
	
	@PutMapping("{shipmentId}")
	public ApiResponse<ShipmentResponseDto> update(@RequestBody ShipmentRequestDto requestDto, @PathVariable Long shipmentId) {
		ApiResponse<ShipmentResponseDto> apiResponse = new ApiResponse<>();
		try {
			ShipmentResponseDto responseDto = service.update(requestDto, shipmentId);
			apiResponse.setSuccess(true);
			apiResponse.setResponse(responseDto);
			apiResponse.setMessage("Entity updated successfully");
			return apiResponse;
		}catch(Exception e) {
			List<ApiError> errors = new ArrayList<ApiError>();
			errors.add(new ApiError("", e.getMessage()));
			apiResponse.setApiErrors(errors );
		}
		return apiResponse;
	}
	
	@DeleteMapping("{shipmentId}")
	public ApiResponse<ShipmentResponseDto> delete(@PathVariable Long shipmentId) {
		ApiResponse<ShipmentResponseDto> apiResponse = new ApiResponse<>();
		try {
			service.delete(shipmentId);
			apiResponse.setSuccess(true);
			apiResponse.setMessage("Entity deleted successfully");
			return apiResponse;
		}catch(Exception e) {
			List<ApiError> errors = new ArrayList<ApiError>();
			errors.add(new ApiError("", e.getMessage()));
			apiResponse.setApiErrors(errors );
		}
		return apiResponse;
	}
	
	@GetMapping("{shipmentId}")
	public ApiResponse<ShipmentResponseDto> findById(@PathVariable Long shipmentId) {
		ApiResponse<ShipmentResponseDto> apiResponse = new ApiResponse<>();
		try {
			ShipmentResponseDto responseDto = service.findResponseDtoById(shipmentId);
			apiResponse.setSuccess(true);
			apiResponse.setResponse(responseDto);
			apiResponse.setMessage("Entity fetched successfully");
			return apiResponse;
		}catch(Exception e) {
			List<ApiError> errors = new ArrayList<ApiError>();
			errors.add(new ApiError("", e.getMessage()));
			apiResponse.setApiErrors(errors );
		}
		return apiResponse;
	}
	
	@GetMapping
	public ApiResponse<List<ShipmentResponseDto>> findAll() {
		ApiResponse<List<ShipmentResponseDto>> apiResponse = new ApiResponse<>();
		try {
			List<ShipmentResponseDto> responseList = service.findAll();
			apiResponse.setSuccess(true);
			apiResponse.setResponse(responseList);
			apiResponse.setMessage("Entities fetched successfully");
			return apiResponse;
		}catch(Exception e) {
			List<ApiError> errors = new ArrayList<ApiError>();
			errors.add(new ApiError("", e.getMessage()));
			apiResponse.setApiErrors(errors );
		}
		return apiResponse;
	}
}
