package com.ecommerce.user_service.mapper;

import com.ecommerce.user_service.dto.UserRequest;
import com.ecommerce.user_service.dto.UserResponse;
import com.ecommerce.user_service.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequest request) {
        User user = new User();

        if (request.firstName() != null && !request.firstName().isEmpty()) {
            user.setFirstName(request.firstName());
        }
        if (request.lastName() != null && !request.lastName().isEmpty()) {
            user.setLastName(request.lastName());
        }
        if (request.email() != null && !request.email().isEmpty()) {
            user.setEmail(request.email());
        }
        if (request.password() != null && !request.password().isEmpty()) {
            user.setPassword(request.password());
        }
        if (request.role() != null && !request.role().isEmpty()) {
            user.setRole(request.role());
        }
        if (request.status() != null && !request.status().isEmpty()) {
            user.setStatus(request.status());
        }

        return user;
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getStatus(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
