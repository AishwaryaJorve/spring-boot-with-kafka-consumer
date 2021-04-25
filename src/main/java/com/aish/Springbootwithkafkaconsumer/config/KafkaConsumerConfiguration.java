package com.aish.Springbootwithkafkaconsumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.aish.Springbootwithkafkaconsumer.model.User;


@Configuration
@EnableKafka
public class KafkaConsumerConfiguration {

	
	/**
	 * Set consumer factory for string message
	 * @return DefaultKafkaConsumerFactory<>
	 */
	@Bean
	public ConsumerFactory<String, String> consumerFactory() {

		Map<String, Object> config = new HashMap<>();

		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer_group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(config);
	}

	/**
	 * Inject consumer factory on kafka listener factory
	 * @return factory
	 */
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();

		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	/**
	 * Set consumer factory for User 
	 * @return DefaultKafkaConsumerFactory
	 */
	@Bean
	public ConsumerFactory<String, User> userConsumerFactory() {

		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer_group_id2"); 
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, User>(config, new StringDeserializer(),
				new JsonDeserializer<>(User.class));

	}
	
	/**
	 * Inject consumer factory on kafka listener factory
	 * @return
	 */
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, User> userkafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, User> factory= new ConcurrentKafkaListenerContainerFactory<String, User>();
		
		factory.setConsumerFactory(userConsumerFactory());
		return factory;
	}

}
