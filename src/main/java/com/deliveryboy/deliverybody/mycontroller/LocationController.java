package com.deliveryboy.deliverybody.mycontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryboy.deliverybody.services.KafkaService;

@RestController
@RequestMapping("/location")
public class LocationController {
	@Autowired
	private KafkaService kafkaService;
	
	@PostMapping("/update")
	public ResponseEntity<?> updateLocation(){
		for(int i=0;true;i++) {
			this.kafkaService.updateLocation("( "+ Math.round(Math.random()*100)+" , "+ Math.round(Math.random()*100)+" )");				
		if(i==1000000) {
			break;
		}
		}

	return new ResponseEntity<>(Map.of("message","Location"),HttpStatus.OK);
	}
}
