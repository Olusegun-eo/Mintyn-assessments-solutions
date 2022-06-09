package com.areportapplication.web;

import com.areportapplication.model.ReportRequest;
import com.areportapplication.model.TotalOrder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public ReportController( KafkaTemplate<String, String> kafkaTemplate ) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publishReport(@RequestBody ReportRequest reportRequest){
        kafkaTemplate.send("mintyn-inventory-management-system", reportRequest.message());
    }
    @PostMapping("{report}")
    public List<Object> getCatalogReport(@PathVariable("userId") String userId){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForEntity("localhost:8080/api/v1/order-amount", Object.class);

        List<TotalOrder> amount = Arrays.asList();

        return Arrays.asList(amount.toArray());
    }
}
