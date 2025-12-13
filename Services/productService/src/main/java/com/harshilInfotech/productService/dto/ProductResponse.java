package com.harshilInfotech.productService.dto;


import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.math.BigDecimal;

@Builder
@Component
public record ProductResponse(
    Long id,
    String name,
    String description,
    Double availableQuantity,
    BigDecimal price,
    Long categoryId,
    String categoryName,
    String categoryDescription
) {
}