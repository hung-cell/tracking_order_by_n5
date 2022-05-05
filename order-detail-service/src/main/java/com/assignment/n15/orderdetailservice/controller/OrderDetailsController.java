package com.assignment.n15.orderdetailservice.controller;

import com.assignment.n15.orderdetailservice.dto.OrderDetailResponse;
import com.assignment.n15.orderdetailservice.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-detail")
@RequiredArgsConstructor
@RefreshScope
public class OrderDetailsController {

    private final OrderDetailService orderDetailsService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDetailResponse> getOrderDetailByOrderNumber(@PathVariable Long id){
        return orderDetailsService.getOrderDetailByOrderNumber(id);
    }
}
