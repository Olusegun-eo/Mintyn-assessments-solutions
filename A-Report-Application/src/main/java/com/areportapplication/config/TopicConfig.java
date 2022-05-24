package com.areportapplication.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {
    //    This class is responsible for creating topic
    @Bean
    public NewTopic mintynTopic(){
        return TopicBuilder.name("mintyn-inventory-management-system")
                .build();

    }

}
