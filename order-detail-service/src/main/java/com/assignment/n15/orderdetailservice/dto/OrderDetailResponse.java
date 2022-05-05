package com.assignment.n15.orderdetailservice.dto;

import com.assignment.n15.orderdetailservice.model.HistoryTracking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {
    private String status;
    private String supplierName;
    private List<HistoryTracking> listHistory;
}
