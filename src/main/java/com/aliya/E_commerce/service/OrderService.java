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

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;


    public OrderDTO placeOrder(Long userId, Map<Long, Integer> productQuantities, double totalAmount) {
        User user = userRepository.findById(userId)     //finding user by userid
                .orElseThrow(() -> new RuntimeException("User not found"));

        Orders order = new Orders();
        order.setUser(user);
        order.setOrderDate(new Date());
        order.setStatus("Pending");
        order.setTotalAmount(totalAmount);

        List<OrderItem> orderItems = new ArrayList<>();
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();


        for (Map.Entry<Long, Integer> entry : productQuantities.entrySet()) {
            Product product = productRepository.findById(entry.getKey())   //finding product by product id
                    .orElseThrow(() -> new RuntimeException("Product not found "));

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(entry.getValue());
            orderItems.add(orderItem);

            orderItemDTOS.add(new OrderItemDTO(product.getName(), product.getPrice(), entry.getValue()));

        }

        order.setOrderItems(orderItems);

        Orders saveOrder =  orderRepository.save(order);

        return new OrderDTO(saveOrder.getId(), saveOrder.getTotalAmount(), saveOrder.getStatus(),saveOrder.getOrderDate(),orderItemDTOS);
    }

    public List<OrderDTO> getAllOrders() {
      List<Orders> orders =   orderRepository.findAllOrdersWithUsers();
      return orders.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private OrderDTO convertToDTO(Orders orders) {
        List<OrderItemDTO> OrderItems  =  orders.getOrderItems().stream()
              .map(item->new OrderItemDTO(
                      item.getProduct().getName(),
                      item.getProduct().getPrice(),
                      item.getQuantity())).collect(Collectors.toList());

        return new OrderDTO(
                orders.getId(),
                orders.getTotalAmount(),
                orders.getStatus()!=null? orders.getStatus():"Uknown",
                orders.getOrderDate(),
                orders.getUser()!=null? orders.getUser().getName():"Uknown",
                orders.getUser()!=null? orders.getUser().getEmail():"Uknown",
                OrderItems
        );
    }

    public List<OrderDTO> getOrderByUser(Long userId) {
        Optional<User> userOp = userRepository.findById(userId);
        if(userOp.isEmpty())
        {
            throw new RuntimeException("user not found");
        }
        User user = userOp.get();
        List <Orders> orderList = orderRepository.findByUser(user);
            return orderList.stream().map(this::convertToDTO).collect(Collectors.toList());

    }
}
