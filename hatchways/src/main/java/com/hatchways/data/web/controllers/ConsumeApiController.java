package com.hatchways.data.web.controllers;

import com.hatchways.data.model.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api")
public class ConsumeApiController {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(ConsumeApiController.class);
    private static final String URL_PATH = "https://quoters.apps.pcfone.io/api/random";

    @Bean
    @GetMapping("/quotes")
    public CommandLineRunner run() {
        return args -> {
            Quote quote = restTemplate.getForObject(URL_PATH, Quote.class);
            log.info(quote.toString());
        };
    }

}