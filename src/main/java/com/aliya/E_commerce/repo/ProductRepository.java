package com.aliya.E_commerce.repo;

import com.aliya.E_commerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
