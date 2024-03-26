package com.springboot.graphql.springbootwithgraphql.repository;

import com.springboot.graphql.springbootwithgraphql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
