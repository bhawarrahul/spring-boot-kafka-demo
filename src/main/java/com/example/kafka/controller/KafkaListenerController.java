package com.example.kafka.controller;

import com.example.kafka.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaListenerController {
    @KafkaListener(topics = "topic", groupId = "kafka-group")
    public void listen(Message message) {
        System.out.println("Received Message : " + message.toString());
    }
}
