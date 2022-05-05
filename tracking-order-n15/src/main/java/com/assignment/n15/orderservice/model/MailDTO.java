package com.assignment.n15.orderservice.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("mail")
public class MailDTO {
    private String recipient;
    private String subject;
    private String content;

    public String getContent() {
        return content;
    }

    public String getSubject() {
        return subject;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
