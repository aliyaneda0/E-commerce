package com.aliya.E_commerce.controller;

import com.aliya.E_commerce.model.Product;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

List<Product>getAllProducts()
}
