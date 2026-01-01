package com.aliya.E_commerce.repo;


import com.aliya.E_commerce.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {

     @Query()
    void findAllOrderWithUsers();
}
