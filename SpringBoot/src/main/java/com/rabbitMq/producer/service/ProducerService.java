package com.rabbitMq.producer.service;

import com.rabbitMq.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {

    /**
     * 使用AmqpTemplate发送/接收消息
     */
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void producer(String str){
        amqpTemplate.convertAndSend("queue",str);
    }

    public void producer2(User user){
        amqpTemplate.convertAndSend("queue",user);
    }
}
