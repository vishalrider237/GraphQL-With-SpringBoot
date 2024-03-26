package com.springboot.graphql.springbootwithgraphql.helper;

public interface CustomException {
    public static RuntimeException throwResourceNotFoundException(){
        return new RuntimeException("Resource not found");
    }
}
