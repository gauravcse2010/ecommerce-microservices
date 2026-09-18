package com.ecommerce.product_service.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest (
    @NotBlank(message = "Product name is required")
    String name,

    @NotBlank(message = "Product description is required")
    String description,

    @NotNull(message = "Category ID is required")
    @Positive(message = "Category ID must be greater than 0")
    Long categoryId,

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    Double price,

    @NotBlank(message = "SKU is required")
    String sku,

    @NotBlank(message = "Status is required")
    String status
){

}
