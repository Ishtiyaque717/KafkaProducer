package com.deliveryboy.deliverybody.services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deliveryboy.deliverybody.config.AppConstants;

import ch.qos.logback.classic.Logger;

@Service
public class KafkaService {
	private Logger log= (Logger) LoggerFactory.getLogger(KafkaService.class);
	@Autowired
	private KafkaTemplate<String, String> kafkatemplate;

	public boolean updateLocation(String location) {
	this.kafkatemplate.send(AppConstants.LOCATION_TOPIC_NAME,location);
	this.log.info("message Produced");	
	return true;
	}

}
