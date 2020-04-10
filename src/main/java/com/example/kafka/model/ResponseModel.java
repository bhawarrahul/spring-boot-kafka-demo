package com.example.kafka.model;

import lombok.Data;

@Data
public class ResponseModel {
    private String messages;
    private boolean status;
    private String statusCode;

    public ResponseModel(String messages, boolean status, String statusCode) {
        this.messages = messages;
        this.status = status;
        this.statusCode = statusCode;
    }
}
