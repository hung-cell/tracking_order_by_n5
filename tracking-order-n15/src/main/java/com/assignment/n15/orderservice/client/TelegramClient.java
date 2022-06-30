package com.assignment.n15.orderservice.client;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.assignment.n15.orderservice.dto.TelegramMessageDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class TelegramClient {
    private static final String TELEGRAM_URL = "https://simple-soa-telegram-bot.herokuapp.com/telegram-bot/api";

    public TelegramClient() {
    }

    public boolean sendMessage(TelegramMessageDTO messageDTO) {
        ObjectMapper mapper = new ObjectMapper();

        String json = null;
        try {
            json = mapper.writeValueAsString(messageDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<String> (json, headers);
        ResponseEntity<String> response =
            template.exchange(TELEGRAM_URL, HttpMethod.POST, request, String.class);

        if (response.getStatusCode() == HttpStatus.OK)
            return true;
        else
            return false;
    }

    public void sendAsyncMessage(TelegramMessageDTO messageDTO) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(
            () -> {
                ObjectMapper mapper = new ObjectMapper();

                String json = null;
                try {
                    json = mapper.writeValueAsString(messageDTO);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                RestTemplate template = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);

                HttpEntity<String> request = new HttpEntity<String> (json, headers);
                ResponseEntity<String> response =
                    template.exchange(TELEGRAM_URL, HttpMethod.POST, request, String.class);

            }
        );
    }

}
