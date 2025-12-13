package com.harshilinfotech.customerservice.util;

import com.harshilinfotech.customerservice.dto.CustomerRequest;
import com.harshilinfotech.customerservice.dto.CustomerResponse;
import com.harshilinfotech.customerservice.entity.Customer;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request) {

        if (request == null) return Customer.builder().build();

        return Customer.builder()
                .id(request.id())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .address(request.address())
                .build();

    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}