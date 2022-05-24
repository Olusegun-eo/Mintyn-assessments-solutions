package com.inventorymanagementsystem.web.controller;


import com.inventorymanagementsystem.data.dto.requestDto.CustomerRequestDto;
import com.inventorymanagementsystem.data.dto.responseDto.CustomerResponseDto;
import com.inventorymanagementsystem.service.customerService.CustomerService;
import com.inventorymanagementsystem.web.exceptions.CustomerAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping()
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        try {
            CustomerResponseDto responseDto = customerService.createCustomer(customerRequestDto);
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        }catch (CustomerAlreadyExistsException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
