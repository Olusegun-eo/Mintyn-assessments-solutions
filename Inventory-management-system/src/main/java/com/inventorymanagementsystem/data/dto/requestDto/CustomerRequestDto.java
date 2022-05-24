package com.inventorymanagementsystem.data.dto.requestDto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String customerPhoneNumber;
    private String address;

}
