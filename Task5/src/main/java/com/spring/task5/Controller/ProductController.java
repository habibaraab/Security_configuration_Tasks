package com.spring.task5.Controller;


import com.spring.task5.DTOS.ProductDto;
import com.spring.task5.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @PostMapping("/addProduct")
    public ResponseEntity<ProductDto>createProduct(@RequestBody ProductDto productDto){
        ProductDto savedProduct = productService.addProduct(productDto);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        productService.getAllProducts();
        return ResponseEntity.ok(productService.getAllProducts());
    }

}
