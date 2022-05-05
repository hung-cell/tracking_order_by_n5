package com.assignment.n15.orderdetailservice.repository;

import com.assignment.n15.orderdetailservice.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    List<OrderDetail> findOrderDetailByOrderNumber(Long orderNumber);
}
