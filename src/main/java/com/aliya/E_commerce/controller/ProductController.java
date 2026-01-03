package com.aliya.E_commerce.controller;

import com.aliya.E_commerce.model.Product;
import com.aliya.E_commerce.service.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {


    private ProductService productService;

 @GetMapping
 List<Product> getAllProducts(){
     return productService.getAllProducts();
 }
}
