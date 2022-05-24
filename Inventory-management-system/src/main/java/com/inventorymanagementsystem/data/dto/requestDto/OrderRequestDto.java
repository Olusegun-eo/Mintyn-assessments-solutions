package com.inventorymanagementsystem.data.dto.requestDto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderRequestDto {

    private Long orderId;
    private BigDecimal orderAmount;
    private String CustomerId;
    private double totalOrder;
    private String address;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String customerPhoneNumber;
}
