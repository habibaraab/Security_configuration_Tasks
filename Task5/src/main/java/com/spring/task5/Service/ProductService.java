package com.spring.task5.Service;


import com.spring.task5.DTOS.Mapper.productMapper;
import com.spring.task5.DTOS.ProductDto;
import com.spring.task5.Model.Category;
import com.spring.task5.Model.Products;
import com.spring.task5.Repository.CategoryRepository;
import com.spring.task5.Repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductsRepository productsRepository;
    private final CategoryRepository categoryRepository;
    private final productMapper mapper;



    public ProductDto addProduct(ProductDto productDto) {
        if (productsRepository.existsByName(productDto.getName())) {
            throw new RuntimeException("Product with this name already exists");
        }
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Products product=mapper.toEntity(productDto);
        product.setCategory(category);
        Products savedProduct= productsRepository.save(product);
        return mapper.toDto(savedProduct);
    }
    public List<ProductDto> getAllProducts() {
        return productsRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
    public ProductDto getProductById(int id) {
        Products p = productsRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with "+id));
        return mapper.toDto(p);    }

    public ProductDto update(int id, ProductDto dto) {
        Products existing = productsRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        Category cat = categoryRepository.findById(dto.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        existing.setName(dto.getName());
        existing.setPrice(dto.getPrice());
        existing.setStockQty(dto.getStockQty());
        existing.setCategory(cat);
        return mapper.toDto(productsRepository.save(existing));
    }

    public void delete(int id) {
        if (!productsRepository.existsById(id)) throw new RuntimeException("Product not found");
        productsRepository.deleteById(id);
    }
}

