package com.ecommerce.controller;

import com.ecommerce.dto.CheckoutRequest;
import com.ecommerce.dto.OrderDTO;
import com.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    
    private final OrderService orderService;
    
    @PostMapping("/checkout")
    public ResponseEntity<OrderDTO> checkout(@Valid @RequestBody CheckoutRequest request) {
        return ResponseEntity.ok(orderService.checkout(request));
    }
    
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getUserOrders() {
        return ResponseEntity.ok(orderService.getUserOrders());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    
    @GetMapping("/track/{orderNumber}")
    public ResponseEntity<OrderDTO> trackOrder(@PathVariable String orderNumber) {
        return ResponseEntity.ok(orderService.trackOrder(orderNumber));
    }
}
