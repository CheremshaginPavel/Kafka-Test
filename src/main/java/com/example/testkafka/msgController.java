package com.example.testkafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
public class msgController {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public msgController(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@PostMapping
	public void sendOrder(String msgId, String msg) {
		kafkaTemplate.send("msg", msgId, msg);
	}
}
