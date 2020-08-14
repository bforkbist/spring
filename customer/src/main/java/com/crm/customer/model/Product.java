package com.crm.customer.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @NotNull
    private String name;

    public Long getProductId() {
        return productId;
    }

    @Column
    @NotNull
    private long quantity;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
//    @JsonIgnore
    private List<Order> orderListProduct;

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public List<Order> getOrderListProduct() {
        return orderListProduct;
    }

    public void setOrderListProduct(List<Order> orderListProduct) {
        this.orderListProduct = orderListProduct;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
