package com.assignment.n15.orderservice.controller;


import com.assignment.n15.orderservice.client.MailClient;
import com.assignment.n15.orderservice.client.OrderServiceClient;
import com.assignment.n15.orderservice.dto.OrderDetailResponse;
import com.assignment.n15.orderservice.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.assignment.n15.orderservice.model.*;

import java.util.List;

@RestController
@RequestMapping("/api/task-service")
@RequiredArgsConstructor
@RefreshScope
public class TaskService {
    private final OrderServiceClient orderServiceClient;


    @GetMapping("/order/{code}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse getOrdersByCode(@PathVariable String code){
        OrderResponse orderResponse = orderServiceClient.getOrdersByCode(code);
        User user = new User("Danhkuto", "Danhkuto");
        MailDTO mailDTO = new MailDTO();
        mailDTO.setRecipient("tranhiep0308@gmail.com");
        mailDTO.setSubject("Subject");
        mailDTO.setContent("Content");

        MailClient mailClient = new MailClient(user, mailDTO);
        mailClient.sendMail();
        return orderResponse;
    }


    @GetMapping("/order/get_order_detail/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDetailResponse> getOrderDetail(@PathVariable long id) {
        return orderServiceClient.getOrderServices(id);
    }
}



