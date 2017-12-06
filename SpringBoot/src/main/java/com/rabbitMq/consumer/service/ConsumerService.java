package com.rabbitMq.consumer.service;

import com.rabbitMq.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ConsumerService {

    /*@RabbitListener(queues="queue")  //监听器监听指定的Queue
	public void processC(String str){
		System.out.println("Receive:"+str);
	}*/

    @RabbitListener(queues="queue")  //监听器监听指定的Queue
    public void processC(User user){
        try {
            SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("Receive1:"+user.toString() + ",time:" + simpleDateFormat.format(new Date()));
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
