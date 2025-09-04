package com.spring.task5.DTOS;


import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.context.annotation.Scope;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private int id;
    @NotBlank(message = "name is required")
    private String name;
    private String description;
}
