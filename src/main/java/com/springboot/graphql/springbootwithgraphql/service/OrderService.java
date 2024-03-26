package com.springboot.graphql.springbootwithgraphql.service;

import com.springboot.graphql.springbootwithgraphql.entity.Order;
import com.springboot.graphql.springbootwithgraphql.entity.User;
import com.springboot.graphql.springbootwithgraphql.helper.CustomException;
import com.springboot.graphql.springbootwithgraphql.repository.OrderRepo;
import com.springboot.graphql.springbootwithgraphql.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
    public Order getSingleOrder(int id) {
        Order order = orderRepo.findById(id).orElseThrow(CustomException::throwResourceNotFoundException);
        return order;
    }
    public boolean deleteOrder(int id) {
        Order order = orderRepo.findById(id).orElseThrow(CustomException::throwResourceNotFoundException);
        this.orderRepo.delete(order);
        return true;
    }
    public Order updateOrder(int orderId, String orderDetail, String address, int price) throws Exception {
        Order order = orderRepo.findById(orderId).orElseThrow(CustomException::throwResourceNotFoundException);
        if (order == null) {
            throw new Exception("Order not found");
        }
        order.setOrderDetail(orderDetail);
        order.setPrice(price);
        order.setAddress(address);
        this.orderRepo.save(order);
        return order;
    }

}
