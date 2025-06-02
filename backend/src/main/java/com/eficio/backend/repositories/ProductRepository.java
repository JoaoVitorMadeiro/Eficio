package com.eficio.backend.repositories;

import com.eficio.backend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByQuantityLessThanEqual(Integer minQuantity);
    List<Product> findByCategory(String category);
} 