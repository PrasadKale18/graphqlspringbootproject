package com.graphql.graphqlwithspringbootproject.service.Impl;

import com.graphql.graphqlwithspringbootproject.model.Order;
import com.graphql.graphqlwithspringbootproject.repository.OrderRepository;
import com.graphql.graphqlwithspringbootproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createData(Order order){
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllData(){
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getDataById(int orderId){
        return orderRepository.findById(orderId);
    }


    @Override
    public String deleteData(int orderId){
        orderRepository.deleteById(orderId);
        return "Order Delete Successfully";
    }



    @Override
    public Order editOrder(Order order, int orderId){
        Optional<Order> existOrder = orderRepository.findById(orderId);
        if(existOrder.isPresent()){
            Order update = existOrder.get();
            update.setOrderDetail(order.getOrderDetail());
            update.setAddress(order.getAddress());
            update.setPrice(order.getPrice());
            update.setUser(order.getUser());

            return orderRepository.save(update);
        }else {
            return null;
        }
    }
}
