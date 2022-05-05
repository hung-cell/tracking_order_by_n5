package com.assignment.n15.orderservice.model;

public class UserContainer {
    private User user;
    public UserContainer(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
