package com.assignment.n15.orderservice.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.assignment.n15.orderservice.model.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class MailClient {
    private static final String loginUrl = "https://team5-mail-notification.herokuapp.com/api/v1/users/login";
    private static final String sendMailUrl = "https://team5-mail-notification.herokuapp.com/api/v1/notifications/";

    private User userCon;
    private MailDTO mailDTO;

    public MailClient(User userCon, MailDTO mailDTO) {
        this.userCon = userCon;
        this.mailDTO = mailDTO;
    }

    public String sendMail() {
        ObjectMapper objectMapper = new ObjectMapper();
        AuthToken authToken = null;
        try {
            authToken = objectMapper.readValue(takeToken(), AuthToken.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return sendMail(authToken.getAuthToken());
    }

    private String takeToken() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

        String json = null;
        try {
            json = mapper.writeValueAsString(userCon);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request =
            new HttpEntity<String> (json, headers);
        String strResponse =
            restTemplate.postForObject(loginUrl, request, String.class);
        return strResponse;
    }

    private String sendMail(String token) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

        String json = null;
        try {
            json = mapper.writeValueAsString(mailDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, token);

        HttpEntity<String> request =
            new HttpEntity<String> (json, headers);
        String strResponse =
            restTemplate.postForObject(sendMailUrl, request, String.class);
        return strResponse;
    }
}
