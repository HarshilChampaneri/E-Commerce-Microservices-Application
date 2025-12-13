package com.harshilInfotech.productService.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Builder
@Component
public record ProductRequest(
    Long id,

    @NotNull(message = "Product name is required")
    String name,

    @NotNull(message = "Product description is required")
    String description,

    @Positive(message = "Available Product quantity should be positive")
    Double availableQuantity,

    @Positive(message = "Price should be positive")
    BigDecimal price,

    @Positive(message = "Product category is required")
    Long categoryId
) {
}