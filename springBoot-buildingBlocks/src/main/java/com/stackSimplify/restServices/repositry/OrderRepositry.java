package com.stackSimplify.restServices.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackSimplify.restServices.entities.Order;

public interface OrderRepositry extends JpaRepository<Order,Long>{

}
