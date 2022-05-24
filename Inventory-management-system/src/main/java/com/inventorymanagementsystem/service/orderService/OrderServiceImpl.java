package com.inventorymanagementsystem.service.orderService;


import com.inventorymanagementsystem.data.dto.requestDto.OrderRequestDto;
import com.inventorymanagementsystem.data.model.Order;
import com.inventorymanagementsystem.data.model.Product;
import com.inventorymanagementsystem.data.repository.OrderRepository;
import com.inventorymanagementsystem.data.repository.ProductRepository;
import com.inventorymanagementsystem.web.exceptions.ProductDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order placeOrder(OrderRequestDto orderRequestDto, Long productId) throws ProductDoesNotExistException {
        if(productId == null) throw new IllegalArgumentException("Id can not be null");
        Optional<Product> queryResult = productRepository.findByProductId(productId);
        if(queryResult.isPresent()) {
            throw new ProductDoesNotExistException("Product with ID: " + productId + "does not not exist");
        }

        Order newOrder = new Order();
        newOrder.setOrderId(orderRequestDto.getOrderId());
        newOrder.setCustomerId(orderRequestDto.getCustomerId());

        return orderRepository.save(newOrder);
    }

    public double totalOrderAmount(Order order, double price) {
        List<Order> customerOrder = new ArrayList<>();

        return 854.93;
    }

    private Double calculateOrderPrice(Order order){
        return order.getProduct().getProductPrice() * order.getQuantityAdded();
    }


}
