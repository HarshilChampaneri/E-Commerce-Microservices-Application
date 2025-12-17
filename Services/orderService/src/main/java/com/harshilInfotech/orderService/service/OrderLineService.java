package com.harshilInfotech.orderService.service;

import com.harshilInfotech.orderService.dto.OrderLineRequest;

public interface OrderLineService {
    Long saveOrderLine(OrderLineRequest orderLineRequest);
}