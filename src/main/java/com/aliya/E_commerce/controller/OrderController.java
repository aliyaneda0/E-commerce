package com.aliya.E_commerce.controller;


import com.aliya.E_commerce.dto.OrderDTO;
import com.aliya.E_commerce.model.OrderRequest;
import com.aliya.E_commerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {


    @Autowired
    private OrderService orderService ;

    @PostMapping("/place/{userId}")
    public OrderDTO placeOrder(@PathVariable  Long userId, @RequestBody OrderRequest orderRequest)
    {
        return orderService.placeOrder(userId,orderRequest.getProductQuantities(),orderRequest.getTotalAmount());
    }

    @GetMapping("/all-orders")
    public List<OrderDTO> getAllOrders (){
return orderService.getAllOrders();

    }

}
