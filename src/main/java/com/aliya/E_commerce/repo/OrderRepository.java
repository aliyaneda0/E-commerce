package com.aliya.E_commerce.repo;


import com.aliya.E_commerce.model.Orders;
import com.aliya.E_commerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {

     @Query("Select o from Orders o Join Fetch o.user")   //JpA query
     List<Orders> findAllOrdersWithUsers();

    List<Orders> findByUser(User user);
}
