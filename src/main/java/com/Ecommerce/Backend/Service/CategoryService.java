package com.Ecommerce.Backend.Service;

import DTO.CategoryDto;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    public List<CategoryDto> getAllCategories() throws IOException;
}
