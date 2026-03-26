package com.shopwave.repository;

import com.shopwave.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCat_Id(Long categoryId);
    List<Product> findByPriceLessThanEqual(BigDecimal maxPrice);
    List<Product> findByNameContainingIgnoreCase(String keyword);
    Product findTopByOrderByPriceDesc();
}