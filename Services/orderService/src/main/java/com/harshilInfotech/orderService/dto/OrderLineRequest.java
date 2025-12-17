package com.harshilInfotech.orderService.dto;

public record OrderLineRequest(
        Long id,
        Long orderId,
        Long productId,
        Double quantity

) {
}