package com.graphql.graphqlwithspringbootproject.service;

import com.graphql.graphqlwithspringbootproject.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order createData(Order order);

    List<Order> getAllData();

    Optional<Order> getDataById(int orderId);

    String deleteData(int orderId);

    Order editOrder(Order order, int orderId);
}
