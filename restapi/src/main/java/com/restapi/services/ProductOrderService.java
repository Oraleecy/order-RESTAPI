package com.restapi.services;

import com.restapi.models.ProductOrder;
import org.springframework.data.jpa.repository.Query;

public interface ProductOrderService {
    @Query(value = "DELETE FROM product_order WHERE product_id = ?", nativeQuery = true)
    void deleteOrder(Long id);

//    @Query(value = "DELETE FROM product_order WHERE order_id = ?", nativeQuery = true)
    void deleteByOrderId(Long orderId);
}
