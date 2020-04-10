package com.example.kafka.controller;

import com.example.kafka.model.Message;
import com.example.kafka.model.ResponseModel;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class KafkaMessageProducerController {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topic;

    @PostMapping()
    public ResponseModel produceMessages(@RequestBody Message message) {
        kafkaTemplate.send(new ProducerRecord<>(topic, message));
        return new ResponseModel("Messages Send Successfully!", true, "200");
    }


}
