package com.assignment.n15.orderservice.service;

import com.assignment.n15.orderservice.dto.OrderResponse;
import com.assignment.n15.orderservice.model.Order;
import com.assignment.n15.orderservice.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final IOrderRepository orderRepository;

    public List<OrderResponse> getAllOrderByCode(String code){
        List<Order> orders =  orderRepository.findOrderByCode(code);
        return orders.stream().map(this::mapToOrderResponse).collect(Collectors.toList());
    }

    private OrderResponse mapToOrderResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .code(order.getCode())
                .orderLineItemsList(order.getOrderListItems())
                .build();
    }
}
