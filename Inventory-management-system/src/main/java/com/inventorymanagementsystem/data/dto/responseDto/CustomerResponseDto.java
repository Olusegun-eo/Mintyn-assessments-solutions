package com.inventorymanagementsystem.data.dto.responseDto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponseDto {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String customerPhoneNumber;
}
