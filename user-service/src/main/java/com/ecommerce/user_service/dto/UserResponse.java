package com.ecommerce.user_service.dto;

import java.time.LocalDateTime;

public record UserResponse(
        Integer id,
        String firstName,
        String lastName,
        String email,
        String password,
        String role,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

}