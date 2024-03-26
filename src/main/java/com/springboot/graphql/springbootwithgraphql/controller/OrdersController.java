package com.springboot.graphql.springbootwithgraphql.controller;

import com.springboot.graphql.springbootwithgraphql.entity.Order;
import com.springboot.graphql.springbootwithgraphql.entity.User;
import com.springboot.graphql.springbootwithgraphql.service.OrderService;
import com.springboot.graphql.springbootwithgraphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrdersController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @MutationMapping
    public Order createOrder(@Argument String orderDetail, @Argument String address, @Argument Integer price,@Argument int userId){
        User user =userService.getSingleUser(userId);
        Order order = new Order();
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUsers(user);
        Order order1=orderService.saveOrder(order);
        return order1;
    }
    @QueryMapping
    public List<Order> getOrders(){
        return this.orderService.getAllOrders();
    }
    @QueryMapping
    public Order getOrder(@Argument int orderId){
        return this.orderService.getSingleOrder(orderId);
    }
    @MutationMapping
    public  boolean deleteOrder(@Argument int orderId){
        return this.orderService.deleteOrder(orderId);
    }
    @MutationMapping
    public Order updateOrder(@Argument int orderId,@Argument String orderDetail,@Argument String address,@Argument int price) throws Exception {
        return this.orderService.updateOrder(orderId,orderDetail,address,price);
    }
}
