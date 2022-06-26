package com.assignment.n15.orderservice.controller;

import com.assignment.n15.orderservice.client.OrderDetailServiceClient;
import com.assignment.n15.orderservice.dto.OrderDetailResponse;
import com.assignment.n15.orderservice.dto.OrderResponse;
import com.assignment.n15.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@RefreshScope
public class OrderController {

    private final OrderService orderservice;
    private final OrderDetailServiceClient orderDetailServiceClient;
    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse getOrdersByCode(@PathVariable String code){
        return orderservice.getOrderByCode(code);
    }



}
