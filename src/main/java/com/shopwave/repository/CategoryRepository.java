package com.shopwave.repository;

// Name: Yared Kiros
// ID: ATE/7702/14

import com.shopwave.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}