package com.rabbitMq;

import com.rabbitMq.model.User;
import com.rabbitMq.producer.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class RabbitMqScheduledTasks {
	private static final Logger Log = LoggerFactory.getLogger(RabbitMqScheduledTasks.class);

    @Autowired
    private ProducerService producerService;

	@Scheduled(fixedRate=2000)
	public void reportCurrentTimeByfixedRate(){
        // producerService.producer("肖晓翔1");
        User user = new User();
        user.setUserName("肖晓翔");
        user.setPassWord("123456");
        producerService.producer2(user);
	}
}
