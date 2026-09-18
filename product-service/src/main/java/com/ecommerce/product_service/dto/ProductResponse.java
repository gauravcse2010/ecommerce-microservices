package com.ecommerce.product_service.dto;

import java.time.LocalDateTime;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        Long categoryId,
        Double price,
        String sku,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

}
