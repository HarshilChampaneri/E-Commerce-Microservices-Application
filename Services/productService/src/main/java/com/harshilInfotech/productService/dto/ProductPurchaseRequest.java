package com.harshilInfotech.productService.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Builder
@Component
public record ProductPurchaseRequest(

        @NotNull(message = "Product is Mandatory")
        Long productId,

        @NotNull(message = "Quantity is Mandatory")
        Double quantity

) {
}