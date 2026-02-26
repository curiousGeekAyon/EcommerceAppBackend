package com.Ecommerce.Backend.Service;

import DTO.CategoryDto;
import com.Ecommerce.Backend.Gateway.CategoryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeApiCategoryService implements CategoryService{
    @Autowired
    CategoryGateway iCategoryGateway;
    @Override
    public List<CategoryDto> getAllCategories() throws IOException {
        return iCategoryGateway.getAllCategory();
    }
}
