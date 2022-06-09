package com.inventorymanagementsystem.web.controller;


import com.inventorymanagementsystem.data.dto.requestDto.OrderRequestDto;
import com.inventorymanagementsystem.data.model.Order;
import com.inventorymanagementsystem.data.repository.OrderRepository;
import com.inventorymanagementsystem.service.orderService.OrderServiceImpl;
import com.inventorymanagementsystem.web.exceptions.BusinessLogicException;
import com.inventorymanagementsystem.web.exceptions.ProductDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/vi/order-amount")
public class OrderController {

//    public List<Order> totalAmountOfOrder = new ArrayList<>();
//
//    public static long toMilliSeconds(long day){
//        return day * 24 * 60 * 60 * 1000;
//    }
    @Autowired
    OrderServiceImpl orderServiceImpl;

//    CartUpdateDto responseDto;

    @PostMapping("")
    public ResponseEntity<?> addOderTogether(@RequestBody OrderRequestDto orderRequestDto) {
        OrderRespensoDto orderResponseDto = null;
        try {
            OrderRespensoDto = cartServiceImpl.addOderTogether(orderRequestDto);
//
        } catch (BusinessLogicException | IllegalArgumentException | UserNotFoundException | ProductDoesNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(orderResponseDto);
    }

    @PatchMapping("")
    public ResponseEntity<?> updateCartItems(@RequestBody OrderUpdate orderUpdateDto){
        try {
            OrderRespensoDto responseDto = orderServiceImpl.updateCartItem(orderUpdateDto);
            return ResponseEntity.ok().body(responseDto);
        } catch(UserNotFoundException | BusinessLogicException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewOrderById(@PathVariable("id") Long id){
        try{
            CartResponseDto responseDto= orderServiceImpl.viewCart(id);
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        }catch (UserNotFoundException | BusinessLogicException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}







