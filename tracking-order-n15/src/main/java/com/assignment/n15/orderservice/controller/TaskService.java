package com.assignment.n15.orderservice.controller;


import com.assignment.n15.orderservice.client.OrderServiceClient;
import com.assignment.n15.orderservice.dto.OrderDetailResponse;
import com.assignment.n15.orderservice.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task-service")
@RequiredArgsConstructor
@RefreshScope
public class TaskService {
    private final OrderServiceClient orderServiceClient;


    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getOrdersByCode(@PathVariable String code){

        List<OrderResponse> orderByCode = orderServiceClient.getOrderByCode(code);

//        // Dang nhap de lay token
//        Map<String, UserToSendInRequest> body = new HashMap<>();
//        UserToSendInRequest userToSendRequest = new UserToSendInRequest(new User("Danhkuto","Danhkuto"));
//        body.put("user", userToSendRequest);
//        AuthToken authToken = tokenService.getAuthToken(body);
//
//        // Dung token de gui mail
//        Map<String, EmailToSendInRequest> bodyEmail = new HashMap<>();
//        EmailToSendInRequest emailToSendInRequest = new EmailToSendInRequest();
//        Email email = new Email("daoquanghung922@gmail.com","Test Email","day la email content");
//        emailToSendInRequest.setEmail(email);
//        bodyEmail.put("mail",emailToSendInRequest);
//        Email emailResponse = sendEmailClientService.sendEmail(authToken.getAuth_token(),bodyEmail);


        return orderByCode;
    }
    @GetMapping("/order/get_order_detail/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDetailResponse> getOrderDetail(@PathVariable long id) {

        return orderServiceClient.getOrderServices(id);
    }
}



