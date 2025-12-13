package com.harshilInfotech.productService.exception.dto;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}