package com.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

    @KafkaListener(topics = {"test"})
    public void consumer(ConsumerRecord data){
        System.out.println("topic: " + data.topic());
        System.out.println("key: " + data.key());
        System.out.println("Receive:" + data.value().toString());
    }
}
