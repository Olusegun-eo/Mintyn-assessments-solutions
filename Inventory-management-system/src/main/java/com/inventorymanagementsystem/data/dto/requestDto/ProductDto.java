package com.inventorymanagementsystem.data.dto.requestDto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class ProductDto {

    private Long productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productQuantity;
    private MultipartFile image;
    private String batchId;
}
