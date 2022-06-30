package com.assignment.n15.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TelegramMessageDTO {
    private static String DEFAULT_BOT_TOKEN = "-7715776415581927865:AAHk_wiJDgi0RJ5YMkaFFr-cbRl4PnVcJOI";
    private static String DEFAULT_CHAT_ID = "-771577641";

    @JsonProperty("bot_token")
    private String botToken;

    @JsonProperty("message")
    private String message;

    @JsonProperty("chat_id")
    private String chatId;

    public TelegramMessageDTO(String botToken, String message, String chatId) {
        this.botToken = botToken;
        this.message = message;
        this.chatId = chatId;
    }

    public TelegramMessageDTO(String message) {
        this.botToken = DEFAULT_BOT_TOKEN;
        this.chatId = DEFAULT_CHAT_ID;
        this.message = message;
    }

    public String getChatId() {
        return chatId;
    }

    public String getMessage() {
        return message;
    }

    public String getBotToken() {
        return botToken;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }
}
