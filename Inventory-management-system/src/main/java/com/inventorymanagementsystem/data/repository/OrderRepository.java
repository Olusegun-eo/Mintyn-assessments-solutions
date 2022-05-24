package com.inventorymanagementsystem.data.repository;

import com.inventorymanagementsystem.data.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
