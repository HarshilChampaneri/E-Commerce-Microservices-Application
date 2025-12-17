package com.harshilInfotech.orderService.dto;

import java.math.BigDecimal;

public record PurchaseResponse(
        Long productId,
        String name,
        String description,
        BigDecimal price,
        Double quantity
) {
}