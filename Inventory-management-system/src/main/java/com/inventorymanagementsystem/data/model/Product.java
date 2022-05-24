package com.inventorymanagementsystem.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    @Column(name = "",  nullable= false)
    private String productName;
    private int productQuantity;
    private String productDescription;
    private double productPrice;
    private String batchId;
    private String imageUrl;
}
