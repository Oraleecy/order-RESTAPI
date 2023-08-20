package com.restapi.models;


import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "date_of_creation")
    Date dateOfCreation;
    @Column(name = "status")
    Boolean status;


    public Order() {
    }

    public Order(Date dateOfCreation, Boolean status, List<ProductOrder> productOrders) {
        this.dateOfCreation = dateOfCreation;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
