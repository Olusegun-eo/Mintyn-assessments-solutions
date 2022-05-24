package com.inventorymanagementsystem.web.controller;


import com.inventorymanagementsystem.data.model.Order;
import com.inventorymanagementsystem.data.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping
public class OrderController {


    public List<Order> totalAmountOfOrder = new ArrayList<>();



    public static long toMilliSeconds(long day){
        return day * 24 * 60 * 60 * 1000;
    }



}
