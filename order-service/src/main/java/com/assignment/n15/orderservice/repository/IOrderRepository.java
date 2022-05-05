package com.assignment.n15.orderservice.repository;

import com.assignment.n15.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order,Long> {
    List<Order> findOrderByCode(String code);
}
