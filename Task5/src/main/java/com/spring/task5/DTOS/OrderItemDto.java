package com.spring.task5.DTOS;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDto {
    private int id;

    @NotNull
    private int productId;

    @NotNull
    @Min(1)
    private int quantity;
}
