package com.learnnew.spring.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyConsumer {
	@KafkaListener(id="msg-consumer-1" , topics ="${spring.kafka.topic}")
	public void consumer(String msg) {
		System.out.println("listening :: "+msg);
	}

}
