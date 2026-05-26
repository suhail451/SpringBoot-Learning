package com.codewithkeertan.store.repositories;

import com.codewithkeertan.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}