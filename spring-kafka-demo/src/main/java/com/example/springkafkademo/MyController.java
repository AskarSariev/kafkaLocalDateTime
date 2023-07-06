package com.example.springkafkademo;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public MyController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/")
    public void write(@RequestBody Message message) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Bytes bytes = new Bytes(objectMapper.writeValueAsBytes(user));
        kafkaTemplate.send("topic", message);
    }
}
