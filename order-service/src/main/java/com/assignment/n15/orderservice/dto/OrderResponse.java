package com.assignment.n15.orderservice.dto;

import com.assignment.n15.orderservice.model.ProductItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private long id;
    private String code;
    private List<ProductItems> orderLineItemsList;
}
