package com.restapi.repositories;

import com.restapi.models.ProductOrder;
import com.restapi.models.ProductOrderKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, ProductOrderKey> {
    List<ProductOrder> findByProductOrderKeyOrderId(Long orderId);
    void deleteAllByProductId(Long productId);
    void deleteByOrderId(Long orderId);
}
