package com.restapi.controllers;

import com.restapi.models.Order;
import com.restapi.services.impl.OrderServiceImpl;
import com.restapi.services.impl.ProductOrderServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Заказы", description = "Управление заказами")
public class OrderController {
    private final OrderServiceImpl orderService;
    private final ProductOrderServiceImpl productOrderService;


    @Autowired
    public OrderController(OrderServiceImpl orderService, ProductOrderServiceImpl productOrderService) {
        this.orderService = orderService;
        this.productOrderService = productOrderService;
    }

    @GetMapping()
    @Operation(
            summary = "Вывод всех заказов",
            description = "Вывод всех заказов"
    )
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{order_id}")
    @Operation(
            summary = "Вывод заказа по ID",
            description = "Вывод заказа по ID"
    )
    public Order getOrderById(@PathVariable("order_id") Long orderId) {
        return orderService.getOrderById(orderId).orElse(null);
    }

    @DeleteMapping("/{order_id}/delete")
    @Operation(
            summary = "Удаление заказа по ID",
            description = "Удаление заказа по ID"
    )
    public void DeleteOrder(@PathVariable("order_id") Long orderId) {
        productOrderService.deleteByOrderId(orderId);
        orderService.deleteOrderById(orderId);
    }
}
