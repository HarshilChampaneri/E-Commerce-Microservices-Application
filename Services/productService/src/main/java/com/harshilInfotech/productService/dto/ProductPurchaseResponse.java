package com.harshilInfotech.productService.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Builder
@Component
public record ProductPurchaseResponse(
    Long productId,
    String name,
    String description,
    BigDecimal price,
    Double quantity
) {
}