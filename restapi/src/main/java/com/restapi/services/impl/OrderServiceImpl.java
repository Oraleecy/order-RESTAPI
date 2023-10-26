package com.restapi.services.impl;

import com.restapi.models.Order;
import com.restapi.models.StatusOrder;
import com.restapi.repositories.OrderRepository;
import com.restapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public void updateStatus(Long id, StatusOrder status) {
        Order order = orderRepository.findById(id).orElse(null);
        assert (order != null);
        order.setStatus(status );
    }

    @Override
    @Transactional
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
