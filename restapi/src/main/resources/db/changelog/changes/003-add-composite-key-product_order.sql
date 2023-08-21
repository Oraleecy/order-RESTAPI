ALTER TABLE product_order
    ADD CONSTRAINT product_order_pk
        PRIMARY KEY (order_id, product_id);