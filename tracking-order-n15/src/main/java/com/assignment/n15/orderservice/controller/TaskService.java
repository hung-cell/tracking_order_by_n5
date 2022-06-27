package com.assignment.n15.orderservice.controller;


import com.assignment.n15.orderservice.client.MailClient;
import com.assignment.n15.orderservice.client.OrderDetailServiceClient;
import com.assignment.n15.orderservice.client.OrderServiceClient;
import com.assignment.n15.orderservice.dto.OrderDetailResponse;
import com.assignment.n15.orderservice.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.assignment.n15.orderservice.model.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/api/task-service")
@RequiredArgsConstructor
@RefreshScope
public class TaskService {
    private final OrderServiceClient orderServiceClient;
    private final OrderDetailServiceClient orderDetailServiceClient;
    @GetMapping("/get_order_detail/{code}")
    @ResponseStatus(HttpStatus.OK)
    public SseEmitter start(@PathVariable String code){
        SseEmitter emitter = new SseEmitter();
        ExecutorService sseMvcExecutor = Executors.newSingleThreadExecutor();
        sseMvcExecutor.execute(() -> {

            try {
                List<OrderDetailResponse> orderDetailByOrderNumber = null;
                OrderResponse orderResponse = null;
                orderResponse = orderServiceClient.getOrdersByCode(code);
                Thread.sleep(1000);
                if (orderResponse == null){
                    emitter.send(false);
                }
                else{
                    emitter.send("true");
                    Thread.sleep(1000);
                    orderDetailByOrderNumber =
                            orderDetailServiceClient.getOrderDetailByOrderNumber(orderResponse.getId());
                    emitter.send("true");
                    Thread.sleep(1000);

                    emitter.send(orderDetailByOrderNumber);
                }
                emitter.complete();
            } catch (Exception ex) {
                emitter.completeWithError(ex);
            }
        });
        return emitter;
    }
}



