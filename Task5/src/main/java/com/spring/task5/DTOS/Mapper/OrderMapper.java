package com.spring.task5.DTOS.Mapper;


import com.spring.task5.DTOS.OrderDto;
import com.spring.task5.Model.Orders;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrderItemMapper.class})
public interface OrderMapper {

    OrderDto toDto(Orders e);
}
