package com.spring.task5.DTOS.Mapper;


import com.spring.task5.DTOS.ProductDto;
import com.spring.task5.Model.Products;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface productMapper {
    @Mapping(target = "category.id", source = "categoryId")
    Products toEntity(ProductDto dto);

    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Products entity);
}
