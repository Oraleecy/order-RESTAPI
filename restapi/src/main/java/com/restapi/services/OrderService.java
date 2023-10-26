package com.restapi.services;

import com.restapi.models.Order;
import com.restapi.models.StatusOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<Order> getOrderById(Long id);

    List<Order> getAllOrders();

    void updateStatus(Long id, StatusOrder status);

    void deleteOrderById(Long id);
}
