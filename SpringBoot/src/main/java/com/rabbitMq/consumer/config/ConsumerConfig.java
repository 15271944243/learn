package com.rabbitMq.consumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置消息队列,默认采用的Direct交换机模式
 * 需要在配置Queue的时候,指定一个key,也就是bindingkey,使其与交换机帮顶
 */
@Configuration
public class ConsumerConfig {

    @Bean
    public Queue queue1(){
        return new Queue("queue");
    }
}
