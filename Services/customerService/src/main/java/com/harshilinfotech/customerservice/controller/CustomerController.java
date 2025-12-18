package com.harshilinfotech.customerservice.controller;

import com.harshilinfotech.customerservice.dto.CustomerRequest;
import com.harshilinfotech.customerservice.dto.CustomerResponse;
import com.harshilinfotech.customerservice.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request
    ) {
        return new ResponseEntity<>(customerService.createCustomer(request), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid CustomerRequest request
    ) {
        customerService.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAllCustomers() {

        return new ResponseEntity<>(customerService.findAllCustomers(), HttpStatus.OK);

    }

    @GetMapping("/exists/{customerId}")
    public ResponseEntity<Boolean> existsById(
            @PathVariable String customerId
    ) {
        return new ResponseEntity<>(customerService.existsById(customerId), HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> findById(
            @PathVariable String customerId
    ) {
        return new ResponseEntity<>(customerService.findById(customerId), HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomerById(
            @PathVariable String customerId
    ) {

        customerService.deleteCustomerById(customerId);
        return ResponseEntity.accepted().build();

    }

}