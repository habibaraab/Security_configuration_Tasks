package com.spring.task5.DTOS.Mapper;


import com.spring.task5.DTOS.OrderItemDto;
import com.spring.task5.Model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    @Mapping(target = "product.id", source = "productId")
    OrderItem toEntity(OrderItemDto dto);

    @Mapping(target = "productId", source = "product.id")
    OrderItemDto toDto(OrderItem entity);

}
