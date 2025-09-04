package com.spring.task5.Repository;

import com.spring.task5.DTOS.ProductDto;
import com.spring.task5.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products,Integer> {
    boolean existsByName(String name);
}
