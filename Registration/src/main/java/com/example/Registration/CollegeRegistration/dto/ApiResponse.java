package com.example.Registration.CollegeRegistration.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
@Schema(description = "Standard API response wrapper")
public class ApiResponse<T>{
@Schema(description = "Response status", example = "SUCCESS")
    private final String status;
@Schema(description = "Response message", example = "student created successfully")
    private final String message;
@Schema(description = "Response payload data")
private  final  T data;

}
