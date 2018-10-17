package com.example.test1.persistence;

import com.example.test1.domain.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<BasketProduct,Long> {
}
