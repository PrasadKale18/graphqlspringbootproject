package com.graphql.graphqlwithspringbootproject.repository;

import com.graphql.graphqlwithspringbootproject.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
