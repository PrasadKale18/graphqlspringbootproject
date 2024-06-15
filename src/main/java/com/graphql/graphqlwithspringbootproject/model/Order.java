package com.graphql.graphqlwithspringbootproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private String orderDetail;

    private String address;

    private int price;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
