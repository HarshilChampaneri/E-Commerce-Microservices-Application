package com.harshilInfotech.orderService.service;

import com.harshilInfotech.orderService.client.CustomerClient;
import com.harshilInfotech.orderService.client.ProductClient;
import com.harshilInfotech.orderService.dto.OrderLineRequest;
import com.harshilInfotech.orderService.dto.OrderRequest;
import com.harshilInfotech.orderService.dto.PurchaseRequest;
import com.harshilInfotech.orderService.entity.OrderLine;
import com.harshilInfotech.orderService.exception.BusinessException;
import com.harshilInfotech.orderService.mapper.OrderMapper;
import com.harshilInfotech.orderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final ProductClient productClient;
    private final CustomerClient customerClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;

    @Override
    public Integer createOrder(OrderRequest request) {

        // Check the customer --> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create Order:: No Customer exists with provided Id:: " + request.customerId()));

        // Purchase the products --> Product-ms
        this.productClient.purchaseProducts(request.products());

        // Persist Order
        var order = this.orderRepository.save(orderMapper.toOrder(request));

        // Persist Order-line
        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        // Start Payment process

        // Send the order confirmation --> notification-ms (kafka)
        return 0;
    }
}