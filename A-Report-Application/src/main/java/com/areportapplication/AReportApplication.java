package com.areportapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class AReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(AReportApplication.class, args);
	}

//	Command Line runner will receive The KafkaTemplate
//	Topic==> this is to The Topic, data==> This is the message to send

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> getKafkaTemplate){
		return args -> {
			for(int i = 0; i < 10000; i++){
				getKafkaTemplate.send("mintyn-inventory-management-system", "The Total Amount Order");
			}
		};
	}

}
