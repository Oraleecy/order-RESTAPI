package com.restapi.services;


import com.restapi.repositories.OrderRepository;
import com.restapi.repositories.ProductOrderRepository;
import com.restapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    private final ProductOrderRepository productOrderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        ProductRepository productRepository,
                        ProductOrderRepository productOrderRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.productOrderRepository = productOrderRepository;
    }


}
