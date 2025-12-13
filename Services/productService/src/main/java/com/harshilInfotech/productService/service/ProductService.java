package com.harshilInfotech.productService.service;

import com.harshilInfotech.productService.dto.ProductPurchaseRequest;
import com.harshilInfotech.productService.dto.ProductPurchaseResponse;
import com.harshilInfotech.productService.dto.ProductRequest;
import com.harshilInfotech.productService.dto.ProductResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface ProductService {
    Long createProduct(@Valid ProductRequest request);

    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> requests);

    ProductResponse findProductById(Long productId);

    List<ProductResponse> findAllProducts();

}