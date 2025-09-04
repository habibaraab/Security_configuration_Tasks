package com.spring.task5.DTOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private int id;

    private String status;

    @NotEmpty
    private List<OrderItemDto> items;
}