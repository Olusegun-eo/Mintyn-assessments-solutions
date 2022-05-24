package com.inventorymanagementsystem.service.customerService;

import com.inventorymanagementsystem.data.dto.requestDto.CustomerRequestDto;
import com.inventorymanagementsystem.data.dto.responseDto.CustomerResponseDto;
import com.inventorymanagementsystem.web.exceptions.CustomerAlreadyExistsException;

public interface CustomerService {
    CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) throws CustomerAlreadyExistsException;

}
