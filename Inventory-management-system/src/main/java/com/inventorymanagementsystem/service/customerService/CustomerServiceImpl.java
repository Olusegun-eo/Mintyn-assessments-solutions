package com.inventorymanagementsystem.service.customerService;

import com.inventorymanagementsystem.data.dto.requestDto.CustomerRequestDto;
import com.inventorymanagementsystem.data.dto.responseDto.CustomerResponseDto;
import com.inventorymanagementsystem.data.model.Customer;
import com.inventorymanagementsystem.data.repository.CustomerRepository;
import com.inventorymanagementsystem.web.exceptions.CustomerAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final String ERROR_MESSAGE = "User already exist";

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) throws CustomerAlreadyExistsException {

        Optional<Customer> savedCustomer = customerRepository.findByEmail(customerRequestDto.getEmail());
        if (savedCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("User already exist");
        }
//        create an App user Object
        Customer newCustomer = new Customer();
        newCustomer.setEmail(customerRequestDto.getEmail());
//        newUser.setPassword(bCryptPasswordEncoder.encode(appUserRequestDto.getPassword()));
        newCustomer.setFirstName(customerRequestDto.getFirstName());
        newCustomer.setLastName(customerRequestDto.getLastName());
        newCustomer.setAddress(customerRequestDto.getAddress());
//        save object
        customerRepository.save(newCustomer);
//        return response
        return null;
    }


    private CustomerResponseDto buildCustomerResponse(Customer customer) {
        return CustomerResponseDto.builder().firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .customerPhoneNumber(customer.getCustomerPhoneNumber()).build();

    }
}