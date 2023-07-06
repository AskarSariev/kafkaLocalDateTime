package com.example.springkafkademo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyListener {

    @KafkaListener(topics = "topic", groupId = "myGroup", containerFactory = "kafkaListenerContainerFactory")
    public void getUser(User user) {
        System.out.println(user);
    }
}
