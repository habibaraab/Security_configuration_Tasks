package com.spring.task5.Service;


import com.spring.task5.DTOS.CategoryDto;
import com.spring.task5.DTOS.Mapper.CategoryMapper;
import com.spring.task5.Model.Category;
import com.spring.task5.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category=categoryMapper.toEntity(categoryDto);
        categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).collect(Collectors.toList());
    }

    public CategoryDto getCategoryById(int id) {
        return categoryRepository.findById(id).map(categoryMapper::toDto).orElseThrow(()->new RuntimeException("Category not found with id "+id));
    }
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        Category category=categoryRepository.findById(categoryDto.getId()).orElseThrow(()->new RuntimeException("Category not found with id "+categoryDto.getId()));
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return categoryMapper.toDto(categoryRepository.save(category));
    }
    public void deleteCategory(int id) {

        if(!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found with id "+id);
        }
        categoryRepository.deleteById(id);
    }
}
