package com.learnwithvjk.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwithvjk.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
