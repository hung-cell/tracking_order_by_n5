package com.assignment.n15.orderdetailservice.service;

import com.assignment.n15.orderdetailservice.dto.OrderDetailResponse;
import com.assignment.n15.orderdetailservice.model.OrderDetail;
import com.assignment.n15.orderdetailservice.repository.IOrderDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderDetailService {

    private final IOrderDetailRepository repository;

    public List<OrderDetailResponse> getOrderDetailByOrderNumber(long orderNumber){
        List<OrderDetail> listOrderDetail = repository.findOrderDetailByOrderNumber(orderNumber);
        return listOrderDetail.stream().map(this::mapToOrderDetailResponse).collect(Collectors.toList());
    }

    private OrderDetailResponse mapToOrderDetailResponse(OrderDetail orderDetail) {
        return OrderDetailResponse.builder()
                .status(orderDetail.getStatus())
                .supplierName(orderDetail.getSupplier().getName())
                .listHistory(orderDetail.getListHistory())
                .build();
    }

}
