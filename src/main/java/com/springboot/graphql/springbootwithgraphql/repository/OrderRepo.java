package com.springboot.graphql.springbootwithgraphql.repository;

import com.springboot.graphql.springbootwithgraphql.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
}
