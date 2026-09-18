package com.ecommerce.user_service.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public record UserRequest(
        @NotBlank(message = "First name is required")
        String firstName,

        @NotBlank(message = "Last name is required")
        String lastName,

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "Password is required")
        String password,

        @NotNull(message = "Role is required")
        @Pattern(regexp = "(ADMIN|USER|MODERATOR)", message = "Role must be ADMIN, USER, or MODERATOR")
        String role,

        @NotNull(message = "Status is required")
        @Pattern(regexp = "(ACTIVE|INACTIVE|LOCKED)", message = "Status must be ACTIVE, INACTIVE, or LOCKED")
        String status
) {
}