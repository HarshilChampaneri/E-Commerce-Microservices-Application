package com.harshilInfotech.orderService.service;

import com.harshilInfotech.orderService.dto.OrderLineRequest;
import com.harshilInfotech.orderService.mapper.OrderLineMapper;
import com.harshilInfotech.orderService.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;

    @Override
    public Long saveOrderLine(OrderLineRequest orderLineRequest) {

        var order = orderLineMapper.toOrderLine(orderLineRequest)

    }
}