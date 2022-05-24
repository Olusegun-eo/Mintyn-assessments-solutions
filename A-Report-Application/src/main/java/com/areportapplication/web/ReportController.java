package com.areportapplication.web;

import com.areportapplication.model.ReportRequest;
import com.areportapplication.model.TotalOrder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
        restTemplate.getForEntity("http://localhost:8080/orderAmount", Object.class);

        List<TotalOrder> amount = Arraays.asList();

        return "iu";
    }
}
