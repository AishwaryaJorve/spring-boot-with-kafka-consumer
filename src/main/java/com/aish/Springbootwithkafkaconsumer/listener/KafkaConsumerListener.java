package com.aish.Springbootwithkafkaconsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.aish.Springbootwithkafkaconsumer.model.User;

@Service
public class KafkaConsumerListener {

	/**
	 * To consume String message 
	 * @param message
	 */
	@KafkaListener(topics="kafka-example", groupId ="consumer_group_id")
	public void consume(String message) {
		System.out.println("consumed message: "+ message);
	}
	
	/**
	 * To consume User type JSON data 
	 * @param user
	 */
	@KafkaListener(topics="json-example", groupId ="consumer_group_id2",
			containerFactory = "userkafkaListenerContainerFactory")
	public void consumeJson(User user) {
		System.out.println("consumed json message :"+user);
	}
}
