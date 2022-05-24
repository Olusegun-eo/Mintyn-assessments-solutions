package com.areportapplication;




import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenersImpl {

    @KafkaListener(topics = "mintyn-inventory-management-system", groupId = "uniqueId")
    void listener(String data){
        System.out.println("Total Amount ordered received" + data + " :)");
    }
}