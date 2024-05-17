package com.example.mobile_project.repository;

import com.example.mobile_project.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
