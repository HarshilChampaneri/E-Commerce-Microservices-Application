package com.harshilInfotech.orderService.repository;

import com.harshilInfotech.orderService.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}