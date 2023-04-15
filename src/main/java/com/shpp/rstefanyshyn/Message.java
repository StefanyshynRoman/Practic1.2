package com.shpp.rstefanyshyn;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    @JsonProperty(value = "message")
    private String message;
    public Message(String message) {
        this.message = message;
    }
}
