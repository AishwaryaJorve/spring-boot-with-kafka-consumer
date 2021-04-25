package com.aish.Springbootwithkafkaconsumer.listener;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.aish.Springbootwithkafkaconsumer.model.User;

@Service
public class KafkaConsumerListener {

//	/**
//	 * To consume String message 
//	 * @param message
//	 */
//	@KafkaListener(topics="kafka-example", groupId ="consumer_group_id")
//	public void consume(String message) {
//		System.out.println("consumed message: "+ message);
//	}
	
	/**
	 * To consume User type JSON data 
	 * @param user
	 */
	@KafkaListener(topics="json-example", groupId ="consumer_group_id2")
	public void consumeJson(List<User> user) {
		System.out.println("consumed json message :"+user);
	}
}
