package com.kafka;


import com.kafka.producer.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KafkaScheduledTasks {
	private static final Logger Log = LoggerFactory.getLogger(KafkaScheduledTasks.class);

    @Autowired
    private ProducerService producerService;

	@Scheduled(fixedRate=2000)
	public void reportCurrentTimeByfixedRate(){
        producerService.producer();
	}
}
