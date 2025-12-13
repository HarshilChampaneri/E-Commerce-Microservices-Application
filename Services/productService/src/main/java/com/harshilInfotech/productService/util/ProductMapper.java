package com.harshilInfotech.productService.util;

import com.harshilInfotech.productService.dto.ProductPurchaseResponse;
import com.harshilInfotech.productService.dto.ProductRequest;
import com.harshilInfotech.productService.dto.ProductResponse;
import com.harshilInfotech.productService.entity.Category;
import com.harshilInfotech.productService.entity.Product;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
public class ProductMapper {

    public Product toProduct(ProductRequest productRequest) {

        return Product.builder()
                .id(productRequest.id())
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .availableQuantity(productRequest.availableQuantity())
                .category(
                        Category.builder()
                                .id(productRequest.categoryId())
                                .build()
                )
                .build();

    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product, Double quantity) {

        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );

    }
}