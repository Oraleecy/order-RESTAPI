package com.restapi.services.impl;

import com.restapi.controllers.exceptions.OrderNotFoundException;
import com.restapi.models.ProductOrder;
import com.restapi.models.ProductOrderKey;
import com.restapi.repositories.ProductOrderRepository;
import com.restapi.services.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class ProductOrderServiceImpl implements ProductOrderService {
    private final ProductOrderRepository productOrderRepository;

    @Autowired
    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    public List<ProductOrder> getAllOrders() {
        return productOrderRepository.findAll();
    }
    public ProductOrder getOrderWithProductOrder(ProductOrderKey productOrderKey) {
        return productOrderRepository.getReferenceById(productOrderKey);
    }

    public List<ProductOrder> getOrder(Long id) {
        return productOrderRepository.findByProductOrderKeyOrderId(id);
    }

    @Transactional
    public void deleteOrder(Long productId) {
        productOrderRepository.deleteAllByProductId(productId);
    }

    @Transactional
    public void deleteByOrderId(Long orderId) {
        productOrderRepository.deleteByOrderId(orderId);
    }

}
