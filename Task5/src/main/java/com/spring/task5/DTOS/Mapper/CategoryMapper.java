package com.spring.task5.DTOS.Mapper;

import com.spring.task5.DTOS.CategoryDto;
import com.spring.task5.Model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toDto(Category e);
    Category toEntity(CategoryDto d);
}
