package com.assignment.n15.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductItems {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
