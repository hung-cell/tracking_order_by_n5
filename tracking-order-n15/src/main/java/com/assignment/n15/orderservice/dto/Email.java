package com.assignment.n15.orderservice.dto;

public class Email {
    private int id;
    private String recipient;
    private String subject;
    private String content;

    public Email() {
    }

    public Email(int id, String recipient, String subject, String content) {
        this.id = id;
        this.recipient = recipient;
        this.subject = subject;
        this.content = content;
    }

    public Email(String recipient, String subject, String content) {
        this.recipient = recipient;
        this.subject = subject;
        this.content = content;
    }
}
