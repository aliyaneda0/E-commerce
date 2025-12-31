package com.aliya.E_commerce.service;


import com.aliya.E_commerce.dto.OrderDTO;
import com.aliya.E_commerce.dto.OrderItemDTO;
import com.aliya.E_commerce.model.OrderItem;
import com.aliya.E_commerce.model.Orders;
import com.aliya.E_commerce.model.Product;
import com.aliya.E_commerce.model.User;
import com.aliya.E_commerce.repo.OrderRepository;
import com.aliya.E_commerce.repo.ProductRepository;
import com.aliya.E_commerce.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public OrderDTO placeOrder(Long userId, Map<Long, Integer> productQuantities, double totalAmount){
        User user = userRepository.findById(userId)     //finding user by userid
                .orElseThrow(()->new RuntimeException("User not found"));

        Orders order = new Orders();
        order.setUser(user);
        order.setOrderDate(new Date());
        order.setStatus("Pending");
        order.setTotalAmount(totalAmount);

        List< OrderItem> orderItems= new ArrayList<>();
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();


        for(Map.Entry<Long,Integer> entry :productQuantities.entrySet())
        {
            Product product = productRepository.findById(entry.getKey())   //finding product by product id
                    .orElseThrow(()->new RuntimeException("Product not found "));

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(entry.getValue());
            orderItems.add(orderItem);

        }
    }
}
