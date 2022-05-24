package com.inventorymanagementsystem.service.orderService;

import com.inventorymanagementsystem.data.dto.requestDto.OrderRequestDto;
import com.inventorymanagementsystem.data.model.Order;
import com.inventorymanagementsystem.data.model.Product;
import com.inventorymanagementsystem.web.exceptions.ProductDoesNotExistException;

public interface OrderService {
    Order placeOrder(OrderRequestDto orderRequestDto, Long productId) throws ProductDoesNotExistException;

}
