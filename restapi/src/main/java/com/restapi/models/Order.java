package com.restapi.models;


import jakarta.persistence.*;


import java.util.Date;
import java.util.List;


@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "date_of_creation")
    Date dateOfCreation;
    @Column(name = "status")
    StatusOrder status;

    @OneToMany(mappedBy = "order")
    List<ProductOrder> orders;

    public Order() {
    }

    public Order(Date dateOfCreation, StatusOrder status) {
        this.dateOfCreation = dateOfCreation;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public StatusOrder getStatus() {
        return status;
    }

    public void setStatus(StatusOrder status) {
        this.status = status;
    }

    public List<ProductOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<ProductOrder> orders) {
        this.orders = orders;
    }
}
