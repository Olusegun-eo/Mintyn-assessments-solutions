package com.inventorymanagementsystem.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private BigDecimal orderAmount;
    private String CustomerId;
    private String address;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String customerPhoneNumber;
    private Integer quantityAdded;

    @OneToOne(fetch = FetchType.EAGER)
    private Product product;

//    productId, and OrderRequestDto



    public void setQuantityAddedCart(Integer quantityAdded) {
        if (product.getProductQuantity() >= quantityAdded) {
            this.quantityAdded = quantityAdded;
        }else this.quantityAdded = 0;
    }

}
