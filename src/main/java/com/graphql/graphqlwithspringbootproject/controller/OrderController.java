package com.graphql.graphqlwithspringbootproject.controller;

import com.graphql.graphqlwithspringbootproject.model.Order;
import com.graphql.graphqlwithspringbootproject.model.User;
import com.graphql.graphqlwithspringbootproject.service.OrderService;
import com.graphql.graphqlwithspringbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @MutationMapping(name = "createOrder")
    public Order createOrder(@Argument String orderDetail, @Argument String address, @Argument int price, @Argument int userId){
        // Fetch the user using userId
        User user = userService.getDataById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Create and set order details
        Order order = new Order();
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);

        return orderService.createData(order);
    }


    @QueryMapping(name = "getOrders")
    public List<Order> getAllData(){
        return orderService.getAllData();
    }


    @QueryMapping(name = "getOrder")
    public Optional<Order> getDataById(@Argument int orderId){
        return orderService.getDataById(orderId);
    }



    @MutationMapping(name = "deleteOrder")
    public String deleteData(@Argument int orderId){
        return orderService.deleteData(orderId);
    }


    @MutationMapping(name = "editOrder")
    public Order editOrder(@Argument String orderDetail, @Argument String address, @Argument int price, @Argument int userId,@Argument int orderId){

        User user = userService.getDataById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        // Create and set order details
        Order order = new Order();
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);

        return orderService.editOrder(order,orderId);
    }
}
