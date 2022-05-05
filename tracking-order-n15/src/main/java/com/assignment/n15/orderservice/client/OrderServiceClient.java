package com.assignment.n15.orderservice.client;


import com.assignment.n15.orderservice.dto.OrderDetailResponse;
import com.assignment.n15.orderservice.dto.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "order-service")
public interface OrderServiceClient {
    @GetMapping("/api/order/{code}")
    List<OrderResponse> getOrderByCode(@PathVariable String code);

    @GetMapping("/api/order/get_order_detail/{id}")
    List<OrderDetailResponse> getOrderServices(@PathVariable long id);
}
