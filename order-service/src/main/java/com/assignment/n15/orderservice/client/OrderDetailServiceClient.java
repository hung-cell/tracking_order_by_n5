package com.assignment.n15.orderservice.client;


import com.assignment.n15.orderservice.dto.OrderDetailResponse;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "order-detail-service")
public interface OrderDetailServiceClient {
    @GetMapping("/api/order-detail/{id}")
    List<OrderDetailResponse> getOrderDetailByOrderNumber(@PathVariable Long id);
}
