package com.aliya.E_commerce.dto;

import com.aliya.E_commerce.model.User;

import java.util.Date;
import java.util.List;

public class OrderDTO {

    private Long id;


    private double totalAmount;

    private String status;

    private Date orderDate;

    private String userName;

    private String email;

    private List<OrderItemDTO> orderItems;

    public OrderDTO(Long id, double totalAmount, String status, Date orderDate,String  userName,String email, List<OrderItemDTO> orderItems) {
        this.id = id;
        this.userName = userName;
        this.totalAmount = totalAmount;
        this.status = status;
        this.orderDate = orderDate;
        this.email=email;
        this.orderItems = orderItems;
    }
    public OrderDTO(Long id, double totalAmount, String status, Date orderDate, List<OrderItemDTO> orderItems) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.status = status;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItem(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
