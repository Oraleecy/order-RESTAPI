package com.restapi.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;


import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date_of_creation")
    private Date dateOfCreation;


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusOrder status;

    @OneToMany(mappedBy = "order")
    private List<ProductOrder> ProductOrders;

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

    public List<ProductOrder> getProductOrders() {
        return ProductOrders;
    }

    public void setOrders(List<ProductOrder> orders) {
        this.ProductOrders = orders;
    }
}
